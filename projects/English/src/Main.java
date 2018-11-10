import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static final int N = 13;
    public static void main(String[] args) {
        String[] answers = new String[N];
        int counter = 0;
        Storage st = new Storage();
        Scanner in = new Scanner(System.in);
        System.out.println("Welcome to the game!");

        for (int i = 0; i < N; i++) {
            show(i, st);
            answers[i] = in.nextLine();
            if(answers[i].equalsIgnoreCase(st.RightAnswers[i])) {
                counter++;
            }
            st.delete(answers[i]);
            clearConsole();
        }
        for (int i = 0; i < N; i++) {
            System.out.println(i + 1 + ".) " + "Ваш ответ: " + answers[i]);
            System.out.println("  " + "Правильный ответ: " + st.RightAnswers[i]);
        }
        System.out.println("Итог: " + counter + "/" + N);
    }
    public static void clearConsole(){
        System.out.println("\n\n\n\n\n");
    }
    public static void show(int i, Storage st){
        st.showAnswers();
        System.out.println();
        st.showQuestion(i);
        System.out.println("Введите ответ:");
    }
}
