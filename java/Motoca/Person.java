package Motoca;

public class Person {
    private int age;
    private String name;
    
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public int getAge() { return age; }
    public String getName() { return name; }

    public String toString() {
        return "(" + this.name + ":" + this.age + ")";
    }
}