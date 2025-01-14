package MassaGravitacional;

import java.text.DecimalFormat;
import java.util.Scanner;
public class App {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Person person = new Person("", 0, null);

        while (true) {
            String buffer = scanner.nextLine(); 
            System.out.println("$" + buffer);
            String[] command = buffer.split(" ");

            if (command[0].equals("end")) { break; }
            else if (command[0].equals("init")) {
                person = new Person(command[1], Double.parseDouble(command[2]), Planet.valueOf(command[3]));
            }
            else if (command[0].equals("massaEquivalente")) {

                DecimalFormat df = new DecimalFormat("0.00");

                System.out.println(
                    "A força gravitacional no planeta: " + command[1] + " e " +
                    df.format(Planet.valueOf(command[1]).gravityForce(Planet.valueOf(command[1])))
                );
                System.out.println(df.format(person.calcMass(Planet.valueOf(command[1]))));
            }
            else if (command[0].equals("show")) {
                System.out.println(person.toString());
            }
            else {
                System.out.println("fail: comando invalido");
            }
        }
        scanner.close();
    }
}