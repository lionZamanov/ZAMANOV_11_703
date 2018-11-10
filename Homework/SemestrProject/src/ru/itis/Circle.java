package ru.itis;

public class Circle {
    public int radius;
    public String color;
    public int coordinates;

    public Circle() {
        this(0, "red", 0);
    }

    public Circle(int radius, String color, int coordinates) {

        this.radius = radius;
        this.color = color;
        this.coordinates = coordinates;
    }
}
