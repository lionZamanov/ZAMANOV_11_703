package ru.itis;

public class Array_1A {
    public static void main(String[] args) {
        int
                n = 5,
                s = 0;
        int []
                a = new int[n],
                b = new int[n];

        for(int i = 1; i < n; i++){
            a[i] = (int)Math.round(Math.random()*100);
            b[i] = (int)Math.round(Math.random()*100);
            s += a[i]*b[i];
        }
        System.out.println(s);
    }
}
