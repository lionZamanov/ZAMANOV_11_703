public class Main {

    public static void main(String[] args) {
	// write your code here
        int n = 12,
                k = 1,
                e = 0;
        int[] a = {2,2,3,4,4,4,5,5,6,6,6,6,7};
        if(a[0] != a[1])e++;
        if(a[a.length-2] != a[a.length-1])e++;

        for(int i = 1; i < a.length - 1; i++){
            if((a[i] != a[i+1]) && (a[i - 1] != a[i])){
                e++;
            }
        }
        System.out.println(e);
    }
}
