public class Task7 {

    public static void main(String[] args) {
        // write your code here
        int n = 12,
                k = 1,
                e = 0;
        int[] a = {2,2,3,4,4,4,5,5,6,6,6,6,7};
        int[] w = new int[a.length];
        if(a[0] != a[1]){
            w[0] = a[0];
        }
        if(a[a.length-2] != a[a.length-1]){
            w[a.length-1] = a[a.length-1];
        }

        for(int i = 1; i < a.length - 1; i++){
            if((a[i] != a[i+1]) && (a[i - 1] != a[i])){
                w[i] = a[i];
            }
        }
    }
}
