import java.util.Random;//-

public class Array_82 {
    public static void main(String[] args) {
        Random r = new Random();
        int m = 10,
                k = 0;
        int[]
                T1 = new int[m],
                T2 = new int[m];
        boolean
            f = true;

        for (int i = 0; i < m; i++) {
            int t = r.nextInt(2);
            T1[i] = t;
            T2[i] = t;
            System.out.print(T1[i]);
        }
        System.out.println();
        for (int i = 0; i < m; i++) {
            System.out.print(T2[i]);
        }
        System.out.println();

        for (int i = 0; i < m && f; i++) {
            if(T1[i] == 1 && T2[i] == 0) f = false;   //почему неравенство?
        }

        if(f) System.out.println("Y"); else System.out.println("N");
    }
}
