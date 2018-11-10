package ru.itis;

import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        CompoundArmy compoundArmy = new CompoundArmy();
        Division division1 = new Division();
        Division division2 = new Division();
        Legion legion1 = new Legion();
        Legion legion2 = new Legion();
        Legion legion3 = new Legion();
        Soldier soldier1 = new Soldier();
        Soldier soldier2 = new Soldier();
        Soldier soldier3 = new Soldier();
        Soldier soldier4 = new Soldier();
        legion1.add(soldier1);
        legion2.add(soldier2);
        legion3.add(soldier3);
        legion3.add(soldier4);
        division1.add(legion1);
        division1.add(legion2);
        division2.add(legion3);
        compoundArmy.add(division1);
        compoundArmy.add(division2);
        division2.attack();
    }
}
