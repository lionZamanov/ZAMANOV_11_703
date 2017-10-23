package ru.itis;//что за задача?
import java.util.Scanner;
public class Tasks {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int
            a = in.nextInt(),
                c,
                p = 1,
                i = 0,
                m = 0,
                e = 1,
                s = 0;

        while (a > 0){
            c = a % 10;
            s += p*c; //сумма цифр
            p = -p;
            a /= 10;
            i++; // количество цифр
            if(c % 2 != 0){ // Новое число M
                m += e*c;
                e *= 10;
            }
        }
        System.out.println(s);
        System.out.println(i);
        System.out.println(m);
    }
}
