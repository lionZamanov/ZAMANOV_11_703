package ru.itis;
import java.util.Scanner;

public class Task12C {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int
                n = 2,
                p = -1;
        double
                x = in.nextDouble(),
                t = x,
                s = x,
                e = 0.00001;

        while(Math.abs(t) > e){
            t *= x*(n-1)/n;
            s += p*t;
            p = -p;
            n++;
        }
        System.out.println(s);
    }
}
