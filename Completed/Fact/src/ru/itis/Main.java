package ru.itis;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        int array[] = new int[numbersAmount(a)];
        numToArray(a, array);
        System.out.println(findAmount(array));
    }

    public static int factorial(int a){
        if(a == 0){
            return 1;
        }
        return a*factorial(a - 1);
    }

    public static void numToArray(int a, int[] array){
        int i = 0,
            c;
        while(a != 0){
            array[i] = a % 10;
            a /= 10;
            i++;
        }

        for (int j = 0; j < i / 2; j++) {
            c = array[j];
            array[j] = array[i - j - 1];
            array[i - j - 1] = c;
        }
    }

    public static int findAmount(int[] array){
        int result = 0;
        for (int j = 0; j < array.length - 1; j++) {
            for (int k = j + 1; k < array.length; k++) {
                if(array[j] < array[k]){
                    result += factorial(array.length - j - 1);
                }
            }
        }
        return result;
    }

    public static int numbersAmount(int a){
        int i = 0;
        while(a != 0){
            a /= 10;
            i++;
        }
        return i;
    }
}
