import java.util.Random;
import java.util.Scanner;
public class QuantifierE {

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
            a[i] = r.nextInt(10);
            System.out.print(a[i] + " ");
        }
        i = 0;
        System.out.println();
        c = in.nextInt();

        while(i < n && !f) {
            if(a[i] == c){
                f = true;
            }
            i++;
        }

        if(f) System.out.println("Y"); else System.out.println("N");
    }
}
