import java.util.Random;

public class BubbleSort {

    public static void main(String[] args) {
	// bubble sort
        Random r = new Random();
        int
                n = r.nextInt(7),
                c;
        boolean
            flag = false;
        int[][] a = new int[r.nextInt(9)][r.nextInt(9)];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                a[i][j] = r.nextInt(20);
            }
        }
        showMatrix(a);
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                for (int k = 0; k < a[i].length - 1 && !flag; k++) {
                    if (a[i][k] > a[i][k + 1]) {
                        c = a[i][k];
                        a[i][k] = a[i][k + 1];
                        a[i][k + 1] = c;
                        flag = false;
                    }
                }
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
