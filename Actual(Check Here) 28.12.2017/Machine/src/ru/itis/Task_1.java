package ru.itis;

public class Task_1 {

    public static void main(String[] args) {
        System.out.println(isRational("-12412.124E+e231"));
    }
    public static boolean isRational(String s){
        boolean flag = true,
                result = false;
        int i = 0,
                state = 0;
        char array[] = s.toCharArray();

        while(flag && i < array.length){
            switch (state){
                case 0:
                    if(array[i] != '+' && array[i] != '-'){
                        flag = false;
                    }else{
                        i++;
                        state++;
                    }
                    break;
                case 1:
                    if(!Character.isDigit(array[i])){
                        state++;
                    }else{
                        i++;
                    }
                    break;
                case 2:
                    if(array[i] != '.'){
                        flag = false;
                    }else{
                        state++;
                        i++;
                    }
                    break;
                case 3:
                    if(!Character.isDigit(array[i])){
                        state++;
                    }else{
                        i++;
                    }
                    break;
                case 4:
                    if(Character.toLowerCase(array[i]) != 'e'){
                        flag = false;
                    }else{
                        i++;
                        state++;
                    }
                    break;
                case 5:
                    if(array[i] != '+' && array[i] != '-'){
                        flag = false;
                    }else{
                        i++;
                        state++;
                    }
                    break;
                case 6:
                    if(!Character.isDigit(array[i])){
                        state++;
                    }else{
                        result = true;
                    }
                    flag = false;

                    break;
            }
        }
        return result;
    }
}
