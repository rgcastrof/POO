package Figuras;

public class Retangulo extends Shape {

    private Ponto2D largura;
    private Ponto2D altura;

    public Retangulo(double x1, double y1, double x2, double y2) {
        this.largura = new Ponto2D(Math.abs(x2 - x1));
        this.altura = new Ponto2D(y2 - y1);
    }

    @Override
    protected double calcArea() {
        return this.largura.getPonto() * this.altura.getPonto();
    }

    @Override
    protected double calcPerimeter() {
        return 2 * (this.largura.getPonto() + this.altura.getPonto());
    }
}