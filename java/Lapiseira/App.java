package Lapiseira;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Pencil pencil = new Pencil(0);

        while (true) {
            String buffer = scanner.nextLine(); 
            System.out.println("$" + buffer);
            String[] cmd = buffer.split(" ");

            if (cmd[0].equals("end")) { break; }
            else if (cmd[0].equals("init")) {
                pencil = new Pencil(Double.parseDouble(cmd[1]));
            }
            else if (cmd[0].equals("insert")) {
                pencil.insert(new Lead(Double.parseDouble(cmd[1]), cmd[2], Integer.parseInt(cmd[3])));
            }
            else if (cmd[0].equals("pull")) {
                pencil.pull();
            }
            else if (cmd[0].equals("remove")) {
                pencil.remove();
            }
            else if (cmd[0].equals("write")) {
                pencil.writePage();
            }
            else if (cmd[0].equals("show")) {
                System.out.println(pencil.toString());
            }
            else { System.out.println("fail: comando invalido"); }

        }
        scanner.close();
    }
}
