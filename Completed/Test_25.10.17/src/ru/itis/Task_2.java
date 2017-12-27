package ru.itis;
public class Task_2 {

    public static void main(String[] args) {
        int
                i = 0,
                n = 100;
        double
                a = -3.14,
                b = 3.14,
                h,
                s = 0,
                segment;
        h = (b - a)/n;
        while(i < n){
            segment = Math.sqrt(h*h - (Math.sin(a + (i+1)*h) - Math.sin(a + i*h))*(Math.sin(a + (i+1)*h) - Math.sin(a + i*h)));
            s += segment;
            i++;
        }
        System.out.println(s);
    }
}
