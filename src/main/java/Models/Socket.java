package Models;

import Models.Abstractions.ElectricalAppliance;

import java.io.Serial;
import java.io.Serializable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class Socket implements Serializable {
    @Serial
    private static final long serialVersionUID = -8261379073161953790L;

    private static final Logger logger = LoggerFactory.getLogger(Socket.class);

    private ElectricalAppliance electricalAppliance = null;
    private float voltage;

    public Socket(float voltage){
        this.voltage = voltage;
    }


    public ElectricalAppliance getElectricalAppliance() {
        return electricalAppliance;
    }
    public void setElectricalAppliance(ElectricalAppliance electricalAppliance) {
        logger.info("Try to set electrical appliance");
        if(electricalAppliance.getSocket() == this){
            this.electricalAppliance = electricalAppliance;
        }
        else {
            throw new IllegalStateException("Check appliance");
        }
    }
    public void takeAwayElectricalAppliance(){
        logger.info("Disconnecting electrical appliance");
        if(!electricalAppliance.IsConnected())
        this.electricalAppliance = null;
    }

    public float getVoltage() {
        return voltage;
    }
    public void setVoltage(float voltage) {
        logger.info("Setting voltage to socket = " + voltage);
        this.voltage = voltage;
    }

    public float calculateElectricity(){
        if(electricalAppliance == null) return 0;
        return (float)electricalAppliance.getPower()/voltage;
    }

    @Override
    public String toString() {
        if (electricalAppliance == null)
        return "Socket{" +
                "isEmpty = " + "True"  +
                ", tvoltage = " + voltage +
                "}";
        else
            return "Socket{" +
                    "isEmpty = " + "False"  +
                    ", tvoltage = " + voltage +
                    "}";
    }
}
