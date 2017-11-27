//Найти произведение не равных 0 эл стоящих за макс.эл.

import java.util.Random;

public class Task_3B {
    public static void main(String[] args) {
        Random r = new Random();
        int n = 10,
                p = 1,
                maxi,
                max;
        int[] a = new int[n];

        for(int i = 0; i < n; i++) {
            a[i] = r.nextInt(50);
            System.out.print(a[i] + " ");
        }
        System.out.println();

        max = a[0];
        maxi = 0;
        for (int i = 1; i < n; i++) {
            if(a[i] > max) {
                max = a[i];
                maxi = i;
            }
        }
        for (int i = maxi; i < n; i++) {
            p *= a[i];
        }

        System.out.println(p);
        System.out.println(max);
    }
}
