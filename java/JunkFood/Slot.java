package JunkFood;

import java.text.DecimalFormat;

public class Slot {
    private String name; 
    private int quantity;
    private double price;

    public Slot(String name, int quantity, double price) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }

    public String toString() {
        DecimalFormat df = new DecimalFormat("0.00");
        return getName() + " : " + getQuantity() + " U : " + df.format(getPrice()) + " RS";
    }
}
