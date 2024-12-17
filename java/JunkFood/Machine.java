package JunkFood;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class Machine {
    private ArrayList<Slot> slots;
    private double cash;
    private int capacity;

    public Machine(int capacity) {
        this.capacity = capacity;
        this.cash = 0.0;
        this.slots = new ArrayList<>();
        for (int i = 0; i < this.capacity; i++) {
            this.slots.add(new Slot("  empty", 0, 0.0));
        }
    }


    public double getCash() { return cash; }
    public void setCash(double cash) { this.cash = cash; }

    public void addItem(int index, String name, int quantity, double price) {

        if (index < 0 || index > this.slots.size()) {
            System.out.println("fail: indice nao existe");
        } else {
            this.slots.get(index).setName(name);
            this.slots.get(index).setQuantity(quantity);
            this.slots.get(index).setPrice(price);
        }
    }

    public void removeItem(int index) {
        this.slots.get(index).setName("  empty");
        this.slots.get(index).setQuantity(0);
        this.slots.get(index).setPrice(0.0);
    }

    public void buyItem(int index) {
        if (index < 0 || index > this.slots.size()) {
            System.out.println("fail: indice nao existe");
            return;
        } 
        if (this.cash < this.slots.get(index).getPrice()) {
            System.out.println("fail: saldo insuficiente");
            return;
        }
        if (this.slots.get(index).getQuantity() <= 0) {
            System.out.println("fail: espiral sem produtos");
            return;
        }
        this.cash -= this.slots.get(index).getPrice();
        this.slots.get(index).setQuantity(this.slots.get(index).getQuantity() - 1);
        System.out.println("voce comprou um " + this.slots.get(index).getName());

    }
    
    public String toString() {
        StringBuilder sb = new StringBuilder();
        DecimalFormat df = new DecimalFormat("0.00");

        sb.append("saldo: " + df.format(this.cash) + "\n");
        for (int i = 0; i < this.capacity; i++) {
            sb.append(i + " [ " + this.slots.get(i).toString() + "]\n");
        }

        return sb.toString();
    }

}
