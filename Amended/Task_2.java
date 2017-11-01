// Найти сумму м/д наиб. наим. числами
import java.util.*;

public class Task_2 {
    public static void main(String[] args) {
        Random r = new Random();
        int n = 10,
                t,
                s = 0,
                max,
                min,
                maxi,
                mini;
        int[] a = new int[n];

        for(int i = 0; i < n; i++) {
            a[i] = r.nextInt(50);
            System.out.print(a[i] + " ");
        }
        System.out.println();
        maxi = 0;
        mini = 1;
        max = a[0];
        min = a[1];
        if(min > max){
            t = max;
            max = min;
            min = t;
            maxi = 1;
            mini = 0;
        }
        for (int i = 0; i < n; i++) {
            if(a[i] > max){
                max = a[i];
                maxi = i;
            }
            if(a[i] < min){
                min = a[i];
                mini = i;
            }
        }
        if(mini > maxi){
            for (int i = maxi+1; i < mini; i++) {
                s += a[i];
            }
        }else{
            for (int i = min+1; i < maxi; i++) {
                s += a[i];
            }
        }
        System.out.println(s);

    }
}
