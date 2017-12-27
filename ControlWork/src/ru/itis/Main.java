package ru.itis;

import java.util.Random;

public class Main {

    public static void main(String[] args) {
        int
            n = 4,
            min,
            max_m,
            min_j,
            min_i,
            max_m_i,
            max_m_j;
        int[][] matrix = new int[7][2];

        //Заполним и выведем матрицу
        matrixFill(matrix);

        //Найдем первый максимальный из минимальных
        min = matrix[0][0];
        min_i = 0;
        min_j = 0;
        for (int i = 1; i < matrix[0].length; i++) {
            if(matrix[0][i] < min){
                min = matrix[0][i];
                min_i = 0;
                min_j = i;
            }
        }
        max_m = min;
        max_m_i = min_i;
        max_m_j = min_j;

        //Найдем максимальный элемент
        for (int i = 1; i < matrix.length; i++) {
            min = matrix[i][0];
            min_i = i;
            min_j = 0;
            for (int j = 0; j < matrix[i].length; j++) {
                if(matrix[i][j] < min){
                    min = matrix[i][j];
                    min_i = i;
                    min_j = j;
                }
            }
            if(min > max_m){
                max_m = min;
                max_m_i = min_i;
                max_m_j = min_j;
            }
        }
        System.out.println();

        //Вывод строки, содержащей максимальный из минимальных
        showLine(max_m_i,matrix);
        System.out.println(matrix[max_m_i][max_m_j] + " i = " + max_m_i + " j = " + max_m_j);
    }
    public static void showLine(int i, int[][] matrix){
        for (int j = 0; j < matrix[i].length; j++) {
            System.out.print(matrix[i][j] + " ");
        }
        System.out.println();
    }
    public static void matrixFill(int[][] matrix){
        Random r = new Random();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = r.nextInt(25);
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
