package ru.itis;
import java.util.Scanner;
public class Task22B {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k;
        double sum = 0;
        double x = in.nextInt();
        double an = x;
        int fact = 1;
        int p = 1;
        for(k = 0; k <= n; k++){
            if(k != 0) fact *= k*2*(2*k - 1);
            sum += p*an/(fact*(4*k + 1));
            p = -p;
            an *=x*x*x*x;
        }
        System.out.println(sum);
    }
}
/*
    k = 0
    fact = 1  fac = 1

    k = 1
    fact = 2 fac = 2

    k = 2
    fact = 24 fac = 24

    k = 3
    fact = 720 fac = 144*5 = 720

    k = 4
    fact = 40 320  fac = 1440*


 */