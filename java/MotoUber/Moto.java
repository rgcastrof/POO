package MotoUber;

public class Moto {
    private Person rider;
    private Person passenger;
    private boolean hasRider;
    private boolean hasPassenger;

    public static double cost = 0;

    public Moto(Person rider, Person passenger, boolean hasRider, boolean hasPassenger) {
        this.rider = null;
        this.passenger = null;
        this.hasRider = false;
        this.hasPassenger = false;
    }

    public void insertRider(String name, double money) {
        if (!hasRider) {
            this.rider = new Person(name, money);
            this.hasRider = true;
        } else {
            System.out.println("fail: ja existe um motorista na moto");
        }
    }

    public void insertPassenger(String name, double money) {
        if (!hasPassenger) {
            this.passenger = new Person(name, money);
            this.hasPassenger = true;
        } else {
            System.out.println("fail: ja existe um passageiro na moto");
        }
    }

    public void leavePassenger() {
        if (!hasPassenger) {
            System.out.println("fail: nao existe passageiro");
        } else {
            this.hasPassenger = false;

            this.rider.setMoney(this.rider.getMoney() + cost);
            this.passenger.setMoney(this.passenger.getMoney() - cost);

            if (this.passenger.getMoney() < 0) {
                System.out.println("fail: Passenger does not have enough money");
                this.passenger.setMoney(0);
            }

            System.out.println(this.passenger.toString() + " left");
            this.passenger = null; 
            cost = 0;
        }
    }

    public String toString() {
        if (this.rider == null && this.passenger == null) {
            return "Cost: " + cost + ", Driver: None, Passenger: None";
        }
        else if (this.rider == null) {
            return "Cost: " + cost + ", Driver: None, Passenger: " + this.passenger.toString();
        } else if (this.passenger == null) {
            return "Cost: " + cost + ", Driver: " + this.rider.toString() + ", Passenger: None";
        }  else {
            return "Cost: " + cost + ", Driver: " + this.rider.toString()
                + ", Passenger: " + this.passenger.toString();
        }
    }
}
