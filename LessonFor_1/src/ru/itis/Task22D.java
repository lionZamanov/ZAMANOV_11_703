//Задание 10(г), стр 22

package ru.itis;

import java.util.Scanner;

public class Task22D {
    public static void main(String[] args){

        Scanner in = new Scanner(System.in);
        int
                n = in.nextInt(),
                p = -1,
                k;
        double
                x = in.nextDouble(),
                sum = x,
                prev = x;

        for(k = 2; k <= 2*n; k++){
            prev *= x;
        }
        System.out.println(sum);
    }
}