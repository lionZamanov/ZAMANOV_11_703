package ru.itis;

import java.util.Scanner;

public class Tasks_50 {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        String s1 = in.nextLine();
        String s2 = in.nextLine();
        boolean flag = true;
        for (int i = 0; i < s1.length() && flag; i++) {
            if(s1.charAt(i) != s2.charAt(i)){
                flag = false;
            }
        }
        System.out.println(flag); //50
    }
}
