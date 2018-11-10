package ru.itis;

public class SayDecorator extends Decorator {
    public SayDecorator(InterfaceComponent c) {
        super(c);
    }

    public void say(){
        System.out.println("I can say");
    }
}
