//3.	Проверить, имеются ли в матрице 2 совпадающие строки.
package ru.itis;

import java.util.Random;

public class Task_3 {

    public static void main(String[] args) {
        Random r = new Random();
        int[][] matrix = {
                {1,2,3},
                {1,2,3},
                {2,5,1}
        };
        int position = 0;
        int sum = 0;
        boolean flag = true,
                exist = false;

        showMatrix(matrix);
        for (int line = 0; line < matrix.length && !exist; line++) {
            for (int j = line + 1; j < matrix.length && !exist; j++) {
                for (int k = 0; k < matrix.length && flag; k++) {
                    if(matrix[line][k] != matrix[j][k]){
                        flag = false;
                    }
                }
                if(flag) exist = true;
                flag = true;
            }
        }
        System.out.println(exist);

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
