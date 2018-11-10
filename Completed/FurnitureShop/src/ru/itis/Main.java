package ru.itis;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	    Shop shop = new Shop();
        Scanner in = new Scanner(System.in);
        String
                FurnitureName = in.nextLine(),
                Material = in.nextLine();
        double
                Amount = in.nextDouble(),
                Density = in.nextDouble();


        shop.buyChair(FurnitureName, Amount, Material, Density);

    }

}
