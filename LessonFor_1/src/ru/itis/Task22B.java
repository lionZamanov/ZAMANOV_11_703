//Задание 10(б), стр 22

package ru.itis;

import java.util.Scanner;

public class Task22B {
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

        for(k = 1; k <= n; k++){
            prev *= p*x*x*x*x*(4*(k-1)+1)/(2*k*(2*k-1)*(4*k+1));
            sum += prev;
        }
        System.out.println(sum);
    }
}
/*
    k = 0
    fact = 1  fac = 1

    k = 1
    fact = 2 fac = 2

    k = 2
    fact = 24 fac = 24

    k = 3
    fact = 720 fac = 144*5 = 720

    k = 4
    fact = 40 320  fac = 1440*


 */