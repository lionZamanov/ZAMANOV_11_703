package ru.itis;

import java.util.Scanner;

public class Tasks {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int e[] = {124,13,214124,123};
        int a = 3423,
                max = 0;
        while(a != 0){
            if(a % 10 > max){
                max = a % 10;
            }
            a /= 10;
        }
        System.out.println(max); //Наибольшая цифра
        System.out.println(min(e)); //35
        System.out.println(exist23(7477)); //36

    }
    public static int min (int[] a){
        int min = 2141412412;
        int count = 0;
        for (int i = 0; i < a.length; i++) {
            while(a[i] != 0){
                a[i] /= 10;
                count++;
            }
            if(count < min){
                min = count;
            }
            count = 0;
        }
        return min;
    }
    public static boolean exist23(int a){
        while(a != 0){
            if((a % 10) % 3 == 0 || (a % 10) % 2 == 0){
                return true;
            }
            a /= 10;
        }
        return false;
    }
}
