package JunkFood;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Machine machine = new Machine(0);

        while (true) {
            String buffer = scanner.nextLine(); 
            System.out.println("$" + buffer);
            String[] command = buffer.split(" ");

            if (command[0].equals("end")) { break; }
            else if (command[0].equals("init")) {
                machine = new Machine(Integer.parseInt(command[1]));
            } else if (command[0].equals("show")) {
                System.out.print(machine.toString());
            } else if (command[0].equals("dinheiro")) {
                machine.setCash(machine.getCash() + Double.parseDouble(command[1]));
            } else if (command[0].equals("set")) {
                machine.addItem (
                    Integer.parseInt(command[1]), command[2],
                    Integer.parseInt(command[3]), Double.parseDouble(command[4])
                    );
            } else if (command[0].equals("limpar")) {
                machine.removeItem(Integer.parseInt(command[1]));
            } else if (command[0].equals("comprar")) {
                machine.buyItem(Integer.parseInt(command[1]));
            } else if (command[0].equals("troco")) {
                System.out.printf("voce recebeu: %.2f RS\n", machine.getCash());
                machine.setCash(0);
            }
            else {
                System.out.println("fail: comando invalido");
            }
        }
        scanner.close();
    }
}
