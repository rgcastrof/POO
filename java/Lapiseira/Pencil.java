package Lapiseira;

import java.util.LinkedList;

public class Pencil {
    private double thickness;
    private Lead tip;
    private LinkedList<Lead> barrel;
    private boolean hasLead;

    public Pencil(double thickness) {
        this.thickness = thickness;
        this.tip = null;
        this.barrel = new LinkedList<>();
        this.hasLead = false;
    }
    
    public void insert(Lead lead) {
        if (lead.getThickness() != this.thickness) {
            System.out.println("fail: calibre incompatível");
            return;
        }

        this.barrel.add(lead);
    }

    public void pull() {
        if (hasLead) {
            System.out.println("fail: ja existe grafite no bico");
        } else {
            this.tip = this.barrel.peek();
            this.barrel.poll();
            this.hasLead = true;
        }
    }

    public void remove() {
        if (hasLead) {
            this.tip = null;
            this.hasLead = false;
        } else {
            System.out.println("fail: nao existe grafite no bico");
        }
    }

    public void writePage() {
        if (!hasLead) {
            System.out.println("fail: nao existe grafite no bico");
        } else {
            if (this.tip.getSize() <= 10) {
                System.out.println("fail: tamanho insuficiente");
            } else {
                int temp = this.tip.getSize() - this.tip.usagePerSheet(this.tip.getHardness());

                if (temp < 10) {
                    System.out.println("fail: folha incompleta");
                    this.tip.setSize(10);
                } else {
                    this.tip.setSize(temp);
                }
            }
        }
    }

    @Override
    public String toString() {
        String output = "calibre: " + this.thickness + ", bico: ";
        if (this.tip == null) {
            output += "[]";
        } else {
            output += this.tip.toString();
        }

        output += ", tambor: <";

        if (this.barrel.size() == 0) {
            output += "";
        } else {
            for (int i = 0; i < this.barrel.size(); i++) {
                output += this.barrel.get(i).toString();
            }
        }

        output += ">";

        return output;
    }
}
