package ru.itis;//+
import java.util.Scanner;

public class Task_14A {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        double
                x = in.nextDouble(),
                t = 1,
                p = 1,
                s = p*t*Math.sin(t*x)*Math.sin(t*x),
                e = 0.0001,
                k = 2;

        while (t >= e){
            t /= k;
            s += p*t*Math.log(t*x);
            p = -p;
            k++;
        }

        System.out.println(s);
    }
}
