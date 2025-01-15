package Notebook;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); 
        Notebook notebook = new Notebook();

        while (true) {
            String buffer = scanner.nextLine(); 
            System.out.println("$" + buffer);
            String[] command = buffer.split(" ");

            if (command[0].equals("end")) {
                break;
            } else if (command[0].equals("turn_on")) {
                notebook.turnOn();
            } else if (command[0].equals("turn_off")) {
                notebook.turnOff();
            } else if (command[0].equals("set_charger")) {
                notebook.addCharger(Integer.parseInt(command[1]));
            } else if (command[0].equals("rm_charger")) {
                notebook.rmCharger();
            } else if (command[0].equals("set_battery")) {
                notebook.addBattery(Integer.parseInt(command[1]));
            } else if (command[0].equals("use")) {
                notebook.useNotebook(Integer.parseInt(command[1]));
            } else if (command[0].equals("show")) {
                System.out.println(notebook.toString());
            } else {
                System.out.println("fail: comando invalido");
            }
        }

        scanner.close();
    }
}
