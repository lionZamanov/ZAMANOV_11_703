package ru.itis;

public class Soldier implements Army {
    @Override
    public void attack() {
        System.out.println("Attack!!!");
    }
}
