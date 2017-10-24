package ru.itis;

import java.util.Arrays;
import java.util.Random;

public class Array_11A {
    public static void main(String[] args) {
        Random r = new Random(); //создание объекта класса  Random
        int
            n = 10,
                a;
        int[] x = new int[n];

        for(int i = 0; i < n; i++){
            x[i] = r.nextInt(100); //заполняем массив
        }
        System.out.println(Arrays.toString(x));

        for(int i = 0; i < n/2; i++){
            a = x[i];
            x[i] = x[n-1-i];
            x[n-1-i] = a;
        }
        System.out.println(Arrays.toString(x));
    }
}
