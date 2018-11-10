package ru.itis;

public class SayDecorator extends Decorator {
    public Animal animal;
    public SayDecorator(Animal animal) {
        this.animal = animal;
    }

    public void say(){
        System.out.println("I can say");
    }

    @Override
    public void move() {
        animal.move();
    }
}
