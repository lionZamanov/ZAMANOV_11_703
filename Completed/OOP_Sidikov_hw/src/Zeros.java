import java.util.Random;//+-

public class Zeros {

    public static void main(String[] args) {
        // Нули ниже главной диагонали
        Random r = new Random();
        int
                n = r.nextInt(10),
                c = 0;
        int[][] a = new int[n][n];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                a[i][j] = r.nextInt(20);
            }
        }
        showMatrix(a);
        for (int i = 1; i < a.length; i++) {
            for (int k = 0; k < i; k++) {
                a[i][k] = 0;
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
