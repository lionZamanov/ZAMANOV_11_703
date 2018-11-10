package ru.itis;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        Map<Character,Integer> map = new HashMap<>();
//        Scanner scanner = new Scanner(new File("input.txt"));
//        while (scanner.hasNext()){
        FileInputStream fis = new FileInputStream("input.txt");
        int c = fis.read();
        int prev;
        while(c != -1){
            if(c >='A' && c <= 90) {
                c += 32;
            }
            if(c >= 97 && c <= 122) {
                if (map.containsKey((char) c)) {
                    prev = map.get((char) c);
                    map.put((char) c, prev + 1);
                } else {
                    map.put((char) c, 1);
                }
            }
            c = fis.read();
        }
        System.out.println(map);
    }
}
