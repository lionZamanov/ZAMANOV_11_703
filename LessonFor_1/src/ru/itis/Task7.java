package ru.itis;

public class Task7 {
    public static void main(String[] args){
        double pi = 3.1415926;
        double R = 4/3;
        double e = 0.0001;
        int i = 2;

        while(Math.abs(R - pi/2) > e){
            R *= 4*i*(double)i/3 ;
            i++;
        }
        System.out.println(i);
    }
}
