package ru.itis;
import java.util.Scanner;

public class Task11B {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        double sum = 0;
        double prev = 1;
        for (int k = 0; k <= n; k++) {
            prev *= Math.cos(k) / Math.sin(k);
            sum += prev;
        }
        System.out.println(sum);
    }
}
