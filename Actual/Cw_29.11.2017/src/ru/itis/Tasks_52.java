package ru.itis;

import java.util.Scanner;

public class Tasks_52 {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        String s2 = in.nextLine();
        String s1 = in.nextLine();
        boolean flag = false;
        for (int i = 0; i <= s2.length() - s1.length() && !flag; i++) {
            flag = true;
            for (int j = 0; j < s1.length(); j++) {
                if(s1.charAt(j) != s2.charAt(j+i)){
                    flag = false;
                }
            }
        }
        System.out.println(flag);
    }
}
// Пыль - 4 {0,1,2,3}
// ль - 2 {0};