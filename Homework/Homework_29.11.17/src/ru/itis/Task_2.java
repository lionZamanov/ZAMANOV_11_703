package ru.itis;

import java.util.Random;

public class Task_2 {

    public static void main(String[] args) {
        Random r = new Random();
        int[][] matrix1 = new int[3][3];
        int[][] matrix2 = new int[3][3];
        int[][] matrix = new int[3][3];
        int position = 0;
        int sum = 0;
        for (int i = 0; i < matrix1.length; i++) {
            for (int j = 0; j < matrix1.length; j++) {
                matrix1[i][j] = r.nextInt(10);
                matrix2[i][j] = r.nextInt(10);
            }
        }
        showMatrix(matrix1);
        showMatrix(matrix2);
        for (int line = 0; line < matrix1.length; line++) {
            for (int j = 0; j < matrix2.length; j++) {
                for (int k = 0; k < matrix1.length; k++) {
                    matrix[line][j] += matrix1[line][k]*matrix2[k][j];
                }
            }
        }

        showMatrix(matrix);
    }
    public static void showMatrix(int[][] matrix){
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
