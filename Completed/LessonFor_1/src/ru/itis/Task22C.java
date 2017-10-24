//Задание 10(в), стр 22

package ru.itis;

import java.util.Scanner;

public class Task22C {
    public static void main(String[] args){

        Scanner in = new Scanner(System.in);
        int
                n = in.nextInt(),
                k;
        double
                x = in.nextDouble(),
                sum = x*x,
                prev = sum;

        for(k = 2; k <= n; k++){
            prev *= x*x*(2*k - 1)/(2*k);
            sum += prev;
        }

        System.out.println(sum);
    }
}