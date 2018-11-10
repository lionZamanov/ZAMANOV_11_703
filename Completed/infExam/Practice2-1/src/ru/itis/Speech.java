package ru.itis;

public class Speech implements SpeechBehavior {
    @Override
    public void say() {
        System.out.println("I can say hi");
    }
}
