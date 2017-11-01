import java.util.Random;

public class Sort_merger {
    public static void main(String[] args) {
        Random r = new Random();
        int[] a = {1,3,435};
        int[] b = {2,4,6,7,8};
        int n = 10,
                e = a.length + b.length,
                l = 0,
                i = 0,
                j = 0;
        int[] c = new int[e];

        for(i = 0; i < e && l != a.length && j != b.length; i++) {
            if(a[l] < b[j]){
                c[i] = a[l];
                l++;
            }else{
                c[i] = b[j];
                j++;
            }
        }

        if(l < a.length){
            for(int k = i; k < e;k++){
                c[k] = a[l];
                l++;
            }
        }else if(j < b.length){
            for(int k = i; k < e;k++){
                c[k] = b[j];
                j++;
            }
        }
        for(i = 0; i < e; i++){
            System.out.print(c[i] + " ");
        }
    }
}
