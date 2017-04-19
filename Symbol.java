/**
 * Created by acer on 12/15/2016.
 */

public class Symbol implements ISymbol {

    private String image;
    private int value;

    public Symbol(String image, int value) {
        setImage(image);
        setValue(value);

    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int v) {
        this.value = v;
    }

}
