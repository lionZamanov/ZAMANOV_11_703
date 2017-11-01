public class Task3 {

    public static void main(String[] args) {
        // write your code here
        int
                k = 1,
                e = 0;
        int[] a = {2,2,3,4,4,4,5,5,6,6,6,7,7};
        int n = a.length;
        int[] w = new int[n];

        for (int i = 0; i < n-1; i++) {
            if(a[i] == a[i+1]){
                k++;
            }
            if(a[i] != a[i+1]){
                w[k]++;
                k = 1;
            }
        }
        w[k]++;
        for (int j = 0; j < w.length; j++) {
            System.out.print(w[j] + " ");
        }
    }
}
