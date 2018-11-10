package ru.itis;

public class FlyBehavior implements MoveBehavior{
    @Override
    public void move() {
        System.out.println("I'am flying");
    }
}
