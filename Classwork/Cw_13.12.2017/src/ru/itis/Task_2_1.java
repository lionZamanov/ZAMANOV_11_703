package ru.itis;

public class Task_2_1 {
    public static void main(String[] args) {
        String words[] = {"100", "11", "", "100101", "00000", "1"};

        for (String word : words) {
            System.out.println(F(word));
        }
    }
    public static boolean F(String s){
        int i = 0;
        boolean flag = true;
        boolean is = false;
        int state = 0;
        char array[] = s.toCharArray();
        while(flag && i < array.length) {
            switch (state){
                case 0:
                    if(s.charAt(i) == '1'){
                        state = 1;
                    }
                    i++;
                    break;
                case 1:
                    if(s.charAt(i) == '0'){
                        state = 2;
                    }
                    i++;
                    break;
                case 2:
                    break;
            }
        }
        return is;
    }
}
