package ru.itis;

public class Main {

    public static void main(String[] args) {
        Snake snake = new Snake();

        if(snake.getExp(200) > 100){
            decorator = new FlyDecorator(snake);
        }

        decorator.fly();
    }
}
