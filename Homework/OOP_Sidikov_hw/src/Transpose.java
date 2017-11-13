import java.util.Random;

public class Transpose {

    public static void main(String[] args) {
	// Транспонирвоание
        Random r = new Random();
        int
                n = r.nextInt(3) + 3,
                c;
        int[][] a = new int[n][n];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                a[i][j] = r.nextInt(20);
            }
        }
        showMatrix(a);
        for (int i = 0; i < a.length; i++) {
            for (int k = i + 1; k < a[i].length; k++) {
                c = a[i][k];
                a[i][k] = a[k][i];
                a[k][i] = c;
            }
        }
        System.out.println();
        showMatrix(a);
    }
    public static void showMatrix(int[][] a){
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
    }
}
