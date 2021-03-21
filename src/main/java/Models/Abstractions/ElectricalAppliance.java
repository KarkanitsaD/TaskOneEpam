package Models.Abstractions;
import Models.Options.SizeOptions;
import Models.Socket;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serial;
import java.io.Serializable;

public abstract class ElectricalAppliance implements Serializable, Comparable<ElectricalAppliance> {

    @Serial
    private static final long serialVersionUID = -8043885741759155750L;

    private static final Logger logger = LoggerFactory.getLogger(ElectricalAppliance.class);

    protected int power;
    protected float weight;
    protected float price;
    protected String color;
    protected final SizeOptions sizeOptions;
    protected Socket socket = null;
    protected boolean isConnected = false;

    public ElectricalAppliance(SizeOptions sizeOptions, float price, float weight){
        logger.info("Creating new " + this.getClass());
        this.sizeOptions = sizeOptions;
        this.price = price;
        this.weight = weight;
    }

    public boolean IsConnected(){
        return isConnected;
    }

    public int getPower() {
        return power;
    }
    public void setPower(int power) {
        this.power = power;
    }

    public float getWeight() {
        return weight;
    }

    public float getPrice() {
        return price;
    }
    public void setPrice(float price) {
        this.price = price;
    }

    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }

    public SizeOptions getSizeOptions() {
        return sizeOptions;
    }

    public void connectToSocket(Socket socket){
        logger.info("Try to connect " + this.getClass() + " to socket");
        if(this.socket != null) throw new IllegalStateException("Appliance is already connected to socket");
        if(socket.getElectricalAppliance() != null) throw new IllegalStateException("Other appliance is already connected to this socket");
        this.socket = socket;
        socket.setElectricalAppliance(this);
        isConnected = true;
    }
    public void disconnectFromSocket(){
        logger.info("Disconnect " + this.getSocket() + " from socket");
        isConnected = false;
        socket.takeAwayElectricalAppliance();
        this.socket = null;
    }
    public Socket getSocket(){
        return socket;
    }

    public int compareTo(ElectricalAppliance electricalAppliance) {
        /*if(power < electricalAppliance.getPower()) return -1;
        if(power == electricalAppliance.getPower()) return 0;
        return 1;*/
        return Integer.compare(power, electricalAppliance.getPower());
    }

}
