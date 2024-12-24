import java.text.DecimalFormat;

public class Coin {
    private double value;
    private int volume;
    private String label;

    public Coin(double value, int volume, String label) {
        this.value = value;
        this.volume = volume;
        this.label = label;
    }

    public static Coin C10 = new Coin(0.10, 1, "C10");
    public static Coin C25 = new Coin(0.25, 2, "C25");
    public static Coin C50 = new Coin(0.50, 3, "C50");
    public static Coin C100 = new Coin(1.0, 4, "C100");

    public double getValue() { return value; }
    public int getVolume() { return volume; }
    public String getLabel() { return label; }

    public String toString() {
        DecimalFormat df = new DecimalFormat("0.00");
        return df.format(getValue()) + ":" + getVolume();
    }
}
