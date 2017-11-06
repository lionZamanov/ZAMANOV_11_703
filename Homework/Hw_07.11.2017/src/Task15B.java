import java.util.*;
public class Task15B {
    public static void main(String[] args) {
        int[] X = {1,2,5,4,5,7,7,12,12,12};
        int[] u = new int[10];
        int count = 0,
                j = 0;
        boolean flag = false;

        while(X[j] < X[j+1]) {
            j++;
        }
        j++;
        for (int i = j; i < X.length-1 ; i++) {
            if(X[i] <= X[i+1]){
                count++;
            }else{
                count++;
                u[count]++;
                count = 0;
            }
        }
        if(X[X.length-2]<X[X.length-1]){
            count++;
            u[count]++;
        }
        System.out.println(Arrays.toString(u));
        System.out.println(count);
    }
}
