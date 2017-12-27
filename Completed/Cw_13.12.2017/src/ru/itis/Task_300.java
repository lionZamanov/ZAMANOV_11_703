package ru.itis;

import java.util.Scanner;

public class Task_300 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        boolean A = false,
                a = false,
                number = false;
        for (int i = 0; i < str.length() && !(A && a && number); i++) {
            if(str.charAt(i) >= 65 && str.charAt(i) <= 90){
                A = true;
            }
            if(str.charAt(i) >= 97 && str.charAt(i) <= 122){
                a = true;
            }
            if(Character.isDigit(str.charAt(i))){
                number = true;
            }
        }
        System.out.println(A && a && number && str.length() >= 8);
    }
}
