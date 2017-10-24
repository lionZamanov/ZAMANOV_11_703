package ru.itis;

public class Task5B {
    public static void main(String[] args){
        double e = 0.0001;
        double s = 0;
        int p = 1;
        int i = 1;
        double prev = 1;
        while(Math.abs(prev) > e){
            s += p*prev;
            i++;
            prev = 1.0/((2*i+1)*(2*i+1));
            p = -p;
        }

        System.out.println(i);
        System.out.println(prev);
    }
}
