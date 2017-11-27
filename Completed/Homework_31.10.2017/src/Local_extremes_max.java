// Сортировка методом локальных максимумов
public class Local_extremes_max {
    public static void main(String[] args) {

        int[] a = {3, 7, 4, 1, 6, 8, 0};
        int max;
        int max_i;

        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();

        for (int i = a.length - 1; i >= 0; i--) {
            max = a[i];
            max_i = i;

            for (int j = i - 1; j >= 0; j--) {
                if (a[j] >= max) {
                    max = a[j];
                    max_i = j;
                }
            }
            if (i != max_i) {
                int s = a[i];
                a[i] = a[max_i];
                a[max_i] = s;
            }

        }
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }
}