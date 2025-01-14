package MassaGravitacional;

public class Person {
    private String name;
    private double mass;
    private Planet planet;

    public Person(String name, double mass, Planet planet) {
        this.name = name;
        this.mass = mass;
        this.planet = planet;
    }

    public double calcMass(Planet otherPlanet) {
        return this.mass * (otherPlanet.gravityForce(otherPlanet) / this.planet.gravityForce(this.planet));
    }

    public String toString() {
        return "nome: " + this.name + " mass: " + this.mass + " planeta: " + this.planet;
    }
}