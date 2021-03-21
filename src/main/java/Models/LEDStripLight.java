package Models;

import Models.Abstractions.LightingElectricalAppliances;
import Models.Options.LightTemperatureRange;
import Models.Options.SizeOptions;

import java.io.Serial;
import java.io.Serializable;

public class LEDStripLight extends LightingElectricalAppliances implements Serializable {
    @Serial
    private static final long serialVersionUID = -8843558820462952462L;

    private int ledsNumber;
    private String lightColor;


    public LEDStripLight(SizeOptions sizeOptions, float price,  float weight) {
        super(sizeOptions, price, weight);
    }
    public LEDStripLight(SizeOptions sizeOptions, float price,  float weight, LightTemperatureRange lightTemperatureRange) {
        super(sizeOptions, price, weight, lightTemperatureRange);
    }
    public LEDStripLight(SizeOptions sizeOptions, float price, int lightBrightness) {
        super(sizeOptions, price, lightBrightness);
    }


    public int getLedsNumber() {
        return ledsNumber;
    }
    public void setLedsNumber(int ledsNumber) {
        if(ledsNumber<0){
            throw new IllegalArgumentException("Invalid number of LEDs");
        }
        this.ledsNumber = ledsNumber;
    }

    public String getLightColor() {
        return lightColor;
    }
    public void setLightColor(String lightColor) {
        this.lightColor = lightColor;
    }

    @Override
    public String toString() {
        return "LEDStripLight{\n\t" +
                "power=" + power +
                ",\n\tweight=" + weight +
                ",\n\tprice=" + price +
                ",\n\tcolor='" + color + '\'' +
                ",\n\tsizeOptions=" + sizeOptions +
                ",\n\tledsNumber=" + ledsNumber +
                ",\n\tlightColor='" + lightColor + '\'' +
                ",\n\tlightBrightness=" + lightBrightness +
                ",\n\tlightTemperatureRange=" + lightTemperatureRange +
                "\n}";
    }
}
