package ru.itis;
import java.util.Scanner;

public class Task11D {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        double p = 1;
        double prev = 1;
        for (int k = 1; k <= n; k++) {
            prev *= Math.tan(k);
            p *= prev;
        }
        System.out.println(p);
    }
}