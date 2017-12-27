import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Random random = new Random();
        int min;
        int
                n = in.nextInt(),
                m = in.nextInt();

        int[][] matrix = new int[n][m];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = random.nextInt(20);
            }
        }
        for (int i = 0; i < m; i++) {
            min = matrix[0][i];
            for (int j = 0; j < n; j++) {
                if(matrix[j][i] < min){
                    min = matrix[j][i];
                }
            }
            System.out.println(min);
        }
        showMatrix(matrix);
        System.out.println(Arrays.toString(findMins(matrix, m)));

    }
    public static void showMatrix(int[][] matrix){
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static int[] findMins(int matrix[][],int m){
        int[] min = new int[m];
        for (int i = 0; i < min.length; i++) {
            min[i] = matrix[0][i];
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if(matrix[i][j] < min[j]){
                    min[j] = matrix[i][j];
                }
            }
        }
        return min;

    }
}
