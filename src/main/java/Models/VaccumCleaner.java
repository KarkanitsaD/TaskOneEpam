package Models;

import Models.Abstractions.ElectricalAppliance;
import Models.Options.SizeOptions;

import java.io.Serial;
import java.io.Serializable;

public class VaccumCleaner extends ElectricalAppliance implements Serializable {
    @Serial
    private static final long serialVersionUID = 3480377544426897931L;

    private final float dustCollectorVolume;
    private float wireLength ;

    public VaccumCleaner(SizeOptions sizeOptions, float price, float weight, float dustCollectorVolume) {
        super(sizeOptions, price, weight);
        this.dustCollectorVolume = dustCollectorVolume;
    }

    public float getWireLength() {
        return wireLength;
    }
    public void setWireLength(float wireLength) {
        this.wireLength = wireLength;
    }

    public float getDustCollectorVolume() {
        return dustCollectorVolume;
    }

    @Override
    public String toString() {
        return "VaccumCleaner{\n\t" +
                "power=" + power +
                ",\n\tweight=" + weight +
                ",\n\tprice=" + price +
                ",\n\tcolor='" + color + '\'' +
                ",\n\tsizeOptions=" + sizeOptions +
                ",\n\tdustCollectorVolume=" + dustCollectorVolume +
                ",\n\twireLength=" + wireLength +
                "\n}";
    }

}
