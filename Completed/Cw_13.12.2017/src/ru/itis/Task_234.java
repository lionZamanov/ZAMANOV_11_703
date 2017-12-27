package ru.itis;

import java.util.Scanner;

public class Task_234 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        boolean flag = false;
        while(!flag){
            str = in.nextLine();
            if(f(str)){
                flag = true;
            }
        }
        System.out.println(toDecimal(str));
    }

    public static boolean f(String str){
        for (int i = 0; i < str.length(); i++) {
            if(str.charAt(i) != '0' && str.charAt(i) != '1'){
                return false;
            }
        }
        return true;
    }

    public static int toDecimal(String str){
        int result = 0,
            t = 1;
        for (int i = str.length() - 1; i >= 0; i--) {
            if(str.charAt(i) == '1'){
                result += t;
            }
            t *= 2;
        }
        return result;
    }
}
