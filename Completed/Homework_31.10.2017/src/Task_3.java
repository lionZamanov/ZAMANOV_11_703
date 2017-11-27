//Найти произведение не равных 0 эл стоящих за макс.эл.
import java.util.*;  //-

public class Task_3 {
    public static void main(String[] args) {
        Random r = new Random();
        int n = 10,
                p = 1,
                max;
        int[] a = new int[n];

        for(int i = 0; i < n; i++) {
            a[i] = r.nextInt(50);
            System.out.print(a[i] + " ");
        }
        System.out.println();

        max = a[0];
        for (int i = 1; i < n; i++) {
            if(a[i] > max){
                max = a[i];
                p = 1;
            }else if(a[i] != 0){
                p *= a[i];  //вы же еще не нашли максимальный
            }
        }

        System.out.println(p);
        System.out.println(max);
    }
}
