import java.util.Random;

public class Array_83 {
    public static void main(String[] args) {
        Random r = new Random();
        int m = 10,
                k = 0;
        int[] S = new int[m],
                T = new int[m],
                T1 = new int[m],
                T2 = new int[m];

        for (int i = 0; i < m; i++) {
            T1[i] = r.nextInt(2);
            T2[i] = r.nextInt(2);
            System.out.print(T1[i]);
        }
        System.out.println();
        for (int i = 0; i < m; i++) {
            System.out.print(T2[i]);
        }
        System.out.println();

        //Объединение
        for (int i = 0; i < m; i++) {
            if(T1[i] == 1 || T2[i] == 1) T[i] = 1;
        }
        for (int i = 0; i < m; i++) {
            System.out.print(T[i]);
            T[i] = 0;
        }
        System.out.println();

        //Пересечение
        for (int i = 0; i < m; i++) {
            if(T1[i] == 1 && T2[i] == 1) T[i] = 1;
        }
        for (int i = 0; i < m; i++) {
            System.out.print(T[i]);
            T[i] = 0;
        }
        System.out.println();

        //Разность
        for (int i = 0; i < m; i++) {
            if(T1[i] == 1 && T2[i] != 1) T[i] = 1;
        }
        for (int i = 0; i < m; i++) {
            System.out.print(T[i]);
        }
    }
}
