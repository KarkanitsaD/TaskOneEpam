package Models.Abstractions;

import Models.Options.LightTemperatureRange;
import Models.Options.SizeOptions;

import java.io.Serial;
import java.io.Serializable;

public abstract class LightingElectricalAppliances extends ElectricalAppliance implements Serializable {

    @Serial
    private static final long serialVersionUID = -6919754352080254418L;

    protected int lightBrightness;
    protected LightTemperatureRange lightTemperatureRange;

    public LightingElectricalAppliances(SizeOptions sizeOptions, float price, float weight){
        super(sizeOptions, price, weight);
    }
    public LightingElectricalAppliances(SizeOptions sizeOptions, float price, float weight, LightTemperatureRange lightTemperatureRange){
        super(sizeOptions, price, weight);
        this.lightTemperatureRange = lightTemperatureRange;
    }
    public LightingElectricalAppliances(SizeOptions sizeOptions, float price, float weight, int lightBrightness){
        super(sizeOptions, price, weight);
        this.lightBrightness = lightBrightness;
    }

    public int getLightBrightness() {
        return lightBrightness;
    }
    public void setLightBrightness(int lightBrightness) {
        this.lightBrightness = lightBrightness;
    }

    public LightTemperatureRange getLightTemperatureRange() {
        return lightTemperatureRange;
    }
    public void setLightTemperatureRange(LightTemperatureRange lightTemperatureRange) {
        this.lightTemperatureRange = lightTemperatureRange;
    }
}
