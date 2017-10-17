package ru.itis;
import java.util.Scanner;

public class Task12D {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int
                n = 1,
                p = -1;
        double
                x = in.nextDouble(),
                t = 1,
                s = 1,
                e = 0.00001;

        while(Math.abs(t) > e){
            t *= x*x/(2*n*(2*n - 1));
            s += p*t;
            p = -p;
            n++;
        }
        System.out.println(s);
    }
}
