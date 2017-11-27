import java.util.Random;

public class One {

    public static void main(String[] args) {
	// Единицы выше побочной диагонали
        Random r = new Random();
        int
                n = r.nextInt(10) + 1,
                c = n - 1;
        int[][] a = new int[n][n];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                a[i][j] = r.nextInt(20);
            }
        }
        showMatrix(a);
        for (int i = 0; i < a.length; i++) {
            for (int k = 0; k < a.length - i - 1; k++) {
                a[i][k] = 1;
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
