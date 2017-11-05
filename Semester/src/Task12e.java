import java.util.Arrays;
import java.util.Scanner;
public class Task12e {

    public static void main(String[] args) {
	// 1.2 E
        Scanner in = new Scanner(System.in);
        double
                z0 = in.nextDouble(),
                z1 = in.nextDouble(),
                fi = 0,
                h = in.nextDouble();
        int
            n = in.nextInt(),
            m = in.nextInt();
        double[] z = new double[n];
        z[0] = z0;
        z[1] = z1;


        for (int i = 2; i < n; i++) {
            z[i] = F(z[i - 1],z[i - 2]);

        }
        System.out.println(Arrays.toString(z));
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if((z[j] >= (i - 1)*h) && (z[j] < i*h)){
                    fi++;
                }
            }
            System.out.println(fi);
            fi = 0;
        }
    }
    public static double F(double a, double x){
        double e = 2.718;
        double res = (Math.pow(e,x) + Math.pow(e,-a))/(1 + a*a + x*x);
        return res;
    }
}
