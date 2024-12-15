package Topic;

public class Pass {

    private int age;
    private String name;    

    public Pass(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public int getAge() { return age; }
    public String getName() { return name; }

    public void setAge(int age) { this.age = age; }
    public void setName(String name) { this.name = name; }

    public boolean isPriority() {

        if (this.age >= 60) {
            return true;
        }
        return false;
    }

    public String toString() {
        return this.name + ":" + this.age;
    }
}
