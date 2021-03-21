package Models;

import Models.Abstractions.ElectricalAppliance;
import Models.Enums.IronSole;
import Models.Options.SizeOptions;

import java.io.Serial;
import java.io.Serializable;

public class Iron extends ElectricalAppliance implements Serializable {
    @Serial
    private static final long serialVersionUID = -8912174040719855385L;

    private final float maxWaterVolume;
    private IronSole sole;

    public Iron(SizeOptions sizeOptions, float price,  float weight, float maxWaterVolume) {
        super(sizeOptions, price, weight);
        this.maxWaterVolume = maxWaterVolume;
    }

    public float getMaxWaterVolume() {
        return maxWaterVolume;
    }

    public IronSole getSole() {
        return sole;
    }
    public void setSole(IronSole sole) {
        this.sole = sole;
    }

    @Override
    public String toString() {
        return "Iron{\n\t" +
                "power=" + power +
                ",\n\tweight=" + weight +
                ",\n\tprice=" + price +
                ",\n\tcolor='" + color + '\'' +
                ",\n\tsizeOptions=" + sizeOptions +
                ",\n\tmaxWaterVolume=" + maxWaterVolume +
                ",\n\tsole=" + sole +
                "\n}";
    }
}
