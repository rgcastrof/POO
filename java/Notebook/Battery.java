package Notebook;

public class Battery {
    private int maxCapacity; 
    private int actualCapacity;

    public Battery(int maxCapacity) {
        this.maxCapacity = maxCapacity;
        this.actualCapacity = maxCapacity;
    }

    public int getMaxCapacity() { return maxCapacity; }
    public int getActualCapacity() { return actualCapacity; }

    public void setActualCapacity(int actualCapacity) {
        this.actualCapacity = actualCapacity;
    }

    public String toString() {
        return "Bateria: " + this.actualCapacity + "/" + this.maxCapacity;
    }
}
