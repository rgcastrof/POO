package Motoca;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Motor motor = new Motor(0);

        while (true) {

            String buffer = scanner.nextLine();
            String[] command = buffer.split(" ");
            System.out.println("$" + buffer);

            if (command[0].equals("end")) {
                break; 
            } else if (command[0].equals("enter")) {
                motor.insert(new Person(command[1], Integer.parseInt(command[2])));
            } else if (command[0].equals("leave")) {
                motor.leave();
            } else if (command[0].equals("init")) {
                motor.reset();
                motor.setPower(Integer.parseInt(command[1]));
            } else if (command[0].equals("buy")) {
                motor.buy(Integer.parseInt(command[1]));
            } else if (command[0].equals("drive")) {
                motor.drive(Integer.parseInt(command[1]));
            } else if (command[0].equals("honk")) {
                motor.honk();
            } else if (command[0].equals("show")) {
                System.out.println(motor.toString());
            } else {
                System.out.println("fail: comando invalido");
            }
        }
        scanner.close();
    } 
}