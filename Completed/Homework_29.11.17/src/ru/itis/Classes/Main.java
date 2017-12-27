package ru.itis.Classes;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random rand = new Random();
        Results r = new Results();
        int[] a = new int[10];
        for (int i = 0; i < 10; i++) {
            a[i] = rand.nextInt(50) + 1;
        }
        r.addResults(a);
        System.out.println(r);
        r.sortDown();
        System.out.println(r);
        r.sortUp();
        System.out.println(r);
        System.out.println(r.averageResult());
        System.out.println(r.winner());
        System.out.println(r.quantity());
    }
}
