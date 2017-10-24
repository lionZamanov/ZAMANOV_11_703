import java.util.Scanner;//+

public class Task_A{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        int
            n = in.nextInt(),
            m = 2,
                p = -1;
        double
            S = 1,
                t = S;

        while (m < n){
            t = (double)p/(m*m);
            S += t;
            m++;
            p = -p;
        }
        System.out.println(S);


    }
}
