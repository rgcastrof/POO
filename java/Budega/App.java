package Budega;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Market market = new Market(0);

        while (true) {
            String buffer = scanner.nextLine(); 
            System.out.println("$" + buffer);
            String cmd[] = buffer.split(" ");

            if (cmd[0].equals("end")) { break; }
            else if (cmd[0].equals("init")) {
                market = new Market(Integer.parseInt(cmd[1]));
            } else if (cmd[0].equals("show")) {
                System.out.println(market.toString());
            } else if (cmd[0].equals("arrive")) {
                market.arrive(new Person(cmd[1]));
            } else if (cmd[0].equals("call")) {
                market.call(Integer.parseInt(cmd[1]));
            } else if (cmd[0].equals("finish")) {
                market.finish(Integer.parseInt(cmd[1]));
            } else {
                System.err.println("fail: comando invalido");
            }
        }
        scanner.close();
    }
}