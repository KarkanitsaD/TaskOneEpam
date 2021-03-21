package Models.Views;

import Models.Abstractions.ElectricalAppliance;
import Models.Enums.IronSole;
import Models.*;
import Models.Options.LightTemperatureRange;
import Models.Options.SizeOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class FlatView {

    private static final Logger logger = LoggerFactory.getLogger(FlatView.class);

    private final  Scanner in = new Scanner(System.in);
    private final ArrayList<String> commands = new ArrayList<String>();
    private final Flat flat;

    public FlatView(Flat flat){
        this.flat = flat;
        formCommands();
    }

    private void formCommands(){
        commands.add("1.ShowFlat");
        commands.add("2.AddAppliance");
        commands.add("3.AddSocket");
        commands.add("4.RemoveAppliance");
        commands.add("5.RemoveSocket");
        commands.add("6.ConnectAppliance");
        commands.add("7.DisconnectAppliance");
        commands.add("8.CountAppliances");
        commands.add("9.CountSockets");
        commands.add("10.SortAppliances");
        commands.add("11.FilterAppliancesByPower");
        commands.add("12.FilterAppliancesByPrice");
        commands.add("13.CalculateElectricityInSocket");
        commands.add("14.SaveFlat");
        commands.add("15.Exit");
    }
    public void  menu(){
        logger.info("Start menu");
        int command;
        do {
            System.out.println("Commands:\n" + commandsToString());
            do {
                System.out.println("Enter command: ");
                command = in.nextInt();
            } while (command <= 0 || command > commands.size());
            switch (command) {
                case 1 -> showFlat();
                case 2 -> addAppliance();
                case 3 -> addSocket();
                case 4 -> removeAppliance();
                case 5 -> removeSocket();
                case 6 -> connectAppliance();
                case 7 -> disconnectAppliance();
                case 8 -> countAppliances();
                case 9 -> countSockets();
                case 10 -> sortAppliances();
                case 11 -> filterAppliancesByPower();
                case 12 -> filterAppliancesByPrice();
                case 13 -> calculateElectricityInSocket();
                case 14 -> saveFlat();
            }
        }
        while (command!=15);
    }
    private String commandsToString(){
        StringBuilder resultString = new StringBuilder();
        for(String string: commands){
            resultString.append(string).append("\n");
        }
        return resultString.toString();
    }

    //main commands
    private void saveFlat(){
        logger.info("Try to save flat");
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("flat.dat", false)))
        {
            oos.writeObject(flat);
        }
        catch(Exception ex){
            logger.error("Some exception - ", ex);
            System.out.println(ex.getMessage());
        }
    }
    private void countSockets(){
        System.out.println(flat.countSockets());
    }
    private void countAppliances(){
        System.out.println(flat.countAppliances());
    }
    private void sortAppliances(){
        flat.sortAppliances();
    }
    private void removeSocket(){
        System.out.println("Enter socket number: ");
        flat.removeSocket(in.nextInt()-1);
    }
    private void addSocket(){
        logger.info("Try to add new socket");
        System.out.println("Enter the voltage of socket: ");
        Socket socket = new Socket(in.nextFloat());
        flat.addSocket(socket);
    }
    private void connectAppliance(){
        logger.info("Try to connect appliance");
        try {
            System.out.println("Enter appliance number: ");
            int appNumber = in.nextInt();
            System.out.println("Enter socket number: ");
            int sckNumber = in.nextInt();
            flat.connectElectronicAppliance(appNumber - 1, sckNumber - 1);
        }catch (Exception ex){
            logger.error("Some exception - ", ex);
            System.out.println(ex.getMessage());
        }
    }
    private void disconnectAppliance(){
        logger.info("Try to disconnect appliance");
        try{
            System.out.println("Enter appliance number: ");
            int appNumber = in.nextInt();
            flat.disconnectElectronicAppliance(appNumber-1);
        }catch (Exception ex){
            logger.error("Some exception - ", ex);
            System.out.println(ex.getMessage());
        }
    }
    private void removeAppliance(){
        logger.info("Try to remove appliance");
        try{
            System.out.println("Enter the number of appliznce: ");
            flat.removeAppliance(in.nextInt()-1);
        }catch (Exception ex){
            logger.error("Some exception - ", ex);
            System.out.println(ex.getMessage());
        }
    }
    private void addAppliance(){
        logger.info("Try to add new appliance");
        SizeOptions sizeOptions;
        float price;
        float weight;
        String color;
        int power;

        System.out.println("Choose type(enter number):\n1.Lighting \n2.Appliance ");
        int appType = in.nextInt();
        if(appType == 1){
            LightTemperatureRange lightTemperatureRange;
            System.out.println("Available devices(enter number): 1.TableLamp, 2.LEDStripLight ");
            int lightAppType = in.nextInt();
            if(lightAppType == 1){
                sizeOptions = enterSizeOptions();
                price = enterPrice();
                weight = enterWeight();
                color = enterColor();
                power = enterPower();
                lightTemperatureRange = enterLightTemperatureRange();
                System.out.println("Enter length of wire: ");
                float wireLength = in.nextFloat();
                TableLamp tableLamp = new TableLamp(sizeOptions, price,weight, lightTemperatureRange);
                tableLamp.setColor(color);
                tableLamp.setPower(power);
                tableLamp.setWireLength(wireLength);
                flat.addElectronicAppliance(tableLamp);
            }
            else if(lightAppType == 2){
                sizeOptions = enterSizeOptions();
                price = enterPrice();
                weight = enterWeight();
                color = enterColor();
                power = enterPower();
                lightTemperatureRange = enterLightTemperatureRange();
                System.out.println("Enter number od LEDs: ");
                int ledsNumber = in.nextInt();
                System.out.println("Set light color: ");
                String lightColor = in.nextLine();
                LEDStripLight ledStripLight = new LEDStripLight(sizeOptions, price, weight, lightTemperatureRange);
                ledStripLight.setLightColor(lightColor);
                ledStripLight.setColor(color);
                ledStripLight.setPower(power);
                ledStripLight.setLedsNumber(ledsNumber);
                flat.addElectronicAppliance(ledStripLight);
            }
        } else if (appType == 2) {
            float internalVolume;
            System.out.println("Available devices(enter number): 1.Fridge, 2.Iron 3.Microwave 4.VaccumCleaner");
            int domesticAppType = in.nextInt();
            switch (domesticAppType) {
                case 1 -> {
                    sizeOptions = enterSizeOptions();
                    price = enterPrice();
                    weight = enterWeight();
                    color = enterColor();
                    power = enterPower();
                    System.out.println("Enter inernal volume of frige: ");
                    internalVolume = in.nextFloat();
                    Fridge fridge = new Fridge(sizeOptions, price, weight, internalVolume);
                    fridge.setColor(color);
                    fridge.setPower(power);
                    flat.addElectronicAppliance(fridge);
                }
                case 2 -> {
                    sizeOptions = enterSizeOptions();
                    price = enterPrice();
                    weight = enterWeight();
                    color = enterColor();
                    power = enterPower();
                    System.out.println("Enter inernal water volume of iron: ");
                    internalVolume = in.nextFloat();
                    IronSole ironSole = enterIronSole();
                    Iron iron = new Iron(sizeOptions, price, weight, internalVolume);
                    iron.setSole(ironSole);
                    iron.setPower(power);
                    iron.setColor(color);
                    flat.addElectronicAppliance(iron);
                }
                case 3 -> {
                    sizeOptions = enterSizeOptions();
                    price = enterPrice();
                    weight = enterWeight();
                    color = enterColor();
                    power = enterPower();
                    System.out.println("Enter inernal water volume of Microwave: ");
                    internalVolume = in.nextFloat();
                    System.out.println("Enter pallet's diamter: ");
                    float diameter = in.nextFloat();
                    Microwave microwave = new Microwave(sizeOptions, price, weight, internalVolume);
                    microwave.setPalletDiameter(diameter);
                    microwave.setColor(color);
                    microwave.setPower(power);
                    flat.addElectronicAppliance(microwave);
                }
                case 4 -> {
                    sizeOptions = enterSizeOptions();
                    price = enterPrice();
                    weight = enterWeight();
                    color = enterColor();
                    power = enterPower();
                    System.out.println("Enter inernal volume of Vaccum cleaner: ");
                    internalVolume = in.nextFloat();
                    System.out.println("Enter length of wire: ");
                    float wireLength = in.nextFloat();
                    VaccumCleaner vaccumCleaner = new VaccumCleaner(sizeOptions, price, weight, internalVolume);
                    vaccumCleaner.setColor(color);
                    vaccumCleaner.setPower(power);
                    vaccumCleaner.setWireLength(wireLength);
                    flat.addElectronicAppliance(vaccumCleaner);
                }
            }
        }
    }
    private void showFlat(){
        System.out.println(flat);
    }
    private void filterAppliancesByPower(){
        try {
            System.out.println("Enter min power: ");
            int minPower = in.nextInt();
            System.out.println("Enter max power: ");
            int maxPower = in.nextInt();
            List<ElectricalAppliance> list = flat.getElectricalAppliancesByPower(minPower, maxPower);
            for(ElectricalAppliance ea : list){
                System.out.println(ea);
            }
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }
    private void filterAppliancesByPrice(){
        try {
            System.out.println("Enter min price: ");
            int minPrice = in.nextInt();
            System.out.println("Enter max price: ");
            int maxPrice = in.nextInt();
            List<ElectricalAppliance> list = flat.getElectricalAppliancesByPrice(minPrice, maxPrice);
            for(ElectricalAppliance ea : list){
                System.out.println(ea);
            }
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }
    private void calculateElectricityInSocket(){
        try {
            System.out.println("Enter number of socket: ");
            int socketNumber = in.nextInt();
            System.out.println(flat.getSocket(socketNumber -1).calculateElectricity());
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }

    //enter data commands
    private SizeOptions enterSizeOptions(){
        float height = 0;
        float width = 0;
        float depth = 0;
        System.out.println("Enter height: ");
        height = in.nextFloat();
        System.out.println("Enter width: ");
        width = in.nextFloat();
        System.out.println("Enter depth: ");
        depth = in.nextFloat();
        return new SizeOptions(height, width, depth);
    }
    private float enterPrice(){
        float price = 0;
        System.out.println("Enter price: ");
        price = in.nextFloat();
        return price;
    }
    private int enterPower(){
        System.out.println("Enter power: ");
        return in.nextInt();
    }
    private float enterWeight(){
        System.out.println("Enter weight: ");
        return in.nextFloat();
    }
    private String enterColor(){
        System.out.println("Enter color: ");
        return in.next();
    }
    private LightTemperatureRange enterLightTemperatureRange(){
        System.out.println("Enter minLightTemperature: ");
        int minLightTemperature = in.nextInt();
        System.out.println("Enter maxLightTemperature: ");
        int maxLightTemperature = in.nextInt();
        return new LightTemperatureRange(minLightTemperature, maxLightTemperature);
    }
    private IronSole enterIronSole(){
        System.out.println("Choose iron sole(enter number): 1.STAINLESS_STEEL 2.TEFLON 3.SINTERED_METAL");
        return switch (in.nextInt()) {
            case 1 -> IronSole.STAINLESS_STEEL;
            case 2 -> IronSole.TEFLON;
            case 3 -> IronSole.SINTERED_METAL;
            default -> IronSole.STAINLESS_STEEL;
        };
    }
}
