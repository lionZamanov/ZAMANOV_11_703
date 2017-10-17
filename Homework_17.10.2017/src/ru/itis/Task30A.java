package ru.itis;


public class Task30A {
    public static void main(String[] args) {
        double
                x0,
                x1,
                a = 1.0,
                e = 0.0001,
                b = 1.1;

        if (f(a)*f2(a) > 0) x0 = a; else x0 = b;


        x1 = x0 - f(x0)/f2(x0);
        while(Math.abs(x0 - x1) > e){
            x0 = x1;
            x1 = x0 - f(x0)/f2(x0);
        }

        System.out.println(x1);

    }
    public static double f(double x){
        return Math.pow(x,5) - x - 0.002;
    }
    public static double f2(double x){
        return 5*Math.pow(x,4) - 1;
    }
}
