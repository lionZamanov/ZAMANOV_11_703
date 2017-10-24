package ru.itis;

import java.util.Scanner;

public class Task27 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        double
                e = 0.0001,
                x = in.nextDouble(),
                a0 = x,
                b0 = 1 - x,
                a1,
                b1;

        a1 = a0*(1 + b0/2);
        b1 = b0*b0*(3 + b0); //  0.25 * 3.5 = 0,875
        while(Math.abs(b1) > e){
            a0 = a1;
            b0 = b1;
            a1 = a0*(1 + b0/2);
            b1 = b0*b0*(3 + b0); // 2,96
        }

        System.out.println(a1);
    }
}
