package ru.itis;

import java.util.Comparator;

public class NumberComparator implements Comparator<Integer>{

    @Override
    public int compare(Integer i1, Integer i2) {
        int i1Difference = 0;
        while(i1 > 0){
            if(i1 % 2 == 0){
                i1Difference++;
            }else{
                i1Difference--;
            }
            i1 /= 10;
        }
        int i2Difference = 0;
        while(i2 > 0){
            if(i2 % 2 == 0){
                i2Difference++;
            }else{
                i2Difference--;
            }
            i2 /= 10;
        }
        return Math.abs(i1Difference) - Math.abs(i2Difference);
    }
}
