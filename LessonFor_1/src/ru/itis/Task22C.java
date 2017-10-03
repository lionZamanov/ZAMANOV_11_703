//Задание 10(в), стр 22

package ru.itis;

import java.util.Scanner;

public class Task22C {
    public static void main(String[] args){

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k;
        double sum = 0;
        double x = in.nextDouble();
        double an = x*x;
        int fact = 1;
        int fact2 = 1;
        for(k = 1; k <= n; k++){
            fact *= (2*k - 1);
            fact2 *= 2*k;
            sum += an*fact/fact2;
            an *= x*x;
        }

        System.out.println(sum);
    }
}