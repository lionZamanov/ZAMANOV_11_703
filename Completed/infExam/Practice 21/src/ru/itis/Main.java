package ru.itis;

import java.util.ArrayList;
import java.util.Collections;

public class Main {

    public static void main(String[] args) {
        ArrayList<String> test = new ArrayList<>();


        test.add("zabcd");
        test.add("ababababba");
        test.add("abcdef");
        test.add("gnesrgnvm");

        Collections.sort(test, new StringComparator());
        System.out.println(test);
    }
}
