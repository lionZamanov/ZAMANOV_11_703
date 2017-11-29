package ru.itis;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	    String zeros = "\u0000\u0000";
	    char[] charArray = {'x', 'y', 'z'};
	    String string = new String(charArray);
        System.out.println(string);
        String s1 = "Пыль дорог и ветра свист";
        System.out.println(s1);
        String string1 = s1.concat("Таких друзей больше нет");
        System.out.println(string1);
        for (int i = 0; i < s1.length(); i++) {
            System.out.print(s1.charAt(s1.length() - i - 1));
        }
        System.out.println();
        try{
            Scanner in = new Scanner(new File("file.txt"));
            while (in.hasNext()){
                String p = in.nextLine();
                System.out.println(p);
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
