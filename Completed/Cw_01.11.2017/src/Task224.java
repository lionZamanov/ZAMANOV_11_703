import java.util.Random;
import java.util.Scanner;

public class Task224 {

    public static void main(String[] args) {
        // write your code here
        Scanner in = new Scanner(System.in);
        Random r = new Random();
        int
                k = 1,
                i = 0,
                c,
                n = 10;
        boolean
            f = false;
        int[] a = new int[n];

        for (i = 0; i < n; i++) {
            a[i] = r.nextInt(50);
            System.out.print(a[i] + " ");
        }
        i = 0;
        System.out.println();

        for (int j = 0; j < n-1 && !f; j++) {
            for (int l = j+1; l < n; l++) {
                if(a[j] == a[l]){
                    f = true;
                }
            }
        }

        if(f) System.out.println("Y"); else System.out.println("N");
    }
}
