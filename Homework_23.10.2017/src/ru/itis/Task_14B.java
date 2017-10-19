package ru.itis;
import java.util.Scanner;

public class Task_14B {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        double
                a = in.nextDouble(), // a > 1
                x = in.nextDouble(),
                t = 1.0/a,
                s = Math.log(t*x)/t,
                e = 0.0001;

        while (t >= e){
            t /= a;
            s += t*Math.log(t*x);
        }

        System.out.println(s);
    }
}
