package ru.itis;

import java.io.File;
import java.util.Scanner;
import java.io.IOException;

public class Task_228 {
    public static void main(String[] args) {
        try{
            Scanner in = new Scanner(new File("text.txt"));
            while (in.hasNext()){
                String p = in.next();
                System.out.print(translate(p) + " ");
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    public static String translate(String p){
        String nextLineArray[] = new String[3];
        String nextLine;
        try{
            Scanner in = new Scanner(new File("dictionary.txt"));
            nextLine = in.nextLine();
            nextLineArray = nextLine.split(" ");
            while (in.hasNext() && !nextLineArray[0].equalsIgnoreCase(p)){
                nextLine = in.nextLine();
                nextLineArray = nextLine.split(" ");
            }
        }catch (IOException e){
            e.printStackTrace();
        }
        return nextLineArray[2];
    }
}
