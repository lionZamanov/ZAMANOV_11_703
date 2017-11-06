// 1.3

import java.util.*;

public class Task13d {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        boolean f = false;
        double
            a0 = in.nextDouble(),
                b0 = in.nextDouble(),
                t = 0,
                e = in.nextDouble();
        int
            n = in.nextInt();
        double[]
            a = new double[n],
                b = new double[n];
        a[0] = a0;
        b[0] = b0;
        for (int i = 1; i < n; i++) {
            a[i] = F(a[i-1],b[i-1]);
            b[i] = G(a[i-1],b[i-1]);
        }
        System.out.println(Arrays.toString(a));
        System.out.println(Arrays.toString(b));
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(f(a[i],b[j]) < e){
                    f = true;
                }
            }
            if(f){
                System.out.println(a[i]);
            }
            f = false;
        }
    }
    public static double F(double a, double x){
        return Math.sqrt(2 + Math.sin(a + x)) + Math.sqrt(2 - Math.cos(a + x));
    }
    public static double G(double a, double x){
        return (Math.pow(Math.E,x) + Math.pow(Math.E,-a))/(1 + a*a + x*x);
    }
    public static double f(double a, double b){
        return Math.abs(a-b);
    }

}
