package Topic;

import java.util.ArrayList;

public class Topic {
    private ArrayList<Pass> normalSeats;
    private ArrayList<Pass> prioritySeats;

    public Topic(int totalCapacity, int priorityCapacity) {
        int normalCapacity = totalCapacity - priorityCapacity;
        this.normalSeats = new ArrayList<>();
        for (int i = 0; i < normalCapacity; i++) {
            this.normalSeats.add(null);
        }

        this.prioritySeats = new ArrayList<>();
        for (int i = 0; i < priorityCapacity; i++) {
            this.prioritySeats.add(null);
        }
    }

    public boolean checkFullBus() {
        int flagNormalSeats = 0;
        int flagPrioritySeats = 0;

        for (int i = 0; i < this.normalSeats.size(); i++) {
            if (this.normalSeats.get(i) != null) {
                flagNormalSeats++;
            }
        }
        for (int i = 0; i < this.prioritySeats.size(); i++) {
            if (this.prioritySeats.get(i) != null) {
                flagPrioritySeats++;
            }
        }

        if (flagNormalSeats == this.normalSeats.size() && flagPrioritySeats == this.prioritySeats.size()) {
            return true;
        }

        return false;
    }

    public boolean checkPassAlreadyIn(Pass pass) {
        for (int i = 0; i < this.prioritySeats.size(); i++) {
            if (this.prioritySeats.get(i) != null) {
                if (pass.getName().equals(this.prioritySeats.get(i).getName())) {
                    return true;
                }

            }
        }
        for (int i = 0; i < this.normalSeats.size(); i++) {
            if (this.normalSeats.get(i) != null) {
                if (pass.getName().equals(this.normalSeats.get(i).getName())) {
                    return true;
                }

            }
        }

        return false;
    }

    public void insert(Pass pass) {
        if (checkFullBus()) {
            System.out.println("fail: topic lotada");
        } else {
            if (checkPassAlreadyIn(pass)) {
                System.out.println("fail: " + pass.getName() + " ja esta na topic");
            } else {
                if (pass.getAge() >= 60) {
                    for (int i = 0; i < this.prioritySeats.size(); i++) {
                        if (this.prioritySeats.get(i) == null) {
                            this.prioritySeats.set(i, pass);
                            return;
                        }
                    }

                    for (int i = 0; i < this.normalSeats.size(); i++) {
                        if (this.normalSeats.get(i) == null) {
                            this.normalSeats.set(i, pass);
                            return;
                        }
                    }
                } else {
                    for (int i = 0; i < this.normalSeats.size(); i++) {
                        if (this.normalSeats.get(i) == null) {
                            this.normalSeats.set(i, pass);
                            return;
                        }
                    }
                    
                    for (int i = 0; i < this.prioritySeats.size(); i++) {
                        if (this.prioritySeats.get(i) == null) {
                            this.prioritySeats.set(i, pass);
                            return;
                        }
                    }
                }

            }

        }
    }

    public void out(String name) {
        for (int i = 0; i < this.prioritySeats.size(); i++) {
            if (this.prioritySeats.get(i).getName().equals(name)) {
                this.prioritySeats.set(i, null);
                return;
            }
        } 
        for (int i = 0; i < this.normalSeats.size(); i++) {
            if (this.normalSeats.get(i).getName().equals(name)) {
                this.normalSeats.set(i, null);
                return;
            }
        }
        System.out.println("fail: " + name + " nao esta na topic");

    }

    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("[");

        for (int i = 0; i < this.prioritySeats.size(); i++) {
            if (this.prioritySeats.get(i) == null) {
                sb.append("@ ");
            } else {
                sb.append("@" + this.prioritySeats.get(i).toString() + " ");
            }
        }
        
        for (int i = 0; i < this.normalSeats.size(); i++) {
            if (this.normalSeats.get(i) == null) {
                if (i < this.normalSeats.size() - 1) {
                    sb.append("= "); 
                } else {
                    sb.append("=");
                }
            } else {
                if (i < this.normalSeats.size() - 1) {
                    sb.append("=" + this.normalSeats.get(i).toString() + " ");
                } else {
                    sb.append("=" + this.normalSeats.get(i).toString());
                }
            }
        }

        sb.append("]");
        return sb.toString();
    }
}
