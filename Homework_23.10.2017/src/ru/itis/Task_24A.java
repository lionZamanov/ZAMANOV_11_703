package ru.itis;//-

import java.util.Scanner;

public class Task_24A {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        double
                x = in.nextDouble(),
                e = 0.0001,
                s,
                t,
                b0,
                b1,
                b2,
                c0,
                c1,
                c2;
        int
                n = 3;

        b1 = Math.cos(x);
        c1 = Math.sin(x);
        b2 = b1*b1 - c1*c1;
        c2 = c1*b1 + c1*b1;
        t = c2/2;
        s = c1 + t;

        while(Math.abs(t) >= e){
            b0 = b2;
            c0 = c2;
            b2 = b1*b0 - c1*c0;
            c2 = c0*b1 + c1*b0;
            t *= c2/(n*c0); //неверная логика
            s += t;
            n++;
        }
        System.out.println(s);
    }
}

/*

 b0 = cos

 */
