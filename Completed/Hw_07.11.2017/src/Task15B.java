import java.util.*;//-
public class Task15B {
    public static void main(String[] args) {
        int[] X = {1,2,5,4,5,7,7,12,12,12};
        int[] u = new int[10];
        int count = 0,
                j = 0;
        boolean flag = false;

        for (int i = 1; i < X.length-1 ; i++) {
            if(a[i-1] < a[i] && a[i] > a[i+1]){
            	flag != flag;
            	u[count]++;
            	count = 0;
            }
            if(flag){
            	count++;
            }
        }
        if(X[X.length-2]<X[X.length-1]){//почему строгое неравнство?
            count++;
            u[count]++;
        }
        System.out.println(Arrays.toString(u));
        System.out.println(count);
    }
}
