import java.util.Scanner;
public class Task12e {

    public static void main(String[] args) {
	// 1.2 E
        Scanner in = new Scanner(System.in);
        double e = 2.74,
                x,
                h = in.nextDouble(),
                b = in.nextDouble(),
                a;
        for (int i = 0; i < 3; i++) {
            a = in.nextDouble();
            x = b + i*h;
            System.out.println(F(x,a,e));
        }
    }
    public static double F(double a, double x, double e){
        double res = (Math.pow(e,x) + Math.pow(e,-a))/(1 + a*a + x*x);
        return res;
    }
}
