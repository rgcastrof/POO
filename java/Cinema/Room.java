package Cinema;

import java.util.ArrayList;

public class Room {
    private ArrayList<Client> chairs;

    public Room(int capacity) {
        this.chairs = new ArrayList<>();
        for (int i = 0; i < capacity; i++) {
            chairs.add(null);
        }
    }

    public int search(String name) {

        Client client;
        for (int i = 0; i < this.chairs.size(); i++) {
            if (this.chairs.get(i) != null) {
                client = this.chairs.get(i); 
                if (client.getName() == name) {
                    return i;
                }
            }
        } 
        return -1;
    }

    public boolean chairVerify(int iterator) {
        for (int i = 0; i < this.chairs.size(); i++) {
            if (iterator == i) {
                return true;
            }
        }
        return false;
    }

    public void reserve(String name, int phone, int chairNumber) {
        boolean check = chairVerify(chairNumber);

        if (!check) {
            System.out.println("fail: cadeira nao existe");
        } else {
            if (this.chairs.get(chairNumber) != null) {
                System.out.println("fail: cadeira ja esta ocupada");
            } else {
                for (int i = 0; i < this.chairs.size(); i++) {
                    if (this.chairs.get(i) != null) {
                        if (name.equals(this.chairs.get(i).getName())) {
                            System.out.println("fail: cliente ja esta no cinema"); 
                            return;
                        }
                    } 
                }
                this.chairs.set(chairNumber, new Client(name, phone));
            }
        }
    }

    public void cancel(String name) {
        for (int i = 0; i < this.chairs.size(); i++) {
            if (this.chairs.get(i) != null) {
                if (!name.equals(this.chairs.get(i).getName())) { // Sempre que comparar strings, usar "".equals"
                    System.out.println("fail: cliente nao esta no cinema");
                    return;
                }
                this.chairs.set(i, null);
                break; 
            }
        } 
    }

    public String toString() {
        String out = "[]";
        int pos = 1;
        char blank = '-';
        String newOut = out.substring(0, pos); 
        Client client;

        for (int i = 0; i < this.chairs.size(); i++) {
            if (this.chairs.get(i) != null) {
                client = this.chairs.get(i);
                if (i < this.chairs.size() - 1) {
                    newOut += client.getName() + ":" + client.getPhone() + " ";
                } else {
                    newOut += client.getName() + ":" + client.getPhone();
                }
            } else {
                if (i < this.chairs.size() - 1) {
                    newOut += blank + " ";
                } else {
                    newOut += blank;
                }
            }
        }
        newOut += out.substring(pos);

        return newOut;
    }
}