// Сортировка массива методом локальных экстремумов
import java.util.*;//-
public class Local_extremes_max {
    public static void main(String[] args) {
        Random r = new Random();
        int n = 10,
                max,
                t = 0;
        int[] a = new int[n];

        for(int i = 0; i < n; i++){
            a[i] = r.nextInt(40);
            System.out.print(a[i] + " ");
        }
        max = a[0];
        System.out.println();
        for (int i = n - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if(a[j] > max){   //тоже вариант "пузырька"
                    max = a[j];
                }
            }
            t = a[i];
            a[i] = max;
            max = t;
        }
        for(int i = 0; i < n; i++){
            System.out.print(a[i] + " ");
        }
    }
}  //Какую-то ерунду считает
