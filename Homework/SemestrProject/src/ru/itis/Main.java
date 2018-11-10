package ru.itis;

import java.io.File;

public class Main {

    public static void main(String[] args) {
        File dir = new File("src/ru/itis");
        int i = 1;
        File[] arrFiles = dir.listFiles();
//        List<File> lst = Arrays.asList(arrFiles);

        for (File file : arrFiles) {

        }
    }
}
