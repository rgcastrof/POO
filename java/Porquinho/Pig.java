import java.text.DecimalFormat;
import java.util.ArrayList;

public class Pig {
    private boolean isBroken;
    private ArrayList<Coin> coins;
    private ArrayList<Item> itens;
    private int maxVolume;
    private String state;
    private double actualValue;
    private int actualVolume;

    public Pig(int maxVolume) {
        this.isBroken = false;
        this.coins = new ArrayList<>();
        this.itens = new ArrayList<>();
        this.maxVolume = maxVolume;
        this.state = "intact";
        this.actualValue = 0;
        this.actualVolume = 0;
    }

    public ArrayList<Coin> getCoins() { return coins; }
    
    public ArrayList<Item> getItens() { return itens; }

    public String getState() { return state; }
    public void setState(String state) { this.state = state; }

    public void addCoin(int label) {
        if (this.isBroken) {
            System.out.println("fail: the pig is broken");
        } else {
            switch (label) {
                case 10:
                    this.coins.add(Coin.C10);
                    this.actualValue += Coin.C10.getValue();
                    this.actualVolume += Coin.C10.getVolume();

                    if (this.actualVolume > this.maxVolume) {
                        System.out.println("fail: the pig is full");
                        getCoins().remove(getCoins().size() - 1);
                        this.actualValue -= Coin.C10.getValue();
                        this.actualVolume -= Coin.C10.getVolume();
                    }
                    break;
                case 25:
                    this.coins.add(Coin.C25);
                    this.actualValue += Coin.C25.getValue();
                    this.actualVolume += Coin.C25.getVolume();

                    if (this.actualVolume > this.maxVolume) {
                        System.out.println("fail: the pig is full");
                        getCoins().remove(getCoins().size() - 1);
                        this.actualValue -= Coin.C25.getValue();
                        this.actualVolume -= Coin.C25.getVolume();
                    }
                    break;
                case 50:
                    this.coins.add(Coin.C50);
                    this.actualValue += Coin.C50.getValue();
                    this.actualVolume += Coin.C50.getVolume();

                    if (this.actualVolume > this.maxVolume) {
                        System.out.println("fail: the pig is full");
                        getCoins().remove(getCoins().size() - 1);
                        this.actualValue -= Coin.C50.getValue();
                        this.actualVolume -= Coin.C50.getVolume();
                    }
                    break;
                case 100:
                    this.coins.add(Coin.C100);
                    this.actualValue += Coin.C100.getValue();
                    this.actualVolume += Coin.C100.getVolume();

                    if (this.actualVolume > this.maxVolume) {
                        System.out.println("fail: the pig is full");
                        getCoins().remove(getCoins().size() - 1);
                        this.actualValue -= Coin.C100.getValue();
                        this.actualVolume -= Coin.C100.getVolume();
                    }
                    break;
                default:
                    System.out.println("fail: valor de moeda inválido");
                    break;
            }


        }

    }

    public void addItem(String label, int volume) {
        if (volume <= 0) {
            System.out.println("fail: volume invalido");
            return;
        }
        if (this.isBroken) {
            System.out.println("fail: the pig is broken");
        } else {
            getItens().add(new Item(label, volume));
            this.actualVolume += volume;
            if (this.actualVolume > this.maxVolume) {
                System.out.println("fail: the pig is full");
                getItens().remove(getItens().size() - 1);
                this.actualVolume -= volume;
            }
        }
    }

    public void breakPig() {
        if (isBroken) {
            System.out.println("fail: the pig is broken");
        } else {
            setState("broken");
            this.actualVolume = 0;
            this.isBroken = true;
        }
    }

    public void extractCoins() {
        if (!isBroken) {
            System.out.println("fail: you must break the pig first");
        } else {
            System.out.println(getCoins().toString());
            this.actualValue = 0;
            getCoins().clear();
        }
    }

    public void extractItens() {
        if (!isBroken) {
            System.out.println("fail: you must break the pig first");
        } else {
            System.out.println(getItens().toString());
            getItens().clear();
        }
    }

    public String toString() {
        DecimalFormat df = new DecimalFormat("0.00");
        return "state=" + getState() + " : coins=" + getCoins() + " : itens=" + getItens() + " : value=" +
            df.format(this.actualValue) + " : volume=" + this.actualVolume + "/" + this.maxVolume;
            
    }
}
