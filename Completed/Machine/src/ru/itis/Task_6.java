package ru.itis;

import java.util.Scanner;

public class Task_6 {
    public static void main(String[] args) {
        String s,
                fin = "";
        Scanner in = new Scanner(System.in);

        s = "1010101101";
        System.out.println(f(s));

    }

    public static boolean f(String s){
        boolean flag = true,
                result = true;
        int i = 0,
            state = 0;

        while (i < s.length()) {
            switch (state) {
                case 0:
                    if(s.charAt(i) == '1'){
                        state = 1;
                    }else{
                        state = 2;
                    }
                    break;
                case 1:
                    if(s.charAt(i) == '1'){
                        state = 0;
                    }else{
                        state = 3;
                    }
                    break;
                case 2:
                    if(s.charAt(i) == 1){
                        state = 3;
                    }else {
                        state = 0;
                    }
                    break;
                case 3:
                    if(s.charAt(i) == 1){
                        state = 2;
                    }else {
                        state = 1;
                    }
                    break;
            }
            i++;
        }
        return state == 0;
    }
}
