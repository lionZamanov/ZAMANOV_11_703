package ru.itis;

public class Snake implements InterfaceComponent{

    private int exp;

    public Snake() {
        this.exp = 0;
    }

    public int getExp(int i){
        exp += i;
        return exp;
    }
    @Override
    public void crawl() {
        System.out.println("Im crawling");
    }
}
