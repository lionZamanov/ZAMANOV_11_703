package ru.itis;

public class Main {

    public static void main(String[] args) {
        int n = 10;
        int t = 0;
        int s;
        int[] a = new int[n];
        int[] b = new int[n];

        for (int i = 0; i < n; i++){
            a[i] += 1 + t;
            b[i] += t;
            t += 2;
        }


    }
}
