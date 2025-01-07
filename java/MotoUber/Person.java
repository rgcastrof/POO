package MotoUber;

public class Person {
    private String name;
    private double money;

    public Person(String name, double money) {
        this.name = name;
        this.money = money;
    }

    public String getName() { return name; }
    public double getMoney() { return money; }

    public void setMoney(double money) { this.money = money; }

    public String toString() {
        return this.name + ":" + this.money;
    }
}
