// Найти кол-во чисел м/д наиб. наим. числами
import java.util.*;

public class Task_2 {
    public static void main(String[] args) {
        Random r = new Random();
        int n = 10,
                max,
                maxi = 0,
                mini = 1,
                min;
        int[] a = new int[n];

        for(int i = 0; i < n; i++) {
            a[i] = r.nextInt(50);
            System.out.print(a[i] + " ");
        }
        System.out.println();

        max = a[0];
        min = a[1];
        if(max < min){ //Смена значений
            max -= min;
            min += max;
            max = min - max;
        }

        for (int i = 2; i < n; i++) {
            if(a[i] > max){
                max = a[i];
                maxi = i;
            }else if(a[i] < min){
                min = a[i];
                mini = i;
            }
        }

        System.out.println(max);
        System.out.println(min);
        System.out.println(Math.abs(mini - maxi - 1));
    }
}
