package Notebook;

public class Notebook {
    private boolean isOn;
    private String status;
    private boolean hasCharger;
    private Charger charger;
    private boolean hasBattery;
    private Battery battery;
    private int usageTime;

    public Notebook() {
        this.isOn = false;
        this.status = "desligado";
        this.hasCharger = false;
        this.charger = null;
        this.hasBattery = false;
        this.battery = null;
        this.usageTime = 0;
    }

    public void turnOn() {
        if (this.charger != null || this.battery != null) {
            if (!this.isOn) {
                this.status = "ligado";
                this.isOn = true;
            } else {
                System.out.println("fail: notebook ja esta ligado");
            }
        } else {
            System.out.println("fail: nao foi possivel ligar");
        }
    }

    public void turnOff() {
        if (this.isOn) {
            this.isOn = false;
            this.status = "desligado";
        } else {
            System.out.println("fail: notebook nao esta ligado");
        }
    }

    public void addCharger(int power) {
        if (!this.hasCharger) {
            this.charger = new Charger(power);
            this.hasCharger = true;
        } else {
            System.out.println("fail: Carregador já conectado");
        }

    }

    public void rmCharger() {
        if (this.hasCharger) {
            System.out.println("Removido " + this.charger.getPower() + "W");
            this.isOn = false;
            this.hasCharger = false;
            this.status = "desligado";
            this.charger = null;
        } else {
            System.out.println("fail: Sem carregador");
        }
    }

    public void addBattery(int capacity) {
        if (!hasBattery) {
            this.battery = new Battery(capacity);
            this.hasBattery = true;
        } else {
            System.out.println("fail: Ja existe bateria");
        }
    }

    public void useNotebook(int usageTime) {
        if (!this.isOn) {
            System.out.println("fail: deligado");
        } else {
            this.usageTime += usageTime;
            this.battery.setActualCapacity(this.battery.getActualCapacity() - usageTime);
        }
    }

    public String toString() {
        if (!this.isOn && !this.hasCharger && !this.hasBattery) {
            return "Notebook: " + this.status;
        } else if (this.hasCharger && !this.isOn) {
            return "Notebook: " + this.status + ", " + this.charger.toString();
        } else if (this.hasBattery && !this.isOn) {
            return "Notebook: " + this.status + ", " + this.battery.toString();
        } else if (this.hasBattery && this.isOn) {
            return "Notebook: " + this.status + " por " + this.usageTime + " min, " + this.battery.toString();
        } else {
            return "Notebook: " + this.status + " por " + this.usageTime + " min, " + this.charger.toString();
        }
    }
}
