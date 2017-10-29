// Сортировка массива методом локальных экстремумов

import java.util.Random;

public class Local_extremes_min {
    public static void main(String[] args) {
        Random r = new Random();
        int n = 10,
                t = 0;
        int[] a = new int[n];

        for(int i = 0; i < n; i++){
            a[i] = r.nextInt(40);
            System.out.print(a[i] + " ");
        }
        System.out.println();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if(a[j] < a[i]){
                    t = a[j];
                    a[j] = a[i];
                    a[i] = t;
                }
            }
        }
        for(int i = 0; i < n; i++){
            System.out.print(a[i] + " ");
        }
    }
}
