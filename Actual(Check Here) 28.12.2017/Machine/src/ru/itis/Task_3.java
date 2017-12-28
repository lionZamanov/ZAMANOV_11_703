package ru.itis;

import java.util.Scanner;

public class Task_3 {
    public static void main(String[] args) {
        String s,
                fin = "";
        Scanner in = new Scanner(System.in);

        s = in.nextLine();
        if(f(s)){
            fin += s;
        }
    }

    public static boolean f(String s){
        boolean flag = true,
                result = false;
        int i = 0,
                state = 0;

        while (i < s.length() && flag) {
            switch (state) {
                case 0:
                    if (s.charAt(i) == '0'){
                        i++;
                    }else{
                        state++;
                    }
                    break;
                case 1:
                    if (s.charAt(i) != '1') {
                        flag = false;
                    }else{
                        i++;
                        state++;
                    }
                    break;
                case 2:
                    if (s.charAt(i) == '1') {
                        i++;
                    }else{
                        state++;
                    }
                    break;
                case 3:
                    if (s.charAt(i) == '0') {
                        result = true;
                        i++;
                    }else{
                        flag = false;
                    }
                    break;
                case 4:
                    if (s.charAt(i) != '0') {
                        result = false;
                    }else{
                        i++;
                    }
                    break;
            }
        }
        return result;
    }
}
