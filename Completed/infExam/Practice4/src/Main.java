import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        ArrayList<String> arrayList = new ArrayList<>();
        int k = 0;
        try {
            Scanner scanner = new Scanner(new File("in.txt"));
            k = scanner.nextInt();
            while(scanner.hasNext()){
                String currentString = scanner.next();
                if(currentString.length() >= k){
                    arrayList.add(currentString);
                }
            }
        } catch (FileNotFoundException e) {
            throw new FileNotFoundException();
        }

        for (int i = 0; i < k; i++) {
            outputList(sortList(arrayList, i));
        }
    }

    public static ArrayList<String> sortList(ArrayList<String> arrayList, int i){
        Collections.sort(arrayList, new stringComparator(i));
        return arrayList;
    }

    public static void outputList(ArrayList<String> arrayList){
        try {
            FileWriter fileWriter = new FileWriter("out.txt", true);
            fileWriter.write("\n");
            for (String s: arrayList) {
                fileWriter.write(s);
                fileWriter.write("\n");
            }
            fileWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
