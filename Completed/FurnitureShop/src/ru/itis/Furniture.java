package ru.itis;

public abstract class Furniture {
    String FurnitureName;
    double Amount;
    String Material;
    double Density;

    public Furniture(String FurnitureName, double Amount, String Material, double Density){
        this.FurnitureName = FurnitureName;
        this.Amount = Amount;
        this.Material = Material;
        this.Density = Density;
    }
    public abstract double CalculateMass();
}
