package ru.itis;//+

import java.util.Arrays;
import java.util.Random;

public class Array_22B {
    public static void main(String[] args) {
        Random r = new Random(); //создание объекта класса  Random
        int
            n = 10,
                s = 0;
        boolean
            flag = true;
        int[] x = new int[n];

        for(int i = 0; i < n; i++){
            x[i] = r.nextInt(10); //заполняем массив
            if(prime(x[i])){
                s++;
            }
        }

        System.out.println(Arrays.toString(x));
        System.out.println(s);
    }
    public static boolean prime(int a){
        if((a <= 0) || (a ==1)) return false;
        for (int i = 2; i*i <= a; i++){
            if(a % i == 0) return false;
        }
        return true;
    }
}
