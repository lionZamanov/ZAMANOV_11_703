// Сортировка локальных минимумов
public class Local_extremes_min {

    public static void main(String[] args) {

        int[] a = {7, 8, 3, 5, 6, 2, 0};
        int min;
        int min_i;

        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();

        for (int i = 0; i < a.length; i++) {
            min = a[i];
            min_i = i;

            for (int j = i + 1; j < a.length; j++) {
                if (a[j] <= min) {
                    min = a[j];
                    min_i = j;

                }
            }
            if (i != min_i) {
                int s = a[i];
                a[i] = a[min_i];
                a[min_i] = s;
            }

        }
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }
}