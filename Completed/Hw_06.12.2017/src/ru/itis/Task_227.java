package ru.itis;

import java.util.Arrays;
import java.util.Scanner;

public class Task_227 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s1 = in.nextLine();
        String s2 = in.nextLine();
        System.out.println(sum(s1,s2));
    }
    public static String sum(String s1, String s2){
        int[] a1 = toArray(s1);
        int[] a2 = toArray(s2);
        if (a1.length < a2.length){
            int[] t = a1;
            a1 = a2;
            a2 = t;
        }
        // 0 1 2 3 4 5 6
        // [5,1,6,1,5,1]
        //     [1,2,4,5]
        int[] result = new int[a1.length+1];
        int diff = a1.length - a2.length; //2
        for (int i = a1.length; i > diff; i--){
            result[i] += a1[i - 1] + a2[i - diff - 1];
            if(result[i] > 9){
                result[i - 1]++;
                result[i] %= 10;
            }
        }
        for (int i = diff; i > 0; i--) {
            result[i] += a1[i - 1];
        }
        return toString(result);
    }
    public static String toString(int[] a){
        String str = "";
        for (int i = 0; i < a.length; i++) {
            str += a[i];
        }
        return str;
    }
    public static int[] toArray(String s1){
        int[] Array = new int[s1.length()];
        for (int i = 0; i < s1.length(); i++) {
            Array[i] = Character.digit(s1.charAt(i), 10);
        }
        return Array;
    }

}


