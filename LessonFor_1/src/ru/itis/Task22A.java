//Задание 10(а), стр 22

package ru.itis;

import java.util.Scanner;

public class Task22A {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        double x = in.nextDouble();
        int k;
        double sum = x;
        double prev = x;
        int p = -1;
        for(k = 1; k <= n; k++){
            prev *= (2*(k-1)+1)*x*x*p/((2*k+1)*k);
            sum += prev;
            p = -p;
        }
        System.out.println(sum);
    }

}
