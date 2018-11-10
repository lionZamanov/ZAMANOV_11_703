package ru.itis;

public class Main {

    public static void main(String[] args) {
        Snake snake = new Snake();
        snake.move();

        Snake snake1 = new Snake();

        Animal animal = new FlyDecorator(snake);

        animal.fly();
    }
}
