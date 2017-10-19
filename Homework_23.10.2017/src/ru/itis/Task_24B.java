package ru.itis;

import java.util.Scanner;

public class Task_24B {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        double
                s,
                x = in.nextDouble(),
                t,
                p = -1,
                e = 0.0001,
                b0 = 1,
                b1 = Math.cos(x),
                b2,
                c0 = 0,
                c1 = Math.sin(x),
                c2;
        int
                n = 2;

        b2 = b1*b1 - c1*c1;
        c2 = c1*b1 + c1*b1;
        t = b2;
        s = t;
        while(Math.abs(t) >= e){

            b0 = b2;
            c0 = c2;
            b2 = b1*b0 - c1*c0;
            c2 = c0*b1 + c1*b0;
            t = p*b2/n;
            s += t;
            n++;
        }
        System.out.println(s);
    }
}
