package ru.itis;
import java.util.Scanner;

public class Task_1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int
                n = 5,
                k = 1,
                min;
        int[] a = new int[n];
        for(int i = 0; i < a.length; i++){
            a[i] = in.nextInt();
        }
        min = a[0];

        for(int i = 1; i < a.length; i++){
            if(a[i] < min){
                min = a[i];
                k = 1;
            }else if(a[i] == min){
                k++;
            }
        }
        System.out.println(min);
        System.out.println(k);
    }
}
