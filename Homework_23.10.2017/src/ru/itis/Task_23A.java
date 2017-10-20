package ru.itis;
import java.util.Scanner;

public class Task_23A{
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        double
                s,
                a = in.nextDouble(), // 0 < a < b
                b = in.nextDouble(),
                x = in.nextDouble(),
                v0 = a,
                v1 = a,
                v2;

        v2 = v0 + v1;
        s = Math.log(v0*x) + Math.log(v1*x) + Math.log(v2*x);
        while(v2 <= b){
            v0 = v1;
            v1 = v2;
            v2 = v1 + v0;
            s += Math.log(v2*x);
        }
        System.out.println(s);
    }
}
