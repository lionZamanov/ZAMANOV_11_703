package ru.itis;

public class FlyDecorator extends Decorator{
    public Animal animal;
    public FlyDecorator(Animal animal) {
        this.animal = animal;
    }

    public void fly() {
        System.out.println("I can fly");
    }

    @Override
    public void move() {
        animal.move();
    }
}
