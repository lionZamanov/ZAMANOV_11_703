package ru.itis;
import java.util.Scanner;

public class Task_23B{
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        double
                s,
                a = in.nextDouble(), // 0 < a < b
                b = in.nextDouble(),
                x = in.nextDouble(),
                v0 = a,
                v1 = a,
                p = 1,
                t = 4.0,
                v2;
        v2 = v0 + v1;
        s = v0*Math.cos(v0*x)*Math.cos(v0*x) - v1*Math.cos(v1*x)*Math.cos(v1*x)/2;
        while(v2 <= b){
            s += p*v2 * Math.cos(v2*x) * Math.cos(v2*x)/t;
            v0 = v1;
            v1 = v2;
            v2 = v1 + v0;
            t /= 2;
            p = -p;

        }
        System.out.println(s);
    }
}
