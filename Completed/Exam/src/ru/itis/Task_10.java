package ru.itis;

import java.util.Scanner;

public class Task_10 {

    public static void main(String[] args) {
	    int n = 2;
        int[][] a = new int[n][n];
        Scanner in = new Scanner(System.in);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j] = in.nextInt();
            }
        }

        boolean flag = false;
        for (int i = 0; i < a.length && !flag; i++) {
            if(f(a[i])){
                flag = true;
            }
        }
        System.out.println(flag);
    }

    public static boolean f(int[] a){
        for (int i = 0; i < a.length - 1; i++) {
            if(a[i] >= a[i + 1]){
                return false;
            }
        }
        return true;
    }
}
