package Models;

import Models.Abstractions.ElectricalAppliance;
import Models.Options.SizeOptions;

import java.io.Serial;
import java.io.Serializable;

public class Microwave extends ElectricalAppliance implements Serializable {
    @Serial
    private static final long serialVersionUID = -8437044272861466413L;

    private float palletDiameter;
    private final float internalVolume;

    public Microwave(SizeOptions sizeOptions, float price, float internalVolume,  float weight) {
        super(sizeOptions, price, weight);
        this.internalVolume = internalVolume;
    }

    public float getInternalVolume() {
        return internalVolume;
    }

    public float getPalletDiameter() {
        return palletDiameter;
    }
    public void setPalletDiameter(float palletDiameter) {
        this.palletDiameter = palletDiameter;
    }

    @Override
    public String toString() {
        return "Microwave{\n\t" +
                "power=" + power +
                ",\n\tweight=" + weight +
                ",\n\tprice=" + price +
                ",\n\tcolor='" + color + '\'' +
                ",\n\tsizeOptions=" + sizeOptions +
                ",\n\tpalletDiameter=" + palletDiameter +
                ",\n\tinternalVolume=" + internalVolume +
                "\n}";
    }
}
