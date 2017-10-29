package ru.itis;
import java.util.Scanner;
public class Task_1 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        double
            x = in.nextDouble(), // 0 < x < 2
                a0 = x,
                b0 = 1 - x,
                a1,
                eps = 0.0001,
                b1;

        b1 = b0*b0*(3 + b0);
        a1 = a0*(1 + b0/2);
        while(b1 <= eps){
            a0 = a1;
            b0 = b1;
            b1 = b0*b0*(3 + b0);
            a1 = a0*(1 + b0/2);
        }
        System.out.println(a1);
    }
}
