package ru.itis;
import java.util.Scanner;


public class Task12B {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int
                i = 1,
                p = -1,
                x = in.nextInt();
        double
                t = 1,
                s = t,
                e = 0.0001;
        while(Math.abs(t) > e) {
            t *= p*x*(double)x/((2*i-1)*2*i); //Логика нарушена. Непонятно, какая задача решается, формула ни для чего не подходит
            s += t;
            p = -p;
            i++;
        }
        System.out.println(s);
    }
}
