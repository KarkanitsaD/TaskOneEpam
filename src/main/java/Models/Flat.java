package Models;

import Models.Abstractions.ElectricalAppliance;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;
import java.util.Collections;
import java.util.LinkedList;
import java.util.stream.Collectors;


public class Flat implements Serializable {

    static final long serialVersionUID = 275913569010270492L;

    private static final Logger logger = LoggerFactory.getLogger(Flat.class);

    private final LinkedList<Socket> sockets = new LinkedList<Socket>();
    private final LinkedList<ElectricalAppliance> electricalAppliances = new LinkedList<ElectricalAppliance>();

    public int countAppliances(){
        return electricalAppliances.size();
    }
    public void addElectronicAppliance(ElectricalAppliance electricalAppliance){
        logger.info("User try to add new appliance");
        if(electricalAppliance.getSocket()!=null)
            throw new IllegalStateException("Appliance must not be connected to socket");
        electricalAppliances.add(electricalAppliance);
        logger.info("User add new appliance to flat");
    }
    public void removeAppliance(int applianceNumber){
        if(electricalAppliances.get(applianceNumber).getSocket() != null) throw new IllegalStateException("Appliance is connected to socket");
        electricalAppliances.remove(applianceNumber);
        logger.info("User remove appliance from flat");
    }
    public ElectricalAppliance getElectricalAppliance(int i){
        return electricalAppliances.get(i);
    }
    public void connectElectronicAppliance(int applianceNumber, int socketNumber){
        logger.info("User try to connect appliance and socket");
        electricalAppliances.get(applianceNumber).connectToSocket(sockets.get(socketNumber));
    }
    public void disconnectElectronicAppliance(int applianceNumber){
        logger.info("User try to disconnect appliance and socket");
        electricalAppliances.get(applianceNumber).disconnectFromSocket();
    }
    public LinkedList<ElectricalAppliance> getElectricalAppliancesByPower(int minPower, int maxPower){
        logger.info("User try to get appliances by power");
        return new LinkedList<ElectricalAppliance> (electricalAppliances.stream().filter(e->e.getPower()>=minPower && e.getPower()<=maxPower).collect(Collectors.toList()));
    }
    public LinkedList<ElectricalAppliance> getElectricalAppliancesByPrice(float minPrice, float maxPrice){
        logger.info("User try to get appliances by price");
        return new LinkedList<ElectricalAppliance>(electricalAppliances.stream().filter(e->e.getPrice()>=minPrice && e.getPrice()<=maxPrice).collect(Collectors.toList()));
    }
    public void sortAppliances(){
        logger.info("User sort appliances");
        Collections.sort(electricalAppliances);
    }

    public int countSockets(){
        return sockets.size();
    }
    public void addSocket(Socket socket){
        logger.info("User try add socket");
        if(socket.getElectricalAppliance()!=null)
            throw new IllegalStateException("Socket must be empty");
        sockets.add(socket);
        logger.info("User add socket");
    }
    public void removeSocket(int socketNumber){
        logger.info("User try to remove socket by index");
        if(sockets.get(socketNumber).getElectricalAppliance() != null) throw new IllegalStateException("Some appliance is connected to this socket");
        sockets.remove(socketNumber);
    }
    public void removeSocket(Socket socket){
        if(socket.getElectricalAppliance() == null) throw new IllegalStateException("Some appliance is connected to this socket");
        sockets.remove(socket);
    }
    public Socket getSocket(int i){
        logger.info("User try to get socket by index");
        return sockets.get(i);
    }


    @Override
    public String toString() {
        StringBuilder resultString  = new StringBuilder();


        resultString.append("Flat {\nSockets {\n");

        for (int i = 0; i < sockets.size(); i++){
            resultString.append("№").append(i + 1).append(" ").append(sockets.get(i).toString()).append("\n");
        }
        resultString.append("}\n");
        resultString.append("Appliances {\n");
        for (int i = 0; i < electricalAppliances.size(); i++){
            resultString.append("№").append(i + 1).append("\n").append("Socket №").append(sockets.indexOf(electricalAppliances.get(i).getSocket())+1).append('\n').append(electricalAppliances.get(i).toString()).append("\n");
        }
        resultString.append("}\n}");
        return resultString.toString();
    }
}
