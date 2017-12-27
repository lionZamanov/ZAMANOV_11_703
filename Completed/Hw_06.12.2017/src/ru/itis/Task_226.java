package ru.itis;

import java.util.Arrays;

public class Task_226 {
    public static void main(String[] args) {
        String t;
        String[] s = {"Ночь", "Улица", "Фонарь", "Аптека"};
        for (int i = 0; i < s.length; i++) {
            for (int j = 0; j < s.length-1; j++) {
                if(min(s[j],s[j+1]) == s[j+1]){
                    t = s[j+1];
                    s[j+1] = s[j];
                    s[j] = t;
                }
            }
        }
        System.out.println(Arrays.toString(s));
    }
    public static String min(String s1, String s2){
        int i;
        for (i = 0; i < s1.length() && i < s2.length(); i++) {
            if(Character.toLowerCase(s1.charAt(i)) > Character.toLowerCase(s2.charAt(i))){
                return s2;
            }else if(Character.toLowerCase(s1.charAt(i)) < Character.toLowerCase(s2.charAt(i))){
                return s1;
            }
        }
        return i == s1.length()? s1:s2;
    }
}
