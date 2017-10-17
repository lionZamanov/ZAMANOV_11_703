package ru.itis;

import java.util.Scanner;

public class Task20D {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        double
                x = in.nextDouble(),
                a = in.nextDouble(),
                b = in.nextDouble(),
                c = in.nextDouble(),
                d = in.nextDouble(),
                e = in.nextDouble(),
                f = in.nextDouble(),
                g = in.nextDouble(),
                h = in.nextDouble(),
                x0,
                x1,
                y0,
                y1,
                x2,
                y2,
                y3,
                x3;
        int
                n = in.nextInt();

        x0 = y0 = a;
        x1 = y1 = b;
        x2 = y2 = c;
        x3 = d*x2 + e*y1 + f*x0;
        y3 = g*x2 + h*y1;

        for (int i = 3; i < n;i++){
            x0 = x1;
            x1 = x2;
            x2 = x3;
            y0 = y1;
            y1 = y2;
            y2 = y3;
            x3 = d*x2 + e*y1 + f*x0;
            y3 = g*x2 + h*y1;
        }
        System.out.println(x3);
        System.out.println(y3);
    }
}