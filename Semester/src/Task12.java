import java.util.Arrays;
import java.util.Scanner;

public class Task12 {

    public static void main(String[] args) {
	// 1.2
        Scanner in = new Scanner(System.in);
        double
            z0 = -3.56,
            z1 = 3.56,
            znew,
            h = 1;
        int
            n = 42,
            m = 8;
        int[] fi = new int[m];
        double[] z = new double[n];
        z[0] = z0;
        z[1] = z1;
        for (int i = 2; i < n; i++) {
            z[i] = F(z[i - 1],z[i - 2]);
        }
        System.out.println(Arrays.toString(z));
        znew = F(z1,z0);
        for (int i = 0; i < n; i++) {
            z0 = z1;
            z1 = znew;
            znew = F(z1,z0);
            for (int j = 1; j < m; j++) {
                if((j - 1)*h <= z1 && z1 < j*h) fi[j]++;
            }
            System.out.print(z1 + " ");
        }
        for (int i = 0; i < m; i++) {
            System.out.println(fi[i]);
        }
    }
    public static double F(double a, double x){
        double res = (Math.pow(Math.E,x) + Math.pow(Math.E,-a))/(1 + a*a + x*x);
        return res;
    }
}
