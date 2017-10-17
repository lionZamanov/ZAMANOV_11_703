package ru.itis;

import java.util.Scanner;

public class Task28 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        double
            x = in.nextDouble(),
            b0 = 1 - x,
            b1,
            a0 = x,
                a1,
                e = 0.0001;

        a1 = a0*(1 + b0/2);
        b1 = b0*b0*(3 + b0);

        while(b1 > e){
            b0 = b1;
            a0 = a1;
            a1 = a0*(1 + b0/2);
            b1 = b0*b0*(3 + b0);
        }

        System.out.println(a1);
    }
}
