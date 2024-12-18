package Cinema;

public class Client {

    private String name;
    private int phone; 

    public Client(String name, int phone) {
        this.name = name;
        this.phone = phone;
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getPhone() { return phone; }
    public void setPhone(int phone) { this.phone = phone; }

    @Override
    public String toString() {
        return this.name + ":" + this.phone;
    }
}