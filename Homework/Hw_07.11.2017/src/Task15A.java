public class Task15A {
    public static void main(String[] args) {
        int[] X = {1,2,5,4,5,7,7,12,11,12};
        int
                t = 0,
                s = X.length + 1,
                count = 0;

        for (int i = 0; i < X.length-1 ; i++) {
            if(X[i]>X[i+1])
                count = 0;
            if(X[i]<=X[i+1]){
                count++;
                if(count > t)
                    t = count;
                if(s > count)
                    s = count;
            }
        }
        System.out.println(t);
        System.out.println(s);
    }
}
