package ru.itis;

public class Main {

    public static void main(String[] args) {
        ZhegalkinPolinom polinom = new ZhegalkinPolinom("X2&-X3+X1&X2&X3");
        ZhegalkinPolinom polinom1 = new ZhegalkinPolinom("X1&X2&X3+X2&X3");
        byte[] a = {1,1,1,0};
        int i = 1;
        System.out.println(polinom);
        System.out.println(polinom.value(a));
        System.out.println(polinom1.polinomWith((byte)2));
        polinom.sortByLength();
        System.out.println(polinom);
        System.out.println(polinom.sum(polinom1));
        polinom.sortByLength();
        System.out.println(polinom);

    }
}
