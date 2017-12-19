package ru.itis;

import java.util.Scanner;

public class Task_232 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine(),
                result = "";
        for (int i = 0; i < str.length(); i++) {
            if(f(str.charAt(i), result)){
                result += str.charAt(i);
            }
        }
        System.out.println(result);
    }

    public static boolean f(char s, String str){
        for (int i = 0; i < str.length(); i++) {
            if(s == str.charAt(i)){
                return false;
            }
        }
        return true;
    }
}
