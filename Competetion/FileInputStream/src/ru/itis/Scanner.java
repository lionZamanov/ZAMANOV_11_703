package ru.itis;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class Scanner {
    InputStream inputStream;

    public Scanner(String string) {
        try {
            inputStream = new FileInputStream(string);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    public int nextInt() {
        try {
            String str = "";
            int byteFromInput = inputStream.read();
            boolean flag = false;
            while (byteFromInput != ' ' && byteFromInput != -1) {
                if (byteFromInput == '-') {
                    flag = true;
                } else {
                    str += Character.getNumericValue(byteFromInput);
                }
                byteFromInput = inputStream.read();

            }
            return parseInt(str, flag);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return -1;
    }

    public int parseInt(String str, boolean flag) {
        int result = 0;
        int k = 1;
        for (int i = str.length() - 1; i > -1; i--) {
            result += Character.getNumericValue(str.charAt(i)) * k;
            k *= 10;
        }
        if (flag) {
            return -result;
        }
        return result;
    }
}
