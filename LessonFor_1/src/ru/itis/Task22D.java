//Задание 10(г), стр 22

package ru.itis;

import java.util.Scanner;

public class Task22D {
    public static void main(String[] args){

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k;
        double sum = 0;
        double x = in.nextDouble();
        double an = x;
        int fact;
        int fact1 = 1;
        int fact2 = 1;
        for(k = 1; k <= 2*n; k++){
            fact1 *= (2*k - 1);
            fact2 *= 2*k;
            if (k%2 == 0) fact = fact2; else fact = fact1;
            sum += an*fact;
            an *= x;
        }
        System.out.println(sum);
    }
}