package ru.itis.OOP;

public class Bishop extends Figure{

    public Bishop(String color, int positionX, int positionY){
        super(color,positionX,positionY);
    }
    public boolean Move(int positionX, int positionY){
        if(positionX <=7 && positionY <= 7){
            if(Math.abs(positionY - this.positionY) == Math.abs(this.positionX - positionX)){
                this.positionX = positionX;
                this.positionY = positionY;
            }

        }
        return false;
    }
}
