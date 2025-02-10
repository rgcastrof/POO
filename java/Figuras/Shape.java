package Figuras;

public abstract class Shape {

    protected abstract double calcArea(); 
    protected abstract double calcPerimeter();
    protected abstract boolean insideShape(double x, double y);
}