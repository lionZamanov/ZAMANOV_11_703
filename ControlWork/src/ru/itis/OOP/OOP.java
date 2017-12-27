package ru.itis.OOP;

public class OOP {
    public static void main(String[] args) {
        Queen queen = new Queen("black", 2,5);
        Rook rook = new Rook("white", 4,7);
        Bishop bishop = new Bishop("white", 7,2);
        int
            counter = 0;
        int[][] field = new int[8][8];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if(!queen.Move(i,j) && !rook.Move(i,j) && !bishop.Move(i,j)){
                    counter++;
                }
            }
        }
        System.out.println(counter);
    }

}
