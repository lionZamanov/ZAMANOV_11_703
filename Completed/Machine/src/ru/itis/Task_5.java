package ru.itis;

import java.util.Scanner;

public class Task_5 {
    public static void main(String[] args) {
        String s,
                fin = "";
        Scanner in = new Scanner(System.in);

        s = "1010101";
        System.out.println(!f(s));

    }

    public static boolean f(String s){
        boolean flag = true,
                result = true;
        int i = 0,
            state = 0;

        while (i < s.length()) {
            switch (state) {
                case 0:
                    state++;
                    break;
                case 1:
                    state++;
                    break;
                case 2:
                    if(s.charAt(i) == '1'){
                        state = 3;
                    }else{
                        state = 0;
                    }
                    break;
            }
            i++;
        }
        return state == 3;
    }
}
