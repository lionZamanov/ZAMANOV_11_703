import java.util.Random;
import java.util.Scanner;


public class Task_38 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Random r = new Random();
        int n = 5,
                c;
        int[][] matrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = r.nextInt(10)+1;
            }
        }
        showMatrix(matrix);
        System.out.println();
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                c = matrix[i][i]*matrix[j][i] > 0 ? -1:1;
                for (int k = i; k < n; k++) {
                    matrix[j][k] = matrix[j][k]*matrix[i][i] + c*matrix[i][k]*matrix[j][i];
                }
            }
        }
        showMatrix(matrix);
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
    }
}
