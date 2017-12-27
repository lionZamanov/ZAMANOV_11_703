package ru.itis;

import java.util.Scanner;

public class Task_222 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int counter = 0;
        String s = in.nextLine();
        String[] strs = s.split(" ");
        for(String str : strs){
            if(f(str)){
                System.out.println(str);
                counter++;
            }
        }
        System.out.println(counter);
    }
     public static boolean f(String a){
         for (int i = 0; i < a.length()/2; i++) {
             if(a.charAt(i) != a.charAt(a.length() - i - 1)){
                 return false;
             }
         }
            return true;
     }
}
