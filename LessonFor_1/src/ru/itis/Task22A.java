//Задание 10(а), стр 22

package ru.itis;

import java.util.Scanner;

public class Task22A {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k;
        double sum = 0;
        double x = in.nextDouble();
        double an = x;
        int fact = 1;
        int p = 1;
        for(k = 0; k <= n; k++){
            sum = sum + p*an/(fact*(2*k + 1));
            p = -p;
            fact *= (k+1);
            an *= x*x;
        }
        System.out.println(sum);
    }

}
