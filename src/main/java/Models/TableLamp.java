package Models;

import Models.Abstractions.LightingElectricalAppliances;
import Models.Options.LightTemperatureRange;
import Models.Options.SizeOptions;

import java.io.Serial;
import java.io.Serializable;

public class TableLamp extends LightingElectricalAppliances implements Serializable {
    @Serial
    private static final long serialVersionUID = 75451762033178408L;

    private float wireLength;

    public TableLamp(SizeOptions sizeOptions, float price,  float weight) {
        super(sizeOptions, price, weight);
    }
    public TableLamp(SizeOptions sizeOptions, float price,  float weight, int wireLength) {
        super(sizeOptions, price, weight);
        this.wireLength = wireLength;
    }
    public TableLamp(SizeOptions sizeOptions, float price,  float weight, LightTemperatureRange lightTemperatureRange) {
        super(sizeOptions, price,weight, lightTemperatureRange);
    }

    public float getWireLength() {
        return wireLength;
    }
    public void setWireLength(float wireLength) {
        if(wireLength < 0){
            throw new IllegalArgumentException("Invalid wire length");
        }
        this.wireLength = wireLength;
    }

    @Override
    public String toString() {
        return "TableLamp{\n\t" +
                "power=" + super.power +
                ",\n\tweight=" + super.weight +
                ",\n\tprice=" + super.price +
                ",\n\tcolor='" + super.color + '\'' +
                ",\n\tsizeOptions=" + super.sizeOptions +
                ",\n\ttemperatureRange=" + super.lightTemperatureRange +
                ",\n\twireLength=" + wireLength +
                "\n}";
    }
}
