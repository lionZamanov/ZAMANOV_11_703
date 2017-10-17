package ru.itis;

import java.util.Scanner;

public class Task29B {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int
                i = 1;
        double
                e = 0.0001,
                x0 = 0,
                x1;
        x1 = Math.cos(x0);
        while(Math.abs(x0 - x1) > e){
            x0 = x1;
            x1 = Math.cos(x0);
            i++;
        }
        System.out.println(i);
    }
}
