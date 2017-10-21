package ru.itis;

import java.util.*;

public class Array_6 {
    public static void main(String[] args) {
        Random r = new Random(); //создание объекта класса  Random
        int
            n = 10;
        double[] x = new double[n];
        int[] y = new int[n];
        int[] z = new int[n];
        x[0] = r.nextInt(100) - 50;

        for(int i = 1; i < n; i++){
            x[i] = r.nextInt(100) - 50;
            if(x[i]*x[i-1] < 0) {
                y[i] = 1;
            }else y[i] = 0;

            if(x[i] < x[i-1]) {
                z[i] = 1;
            }else z[i] = 0;
        }
        System.out.println(Arrays.toString(y));
        System.out.println(Arrays.toString(z));
    }
}
