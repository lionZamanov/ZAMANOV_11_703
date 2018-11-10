package ru.itis;


public class Main {

    public static void main(String[] args) {
        Compirer compirer = new Compirer();
        compirer.analyze("x1:=5;x2:=7;x3:=x1+x2;");
        List list = compirer.process("x1:=5;x2:=6;x3:=x1+x2;");

        int i = 1;
    }
}
