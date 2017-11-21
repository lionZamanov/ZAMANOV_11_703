import java.util.Random;
import java.util.Scanner;


public class Task_38 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Random r = new Random();
        int n = 3,
                k1,
                k2,
                K;
        int[][] matrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = r.nextInt(10)+1;
            }
        }
        showMatrix(matrix, n);
        System.out.println();
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                K = NOK(matrix[i][i],matrix[j][i]);
                k1 = K/matrix[j][i];
                k2 = K/matrix[i][i];
                for (int k = i; k < n; k++) {
                    matrix[j][k] = matrix[j][k]* - matrix[i][k]*;
                }
            }
        }
        showMatrix(matrix, n);
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
    public static void showMatrix(int[][] matrix, int n){
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
