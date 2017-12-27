package ru.itis.OOP;

public class Queen extends Figure{

    public Queen(String color, int positionX, int positionY){
        super(color,positionX,positionY);
    }

    public boolean Move(int positionX, int positionY){
        if(positionX <= 7 && positionY <= 7){
            /*if(positionX == this.positionX && positionY == this.positionY){
                System.out.println("Вы ввели координату, совпадающую с текущей координатой фигуры");
            }else{*/
                if(positionX == this.positionX){
                    //this.positionY = positionY;
                    return true;
                }else if(positionY == this.positionY){
                    //this.positionX = positionX;
                    return true;
                }else if(Math.abs(positionY - this.positionY) == Math.abs(this.positionX - positionX)){
                    //this.positionX = positionX;
                    //this.positionY = positionY;
                    return true;
                }
            }
        return false;

    }/*else{
            System.out.println("Вы ввели некорректную координату");
        }*/
}

