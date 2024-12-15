package Topic;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Topic topic = new Topic(0, 0);

        while (true) {
            String buffer = scanner.nextLine();
            System.out.println("$" + buffer);
            String[] command = buffer.split(" ");

            if (command[0].equals("end")) { break; }
            else if (command[0].equals("init")) {
                topic = new Topic(Integer.parseInt(command[1]), Integer.parseInt(command[2])); 
            }
            else if (command[0].equals("in")) {
                topic.insert(new Pass(command[1], Integer.parseInt(command[2])));
            }
            else if (command[0].equals("out")) {
                topic.out(command[1]);
            }
            else if (command[0].equals("show")) {
                System.out.println(topic.toString());
            } else {
                System.out.println("fail: comando invalido");
            }
        }
        scanner.close();
    }
}
