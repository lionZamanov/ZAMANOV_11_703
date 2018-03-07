package ru.itis;

import java.util.Scanner;

public class String366 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] strings = new String[10];
        String a = in.nextLine(),
                t;
        boolean
                flag;
        for (int i = 0; i < strings.length; i++) {
            strings[i] = in.nextLine();
        }
        for (int i = 0; i < strings.length; i++) {
            flag = false;
            for (int j = 0; j < strings[i].length() - a.length()+1 && !flag; j++) {
                t = "";
                for (int k = 0; k < a.length(); k++) {
                    t += strings[i].charAt(k + j);
                }
                if(equalWithError(a, t)){
                    System.out.println(strings[i]);
                    flag = true;
                }
            }
        }
    }

    public static boolean equalWithError(String A, String s){
        int counter = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            if(s.charAt(i) == A.charAt(i+1) && s.charAt(i + 1) == A.charAt(i)){
                counter++;
            }
        }
        if (counter == 1) return true;
        return false;
    }
}
