package ru.itis;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        try{
            Scanner in = new Scanner(new File("file.txt"));
            //Считываем круги
            int RoundsAmount = Integer.parseInt(in.nextLine());
            Rounds[] r = new Rounds[RoundsAmount];
            for (int i = 0; i < RoundsAmount; i++) {
                r[i].scores = in.nextInt();
                r[i].radius = in.nextInt();
            }

            //Считываем выстрелы
            int ShootsAmount = in.nextInt();
            ShootCoordinates[] c = new ShootCoordinates[ShootsAmount];
            for (int i = 0; i < ShootsAmount; i++) {
                c[i].x = in.nextInt();
                c[i].y = in.nextInt();
            }

            //Подсчет очков
            int result = 0;

            for (int i = 0; i < ShootsAmount; i++) {
                result += getScore(c[i], r);
            }

            System.out.println(result);
        }catch (IOException e){
            e.printStackTrace();
        }



    }

    //Сколько очков принес выстрел
    public static int getScore(ShootCoordinates c, Rounds[] r){
        for (int j = 0; j < r.length; j++) {
            if(r[j].check(c)){
                return r[j].scores;
            }
        }
        return 0;
    }

}
