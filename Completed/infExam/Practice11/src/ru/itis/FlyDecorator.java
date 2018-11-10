package ru.itis;

public class FlyDecorator extends Decorator{
    public FlyDecorator(InterfaceComponent c) {
        super(c);
    }

    public void fly() {
        System.out.println("I can fly");
    }
}
