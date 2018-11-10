package ru.itis;

public class Shop {
    public static final int ORDERS_CAPACITY = 1000;
    public double[] OrderWeight = new double[ORDERS_CAPACITY];
    public int size = 0;
    public double TruckCarryingCapacity = 100;
    public double Truck1CarryingCapacity = 50;

    public void buyChair(String FurnitureName, double Amount, String Material, double Density){
        Furniture furniture = new Chair(FurnitureName, Amount, Material, Density);
        OrderWeight[size] = furniture.CalculateMass();
        size++;
    }

    public boolean checkTransportposibility(){

    }

}
