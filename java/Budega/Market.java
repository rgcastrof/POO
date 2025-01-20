package Budega;

import java.util.LinkedList;
import java.util.Queue;

public class Market {
    private Person[] cashier;
    private Queue<Person> clientsQueue;
    private boolean isQueueEmpty;

    public Market(int quantity) {
        this.cashier = new Person[quantity];
        this.clientsQueue = new LinkedList<>();
        this.isQueueEmpty = true;

        for (int i = 0; i < quantity; i++) {
            this.cashier[i] = null;
        }
    }

    public void arrive(Person person) {
        clientsQueue.add(person);
        this.isQueueEmpty = false;
    }

    public void call(int index) {
        if (isQueueEmpty) {
            System.out.println("fail: fila vazia");
        } else {
            if (this.cashier[index] == null) {
                this.cashier[index] = clientsQueue.peek();
                clientsQueue.poll();

                if (this.cashier.length > 0) {
                    this.isQueueEmpty = false;
                    return;
                }
                this.isQueueEmpty = true;
                
            } else {
                System.out.println("fail: caixa ocupado");
            }
        }
    }

    public void finish(int index) {
        if (this.cashier[index] == null) {
            System.err.println("fail: caixa vazio");
        } else {
            this.cashier[index] = null;
        }
    }

    public String toString() {
        String output = "|";

        for (int i = 0; i < cashier.length; i++) {
            if (this.cashier[i] == null) {
                output = output + Integer.toString(i) + ":-----|";
            } else {
                output = output + Integer.toString(i) + ":" + this.cashier[i].toString() + "|";
            }
        }

        output += "\nEspera: " + this.clientsQueue.toString();

        return output;
    }

}