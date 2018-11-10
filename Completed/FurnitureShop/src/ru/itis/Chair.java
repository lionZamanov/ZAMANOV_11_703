package ru.itis;

public class Chair extends Furniture{

    public Chair(String FurnitureName, double Amount, String Material, double Density){
        super(FurnitureName, Amount, Material, Density);
    }

    public double CalculateMass(){
        return Amount * Density;
    }
}
