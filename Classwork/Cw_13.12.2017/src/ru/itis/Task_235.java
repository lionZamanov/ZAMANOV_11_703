package ru.itis;

import java.util.Scanner;

public class Task_235 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine(),
                substr = "",
                output = str;
        int k = 0;
        boolean flag = false;
        for (int i = 0; i < str.length(); i++) {
            if(flag && str.charAt(i) == ']'){
                output = paste(str,order(substr), k);
                flag = false;
                substr = "";
            }
            if(flag){
                substr += str.charAt(i);
            }
            if(str.charAt(i) == '['){
                flag = true;
                k = i;
            }
        }
        System.out.println(output);
    }
    public static char[] order(String str){
        char[] substr = str.toCharArray();
        char t;
        for (int i = 0; i < substr.length - 1; i++) {
            for (int j = i + 1; j < substr.length; j++) {
                if(Character.isDigit(substr[j]) && Character.isDigit(substr[i])) {
                    if (substr[i] > substr[j]) {
                        t = substr[i];
                        substr[i] = substr[j];
                        substr[j] = t;
                    }
                }
            }
        }
        return substr;
    }
    public static String paste(String str, char[] substr, int k){
        String result = "";
        for (int i = 0; i < k + 1; i++) {
            result += str.charAt(i);
        }
        for (int i = 0; i < substr.length; i++) {
            result += substr[i];
        }
        for (int i = k + substr.length + 1; i < str.length(); i++) {
            result += str.charAt(i);
        }
        return result;
    }
}
