package ru.itis;

import java.util.Comparator;

public class StringComparator implements Comparator<String>{
    @Override
    public int compare(String s1, String s2) {
        return findMaxSubstr(s2) - findMaxSubstr(s1);
    }

    public int findMaxSubstr(String s1){
        int maxValueS1 = 0;
        for (int i = 0; i < s1.length(); i++) {
            int k = (int)'a';
            int counter = 0;
            for (int j = i; j < s1.length(); j++) {
                if(s1.charAt(j) == k){
                    counter++;
                    k++;
                }else{
                    break;
                }
            }
            if(counter > maxValueS1){
                maxValueS1 = counter;
            }
        }
        return maxValueS1;
    }
}
