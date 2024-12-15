package Motoca;

public class Motor {
    private Person person;
    private int power;
    private int time;
    private boolean isOccupied;

    public Motor(int power) {
        this.person = null;
        this.power = 1;
        this.time = 0;
        this.isOccupied = false;
    }

    public Person getPerson() { return person; }
    public void setPower(int power) { this.power = power; }

    public void reset() {

        this.person = null;
        this.time = 0;
        this.isOccupied = false;
    }

    public void insert(Person person) {
        if (this.isOccupied) {
            System.out.println("fail: busy motorcycle");
        } else {

            this.person = person;
            this.isOccupied = true;
        }
    }

    public void leave() {
        if (this.person == null) {
            System.out.println("fail: empty motorcycle");
            return;
        }
        this.person = null;
        this.isOccupied = false;
    }

    public void buy(int time) {
        this.time += time;
    }

    public void drive(int time) {
        if (this.time <= 0) {
            System.out.println("fail: buy time first");
        } else if (this.person == null) {
            System.out.println("fail: empty motocycle");
        } else if (this.person.getAge() > 10) {
            System.out.println("fail: too old to drive");
        } else {
            this.time -= time;
            if (this.time <= 0) {
                System.out.println("fail: time finished after " + Math.abs(this.time) + " minutes");
                this.time = 0;
            }
        }
    }

    public void honk() {
        String honk = "Pm";
        int pos = 1;
        char noiseLength = 'e';
        String newHonk = honk.substring(0, pos);

        for (int i = 0; i < this.power; i++) {
            newHonk += noiseLength;
        }
        
        newHonk += honk.substring(pos);

        System.out.println(newHonk);
    }

    public String toString() {
        if (this.person == null) {

            return "power:" + this.power + ", time:" + this.time + ", person:(empty)";
        }
        return "power:" + this.power + ", time:" + this.time + ", person:" + this.person.toString();
    }
}