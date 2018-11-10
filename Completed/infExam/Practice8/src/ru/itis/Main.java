package ru.itis;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        try {
            Scanner scanner = new Scanner(new File("input.txt"));
            int i = scanner.nextInt();
            int prev;
            int k = 1;
            while (scanner.hasNext()) {
                if (hashMap.containsKey(i)) {
                    prev = hashMap.get(i);
                    hashMap.put(i, prev + 1);
                } else {
                    hashMap.put(i, 1);
                }
                i = scanner.nextInt();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        printValues(hashMap);
    }

    public static void printValues(Map<Integer, Integer> map) {
        for (Map.Entry<Integer, Integer> pair : map.entrySet()) {
            System.out.println(pair.getKey() + ": " + pair.getValue() + " раз");
        }
    }
}
