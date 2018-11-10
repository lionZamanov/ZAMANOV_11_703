package ru.itis;

public class Snake extends Animal{

    private int exp;

    public Snake() {
        this.exp = 0;
    }

    public int getExp(int i){
        exp += i;
        return exp;
    }


    @Override
    public void move() {
        System.out.println("I can crawl");
    }
}
