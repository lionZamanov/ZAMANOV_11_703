import java.util.Random;
import java.util.Scanner;


public class Task_37 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Random r = new Random();
        int n = 7;
        int[][] matrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = r.nextInt(50)+1;
            }
        }
        showMatrix(matrix);
        System.out.println();
        for (int i = 0; i < n/2; i++) {
            for (int j = i+1; j < n-i-1; j++) {
                matrix[i][j] = 0;
            }
        }
        for (int i = n/2 + 1; i < n; i++) { // i = 3
            for (int j = i - 1; j > n - i - 1; j--) {
                matrix[i][j] = 0;
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
    }
}
