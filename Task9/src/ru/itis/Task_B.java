package ru.itis;//+
import java.util.Scanner;

public class Task_B {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int
            m = 2,
                n = in.nextInt();
        double
            s = 1.0/2,
                t = s;

        while(m < n){
            t *= (m - 1)*(double)(m - 1)/(2*m*(2*m-1));
            s += t;
            m++;
        }
        System.out.println(s);
    }
}
