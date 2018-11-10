package ru.itis;

import java.util.Random;
import java.io.*;

public class Data {
    public static void main(String[] args) {
        Random r = new Random();
        int arrayCount = r.nextInt(50) + 50;
        int arraySize;
        int[] array;
        for (int i = 0; i < arrayCount; i++) {
            arraySize = r.nextInt(9900) + 100;
            array = new int[arraySize];
            for (int j = 0; j < arraySize; j++) {
                array[j] = r.nextInt(Integer.MAX_VALUE);
            }
            dataInput(array,i);
        }
    }

    public static String arrayToString(int[] array){
        String result = "";
        for (int i = 0; i < array.length; i++) {
            result += array[i] + " ";
        }
        return result;
    }

    public static void dataInput(int[] array, int i){
        try (Writer writer = new BufferedWriter(new OutputStreamWriter(
                new FileOutputStream("dataInput/" + i + ".txt"), "utf-8"))) {
            writer.write(arrayToString(array));
        }catch (IOException ex) {
            System.out.println("Something went wrong");
        }
    }

    public static void dataOutput(int[] array, int i){
        try (Writer writer = new BufferedWriter(new OutputStreamWriter(
                new FileOutputStream("dataOutput/" + i + ".txt"), "utf-8"))) {
            writer.write(arrayToString(array));
        }catch (IOException ex) {
            System.out.println("Something went wrong");
        }
    }
}
