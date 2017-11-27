import java.util.*;//+
public class Array_8 {
    public static void main(String[] args) {
        Random r = new Random();
        int m = 10,
                k = 0;
        int[] S = new int[m],
                T1 = new int[m];

        for (int i = 0; i < T1.length; i++) {
            T1[i] = r.nextInt(2);
            System.out.print(T1[i]);
        }
        System.out.println();

        for (int i = 0; i < T1.length; i++) {
            k += T1[i];
        }
        System.out.println(k);
    }
}
