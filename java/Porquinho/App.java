import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); 
        Pig pig = new Pig(0);

        while (true) {
            String buffer = scanner.nextLine(); 
            System.out.println("$" + buffer);

            String[] command = buffer.split(" ");

            if (command[0].equals("end")) { break; }
            else if (command[0].equals("init")) {
                pig = new Pig(Integer.parseInt(command[1])); 
            } else if (command[0].equals("addCoin")) {
                pig.addCoin(Integer.parseInt(command[1]));
            } else if (command[0].equals("addItem")) {
                pig.addItem(command[1], Integer.parseInt(command[2]));
            } else if (command[0].equals("break")) {
                pig.breakPig();
            } else if (command[0].equals("extractCoins")) {
                pig.extractCoins();
            } else if (command[0].equals("extractItems")) {
                pig.extractItens();
            } else if (command[0].equals("show")) {
                System.out.println(pig.toString());
            } else {
                System.out.println("fail: comando invalido");
            }
        }
        scanner.close();
    }
}
