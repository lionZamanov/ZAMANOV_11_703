package ru.itis;
import java.util.Scanner;


public class Task12A {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        double e = 0.0001;
        double s = 1;
        int i = 1;
        double prev = 1;
        int x = in.nextInt();
        while(Math.abs(prev) > e) {
            prev *=(double)x/i;  // логика нарушена
            s += prev;
            i++;
        }
        System.out.println(i);
        System.out.println(s);
    }
}
