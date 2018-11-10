package ru.itis.OOP;

public class Main {
    public static void main(String[] args) {
        Money pocket1 = new Money(14,-70);
        Money pocket2 = new Money(0,90);
        Money pocket3 = new Money(0,90);
        Money pocket4 = new Money(15,70);
        System.out.println(pocket1);
        System.out.println(pocket2);
        System.out.println(pocket1.equals(pocket4));

        pocket1 = pocket1.subtraction(pocket2);
        System.out.println(pocket1);

        pocket2 = pocket2.sum(pocket3);
        System.out.println(pocket2);

        pocket2 = pocket2.multiplication(10);
        System.out.println(pocket2);


    }
}
