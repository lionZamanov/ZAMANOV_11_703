import java.util.Arrays;
import java.util.Scanner;
public class Task12e {

    public static void main(String[] args) {
	// 1.2 E
        Scanner in = new Scanner(System.in);
        double
            z0 = -3.56,
            z1 = 3.56,
            h = 1;
        int
            n = 42,
            fi = 0,
            m = 8;
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
        double res = (Math.pow(Math.E,x) + Math.pow(Math.E,-a))/(1 + a*a + x*x);
        return res;
    }
}
