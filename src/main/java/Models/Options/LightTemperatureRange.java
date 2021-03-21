package Models.Options;

import java.io.Serializable;

public class LightTemperatureRange implements Serializable {

    private static final long serialVersionUID = 4452766350602916766L;
    private int minLightTemperature;
    private int maxLightTemperature;

    public LightTemperatureRange(int minLightTemperature, int maxLightTemperature){
        if(minLightTemperature > maxLightTemperature || minLightTemperature < 0){
            throw new IllegalArgumentException("Wrong temperature range");
        }
        this.minLightTemperature = minLightTemperature;
        this.maxLightTemperature = maxLightTemperature;
    }

    public int getMinLightTemperature() {
        return minLightTemperature;
    }
    public void setMinLightTemperature(int minLightTemperature) {
        this.minLightTemperature = minLightTemperature;
    }

    public int getMaxLightTemperature() {
        return maxLightTemperature;
    }
    public void setMaxLightTemperature(int maxLightTemperature) {
        this.maxLightTemperature = maxLightTemperature;
    }

    @Override
    public String toString() {
        return "LightTemperatureRange{" +
                "minLightTemperature=" + minLightTemperature +
                ", maxLightTemperature=" + maxLightTemperature +
                '}';
    }
}
