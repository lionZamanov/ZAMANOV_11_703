package ru.itis;

import java.util.Scanner;

public class Task_214 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        String[] strs = s.split(" ");
        for(String str : strs){
            if(f(str)){
                System.out.println(str);
            }
        }
    }
     public static boolean f(String a){
            return a.charAt(0) == a.charAt(a.length() - 1);
     }
}
