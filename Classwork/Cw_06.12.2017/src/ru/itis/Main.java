package ru.itis;
public class Main {


    public static void main(String[] args) {
        String words[] = {"бээ!", "б", "", "бэээээ!", "бэ", "!"};

        for (String word : words) {
           // System.out.println(isF(word));
            System.out.println(isGoodWordByMatrix(word));
        }
    }

    public static boolean isF(String t) {
        int i = 0;
        boolean flag = true;
        boolean is = false;
        int state = 0;
        char array[] = t.toCharArray();

        while (flag && i < array.length) {
            switch (state) {
                case 0:
                    if (array[i] != 'б') {
                        flag = false;
                    } else {
                        i++;
                        state = 1;
                    }
                    break;
                case 1:
                    if (array[i] != 'э') {
                        flag = false;
                    } else {
                        i++;
                        state = 2;
                    }
                    break;
                case 2:
                    if (array[i] == 'э') {
                        state = 2;
                        i++;
                    } else {
                        state = 3;
                    }
                    break;
                case 3:
                    if (array[i] == '!') {
                        is = true;
                    }
                    flag = false;
                    break;
            }
        }
        return is;
    }
    public static boolean isGoodWordByMatrix(String t) {
        boolean flag = true,
                result = false;
        int statement = 0;
        int[][] matrix = {
                {1,4,4,4},
                {4,2,4,4},
                {4,2,3,4},
                {4,4,4,4}
        };

        for (int i = 0; i < t.length(); i++) {
            if(t.charAt(i) == 'б')
                statement = matrix[statement][0];
            else if(t.charAt(i) == 'э')
                statement = matrix[statement][1];
            else if(t.charAt(i) == '!')
                statement = matrix[statement][2];
            else
                statement = matrix[statement][3];
        }
        return (statement == 3);
    }
}
