import java.util.Random;
import java.util.Scanner;


public class Task_38 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Random r = new Random();
        int n = 3;

        int[][] matrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = in.nextInt();
            }
        }
        showMatrix(matrix);
        showMatrix(Gauss(matrix, n));
    }

    public static int[][] Gauss(int[][] matrix,int n){
        int a;
        int b;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                a = matrix[i][i];
                b = matrix[j][i];
                for (int k = i; k < n; k++) {
                    matrix[j][k] = matrix[j][k]*a - matrix[i][k]*b;
                }
            }
        }
        return matrix;
    }
    public static int NOK(int x, int y){
        int a = Math.abs(x);
        int b = Math.abs(y);
        while (a != b) {
            if(a > b) {
                a -=b;
            }else{
                b -= a;
            }
        }
        return x*y/b;
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
