package ru.itis.OOP;

public class Rook extends Figure{

    public Rook(String color, int positionX, int positionY){
        super(color,positionX,positionY);
    }
    public boolean Move(int positionX, int positionY){
        if(positionX <=7 && positionY <= 7) {
            if (positionX == this.positionX) {
                //this.positionY = positionY;
                return true;
            } else if (positionY == this.positionY) {
                //this.positionX = positionX;
                return true;
            }
        }
        return false;
    }
}
