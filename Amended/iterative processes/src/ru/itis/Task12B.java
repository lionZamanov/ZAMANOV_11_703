package ru.itis;
import java.util.Scanner;


public class Task12B {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int
                i = 0,
                p = 1;
        double
                x = in.nextDouble(),
                t = x,
                s = t,
                e = 0.0001;
        while(Math.abs(t) > e) {
            i++;
            p = -p;
            t = x*x/((2*i+1)*2*i);
            s += p*t;
        }
        System.out.println(s);
    }
}
