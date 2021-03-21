package Models;
import Models.Abstractions.ElectricalAppliance;
import Models.Options.SizeOptions;
import java.io.Serial;
import java.io.Serializable;

public class Fridge extends ElectricalAppliance implements Serializable {
    @Serial
    private static final long serialVersionUID = -6534565531140492625L;

    private final float internalVolume;
    public float getInternalVolume() {
        return internalVolume;
    }

    public Fridge(SizeOptions sizeOptions, float price, float weight, float internalVolume) {
        super(sizeOptions, price, weight);
        this.internalVolume = internalVolume;
    }

    @Override
    public String toString() {
        return "Fridge{\n\t" +
                "power=" + power +
                ",\n\tweight=" + weight +
                ",\n\tprice=" + price +
                ",\n\tcolor='" + color + '\'' +
                ",\n\tsizeOptions=" + sizeOptions +
                ",\n\tinternalVolume=" + internalVolume +
                "\n}";
    }
}
