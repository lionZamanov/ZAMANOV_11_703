package ru.itis;

import java.util.Scanner;

public class Task_D {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int
                n = in.nextInt(),
                m = 1;
        double
                t = 1,
                s = t;

        while(m < n){
            t *= (double)(2*(m-1) + 1)/(9*(2*m + 1));
            s += t;
            m++;
        }
        System.out.println(s);
    }
}
