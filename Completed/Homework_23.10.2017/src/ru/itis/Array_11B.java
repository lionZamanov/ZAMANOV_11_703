package ru.itis;

import java.util.Arrays;
import java.util.Random;

public class Array_11B {
    public static void main(String[] args) {
        Random r = new Random(); //создание объекта класса  Random
        int
            n = 10;
        int[] x = new int[n];
        int[] y = new int[n];
        int[] z = new int[n];

        for(int i = 0; i < n; i++){
            x[i] = r.nextInt(100); //заполняем массив
        }

        System.out.println(Arrays.toString(x));
        for(int i = 0; i < n-1; i++){
            y[i] = x[i+1];
        }for(int i = 1; i < n; i++){
            z[i] = x[i-1];
        }

        y[n-1] = x[0];
        z[0] = x[n-1];

        System.out.println(Arrays.toString(y));
        System.out.println(Arrays.toString(z));
    }
}
