package ru.itis;

import java.util.Arrays;
import java.util.Random;

public class Array_22A {
    public static void main(String[] args) {
        Random r = new Random(); //создание объекта класса  Random
        int
            n = 10,
                s1 = 0,
                s2 = 0;
        int[] x = new int[n];


        for(int i = 0; i < n; i++){
            x[i] = r.nextInt(100)-50; //заполняем массив
            if(x[i] > 0){
                s1 += x[i];
            }else{
                s2 += x[i];
            }
        }

        System.out.println(Arrays.toString(x));
        System.out.println(s1);
        System.out.println(s2);
    }
}
