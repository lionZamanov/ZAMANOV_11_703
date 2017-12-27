import java.util.Random;
import java.util.Scanner;

public class Task223 {

    public static void main(String[] args) {
        // write your code here
        Scanner in = new Scanner(System.in);
        Random r = new Random();
        int
                k = 1,
                i = 0,
                c,
                n = 4;
        boolean
            fr = true,
                fu = true;
        int[] a = {1,2,3,4,5};

        for (i = 0; i < n; i++) {
            System.out.print(a[i] + " ");
        }
        i = 0;
        System.out.println();

        for (int j = 0; j < n-1; j++) {
            if(a[j] <= a[j+1])
                fu = false;
            if(a[j] >= a[j+1])
                fr = false;
        }
        if(fu){
            System.out.println("Убывает");
        }else if(fr){
            System.out.println("Возрастает");
        }else{
            System.out.println("Не упорядочен");
        }

    }
}
