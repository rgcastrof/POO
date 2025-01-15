package Notebook;

public class Charger {
    private int power;

    public Charger(int power) {
        this.power = power;
    }

    public int getPower() { return power; }

    public String toString() {
        return "Carregador: " + this.power + "W";
    }
}
