package ru.itis.OOP;

public abstract class Figure {
    public String color;
    public int positionX;
    public int positionY;

    public Figure(String color, int positionX, int positionY){
        this.color = color;
        this.positionX = positionX;
        this.positionY = positionY;
    }
    public abstract boolean Move(int positionX, int positionY);
}
