package ru.itis;//+

import java.util.Scanner;

public class Task_C {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int
            p = -1,
                n = in.nextInt(),
                m = 1;
        double
            t = 1,
                s = t;

        while(m < n){
            t *= (double)(2*(m-1) + 1)/(3*(2*m + 1));
            s += p*t;
            m++;
            p = -p;
        }
        System.out.println(s);
    }
}
