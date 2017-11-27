//Дана матрица, элементы первого столбца которой  упорядочены по не возрастанию. Вставить в матрицу строку так, чтобы не нарушилась упорядоченность по первому столбцу.

package ru.itis;

public class Task_1 {

    public static void main(String[] args) {
        int[][] matrix = {
                {2,4,7,8},
                {4,54,234,34},
                {41,32},
                {}
        };
        int[] line = {3,43,132,14};
        int position = 0;

        for (int i = 0; i < matrix.length && position == 0; i++) {
            if(line[0] < matrix[0][i]){
                position = i;
            }
        }
        for (int i = matrix.length - 1; i > position; --i) {
            matrix[i] = matrix[i - 1];
        }
        matrix[position] = line;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
