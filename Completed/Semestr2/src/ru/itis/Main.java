package ru.itis;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = 10;
        double x;
        boolean flag = false;

        double[] arr = new double[n];

        for (int i = 0; i < n; i++) {
            arr[i] = 2 * i;
        }

        for (int i = 0; i < 3; i++) {

            x = in.nextDouble();
            for (int j = 0; j < n - 1 && !flag; j++) {
                if(x >= arr[j] && x < arr[j+1]){
                    flag = true;
                    System.out.println(f(x, arr[j], arr[j+1]) );
                }
            }
            flag = false;
        }

    }
    public static double f(double x, double x1, double x2){
        return (x - x2)*F(x1)/(x1 - x2) + (x - x1)*F(x2)/(x2 - x1);
    }
    public static double F(double x){
        return Math.log(x*x + x + 1)/(2 + x*x);
    }
}
