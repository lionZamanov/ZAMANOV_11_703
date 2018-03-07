package ru.itis;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
	// write your code here
        BigInteger first = new BigInteger("5315315113897865432586754375367643689657865467899867543536786924367534");
        BigInteger second = new BigInteger("164571512512512342787652607953153151138978654325867543753676436896578654678998675435367869243675347685746424723621595135321526");
        System.out.println(first.sum(second).getNumber());

    }




}
