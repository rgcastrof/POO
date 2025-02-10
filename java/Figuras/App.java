package Figuras;

import java.util.Scanner;
import java.util.ArrayList;

public class App {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);        
        ArrayList<Shape> figuras = new ArrayList<>();
        int index;

        while (true) {
            String buffer = scanner.nextLine(); 
            System.out.println("$" + buffer);
            String[] cmd = buffer.split(" ");

            if (cmd[0].equals("end")) {
                break;
            }
            else if (cmd[0].equals("retangulo")) {
                figuras.add(new Retangulo(Double.parseDouble(cmd[1]), Double.parseDouble(cmd[2]),
                Double.parseDouble(cmd[3]), Double.parseDouble(cmd[4])));
            }
            else if (cmd[0].equals("area")) {
                index = 0;
                System.out.println("area total: " + figuras.get(index).calcArea());
                index++;
            }
            else if (cmd[0].equals("perimetro")) {
                index = 0;
                System.out.println("perimetro: " + figuras.get(index).calcPerimeter());
                index++;
            }
            else if (cmd[0].equals("inside")) {
                index = 0;
                System.out.println(figuras.get(index).insideShape(Double.parseDouble(cmd[1]),
                Double.parseDouble(cmd[2])));
                index++;
            }
            else {
                System.err.println("fail: comando invalido");
            }
        }

        scanner.close();
    }
}