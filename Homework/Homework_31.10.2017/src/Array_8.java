// Сортировка массива методом локальных экстремумов
import java.util.*;//+
public class Array_8 {
    public static void main(String[] args) {
        Random r = new Random();
        int m = 10,
                random = r.nextInt(m-1)+1,
                k = 0,
                t = 0;
        int[] S = new int[m],
                T = new  int[random],
                T1 = new int[random];

        for(int i = 0; i < m; i++){
            S[i] = r.nextInt(20);
            System.out.print(S[i] + " ");
        }
        for (int i = 0; i < T.length; i++) {
            T[i] = r.nextInt(20);
        }

        System.out.println();
        for(int i = 0; i < T.length; i++){
            for (int j = 0; j < S.length; j++) {
                if(T[i] == S[j]){
                    T1[i] = 1;
                    break;  //не надо строить вектора, они даны!
                }
            }
        }
        System.out.println(Arrays.toString(T));
        System.out.println(Arrays.toString(T1));
        for (int i = 0; i < T1.length; i++) {
            k += T1[i];
        }
        System.out.println(k);
    }
}
