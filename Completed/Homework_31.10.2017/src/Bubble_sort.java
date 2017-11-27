import java.util.*;

public class Bubble_sort {
    public static void main(String[] args) {
        Random r = new Random();
        int
            n = 10,
                t;
        int[]
            a = new int[n];
        boolean flag = false;

        for (int i = 0; i < n; i++) {
            a[i] = r.nextInt(50);
            System.out.print(a[i] + " ");
        }
        System.out.println();
        while(!flag){
            flag = true;
            for (int j = 0; j < n - 1; j++) {
                if(a[j] > a[j+1]){
                    t = a[j];
                    a[j] = a[j+1];
                    a[j+1] = t;
                    flag = false;
                }
            }
        }
        System.out.println(Arrays.toString(a));
    }
}
