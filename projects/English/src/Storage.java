import java.io.File;
import java.io.IOException;
import java.util.Scanner;
public class Storage {

    public static final int N = 13;
    public String[] Questions = new String[N];
    public String[] Answers = new String[N];
    public String[] RightAnswers = new String[N];

    public Storage(){
        try{
            int i = 0;
            Scanner q = new Scanner(new File("Questions.txt"));
            Scanner a = new Scanner(new File("Answers.txt"));
            Scanner ra = new Scanner(new File("RightAnswers.txt"));
            while (q.hasNext()){
                Questions[i] = q.nextLine();
                i++;
            }
            i = 0;
            while (a.hasNext()){
                Answers[i] = a.nextLine();
                i++;
            }
            i = 0;
            while (ra.hasNext()){
                RightAnswers[i] = ra.nextLine();
                i++;
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    public void showAnswers(){
        for (int i = 0; i < Answers.length; i++) {
            System.out.print(Answers[i] + " ");
            if (i % 5 == 0){
                System.out.println();
            }
        }
    }
    public void showQuestion(int i){
        System.out.println(Questions[i]);
    }
    public void delete(String st){
        for (int j = 0; j < Answers.length; j++) {
            if(st.equalsIgnoreCase(Answers[j])){
                Answers[j] = "____";
                break;
            }
        }
    }
}
