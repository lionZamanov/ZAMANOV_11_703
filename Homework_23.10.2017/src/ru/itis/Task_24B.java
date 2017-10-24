// Черновик
package ru.itis;//-

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

        b2 = b1*b1 - c1*c1; //Находим для cos2x
        c2 = c1*b1 + c1*b1;
        b0 = b2;
        c0 = c2;
        b2 = b1*b0 - c1*c0; //Находим для cos3x
        c2 = c0*b1 + c1*b0;
        t = b2/2;
        s = b1; // Суммируем
        while(Math.abs(t) >= e){
            s += p*t;
            b0 = b2;
            c0 = c2;
            b2 = b1*b0 - c1*c0;//Находим для cos(n+1)x
            c2 = c0*b1 + c1*b0;
            b0 = b2;
            c0 = c2;
            b2 = b1*b0 - c1*c0;//Находим для cos(n+2)x
            c2 = c0*b1 + c1*b0;
            n++;
            t = b2/n;  //неверная логика
        }
        System.out.println(s);
    }
}
