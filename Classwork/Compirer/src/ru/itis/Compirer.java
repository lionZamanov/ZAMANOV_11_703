package ru.itis;

import jdk.nashorn.internal.runtime.regexp.joni.exception.SyntaxException;


public class Compirer {

    public void analyze(String input){
        char[] charArray = input.toCharArray();
        int count = 0;
        int state = 0;

        while (count < charArray.length) {
            switch (state) {
                case 0:
                    if (Character.isLetter(charArray[count])) {
                        state = 1;
                    } else throw new SyntaxException("Syntax broken");
                    break;
                case 1:
                    if (Character.isDigit(charArray[count])) {
                        break;
                    } else if (charArray[count] == ':') {
                        state = 2;
                    } else if (charArray[count] == '+' || charArray[count] == '-' || charArray[count] == '*') {
                        state = 0;
                    } else if (charArray[count] == ';') {
                        state = 0;
                    } else throw new SyntaxException("Syntax broken");
                    break;
                case 2:
                    if (charArray[count] == '=') {
                        state = 3;
                    } else throw new SyntaxException("Syntax broken");
                    break;
                case 3:
                    if (Character.isDigit(charArray[count])) {
                        break;
                    } else if (charArray[count] == ';') {
                        state = 0;
                    } else if (Character.isLetter(charArray[count])) {
                        state = 1;
                    } else throw new SyntaxException("Syntax broken");
                    break;
            }
            count++;
        }
    }
    public List<Var> process(String input){
        String[] inputArray = input.split(";");
        ArrayList<Var> arrayList = new ArrayList<>();
        ArrayList<Var> arrayListWithValue = new ArrayList<>();

        for (int i = 0; i < inputArray.length; i++) {
            arrayList.add(new Var(inputArray[i]));
        }

        for (int i = 0; i < inputArray.length; i++) {
            Var var = arrayList.get(i);
            var.findValue(arrayList);
            arrayListWithValue.add(var);
        }
        return arrayListWithValue;
    }
}
