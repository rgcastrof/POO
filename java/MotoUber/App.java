package MotoUber;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Moto moto = new Moto(null, null, false, false);

        while (true) {
            String buffer = scanner.nextLine(); 
            System.out.println("$" + buffer);
            String[] command = buffer.split(" ");

            if (command[0].equals("end")) { break; }
            else if (command[0].equals("setDriver")) {
                moto.insertRider(command[1], Double.parseDouble(command[2]));
            } else if (command[0].equals("setPass")) {
                moto.insertPassenger(command[1], Double.parseDouble(command[2]));
            } else if (command[0].equals("drive")) {
                Moto.cost += Double.parseDouble(command[1]);
            } else if (command[0].equals("leavePass")) {
                moto.leavePassenger();
            } else if (command[0].equals("show")) {
                System.out.println(moto.toString());
            }
            else {
                System.out.println("fail: comando invalido");
            }
        }

        scanner.close();
    }
}
