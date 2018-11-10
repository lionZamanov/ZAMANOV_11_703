package ru.itis;

import java.util.ArrayList;
import java.util.Collections;

public class Main {

    public static void main(String[] args) {
        ArrayList<Integer> test = new ArrayList<>();


        test.add(555555);//6
        test.add(123);//1
        test.add(121212);//0
        test.add(126164745);//1
        test.add(1111111);//7
        test.add(22222);//5
        test.add(222221);//4
        Collections.sort(test, new NumberComparator());
        System.out.println(test);
    }
}
