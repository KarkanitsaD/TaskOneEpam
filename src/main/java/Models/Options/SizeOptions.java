package Models.Options;

import java.io.Serial;
import java.io.Serializable;

public class SizeOptions implements Serializable {

    @Serial
    private static final long serialVersionUID = 7217244647418534197L;

    private float height;
    private float width;
    private float depth;

    public float getHeight() {
        return height;
    }
    public void setHeight(float height) {
        this.height = height;
    }

    public float getWidth() {
        return width;
    }
    public void setWidth(float width) {
        this.width = width;
    }

    public float getDepth() {
        return depth;
    }
    public void setDepth(float depth) {
        this.depth = depth;
    }

    @Override
    public String toString() {
        return "SizeOptions{" +
                "height=" + height +
                ", width=" + width +
                ", depth=" + depth +
                '}';
    }

    public SizeOptions(float height, float width, float depth){
        this.height = height;
        this.width = width;
        this.depth = depth;
    }
    public SizeOptions(SizeOptions sizeOptions){
        this.height = sizeOptions.height;;
        this.width = sizeOptions.width;
        this.depth = sizeOptions.depth;
    }
}
