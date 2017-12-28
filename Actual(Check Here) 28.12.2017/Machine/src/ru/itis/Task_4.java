package ru.itis;

import java.util.Scanner;

public class Task_4 {
    public static void main(String[] args) {
        String s,
                fin = "";
        Scanner in = new Scanner(System.in);

        s = in.nextLine();
            System.out.println(f(s));
    }

    public static boolean f(String s) {
        boolean flag = true,
                result = false;
        int i = 0,
                counter = 0,
                state = 0;

        while (i < s.length()) {
            switch (state) {
                case 0:
                if (s.charAt(i) == '1') {
                        state = 1;
                    }
                    break;
                case 1:
                    if (s.charAt(i) == '0') {
                        state = 2;
                    } else {
                        state = 1;
                    }
                    break;
                case 2:
                    if (s.charAt(i) == '0') {
                        state = 1;
                    }else {
                        state = 3;
                    }
                    break;
                case 2:
                    if (s.charAt(i) == '1') {
                        state = 1;
                    }else {
                        state = 3;
                    }
                    break;
                case 2:
                    if (s.charAt(i) == '0') {
                        state = 1;
                    }else {
                        state = 3;
                    }
                    break;
            }
            i++;
        }
        return result;
    }
}
