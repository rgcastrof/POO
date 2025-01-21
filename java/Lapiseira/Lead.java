package Lapiseira;

public class Lead {
    private double thickness;
    private String hardness;
    private int size;

    public Lead(double thickness, String hardness, int size) {
        this.thickness = thickness;
        this.hardness = hardness;
        this.size = size;
    }

    public double getThickness() { return thickness; }
    public String getHardness() { return hardness; }
    public int getSize() { return size; }

    public void setSize(int size) { this.size = size; }

    public int usagePerSheet(String hardness) {
        int usage = 0;

        switch (hardness) {
            case "HB":
                usage = 1;
                break;
            case "2B":
                usage = 2;
                break;
            case "4B":
                usage = 4;
                break;
            case "6B":
                usage = 6;
                break;
        }

        return usage;
    }

    @Override
    public String toString() {
        return "[" + this.thickness + ":" + this.hardness + ":" + this.size + "]";
    }
}
