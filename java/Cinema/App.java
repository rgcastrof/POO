package Cinema;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Room room = new Room(0); 
        String buffer;

        while (true) {
            buffer = scanner.nextLine(); 
            System.out.println("$" + buffer);
            String[] command = buffer.split(" ");

            if (command[0].equals("end")) {
                break;
            } else if (command[0].equals("init")) {
                room = new Room(Integer.parseInt(command[1]));
            } else if (command[0].equals("reservar")) {
                room.reserve(command[1], Integer.parseInt(command[2]), Integer.parseInt(command[3]));
            } else if (command[0].equals("cancelar")) {
                room.cancel(command[1]);
            } else if (command[0].equals("show")) {
                System.out.println(room.toString());
            } else {
                System.out.println("fail: comando invalido");
            }
        }
        scanner.close();
    }
}