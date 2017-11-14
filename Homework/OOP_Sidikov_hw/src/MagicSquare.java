import java.util.Random;
import java.util.Scanner;

public class MagicSquare {

    public static void main(String[] args) {
	// Магический квадрат
        Scanner in = new Scanner(System.in);
        int
                n = 3,
                s = 0,
                sum = 0,
                diagonal1 = 0,
                diagonal2 = 0,
                c;
        boolean flagLine = true,
                flagColumn = true;
        int[][] a = new int[n][n];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                a[i][j] = in.nextInt();
            }
        }
        for (int i = 0; i < a[0].length; i++) {
            sum += a[0][i];
        }

        for (int i = 0; i < a.length && flagLine; i++) {
            for (int k = 0; k < a[i].length; k++) {
                s += a[i][k];
            }
            if(s != sum) flagLine = false;
            s = 0;
            diagonal1 += a[i][i];
            diagonal2 += a[i][a[i].length - i - 1];
        }
        for (int i = 0; i < a.length && flagColumn; i++) {
            for (int k = 0; k < a[i].length; k++) {
                s += a[k][i];
            }
            if(s != sum) flagColumn = false;
            s = 0;
        }
        System.out.println(flagColumn && flagLine && diagonal1 == sum && diagonal2 == sum);
    }
          //присутствует некоторая избыточность.
}
