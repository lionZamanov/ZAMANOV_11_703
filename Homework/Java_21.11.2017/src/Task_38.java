import java.util.Random;
import java.util.Scanner;


public class Task_38 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Random r = new Random();
        int n = 7,
                K;
        int[][] matrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = r.nextInt(50)+1;
            }
        }
       /* showMatrix(matrix, n);
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                for (int k = i; k < n - 1; k++) {
                    K = NOK(matrix[i][k],matrix[i + 1][k]);
                }
            }
        }
*/
        System.out.println(NOK(-8,9));
    }
    public static int NOK(int x, int y){
        int a = x;
        int b = y;
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
