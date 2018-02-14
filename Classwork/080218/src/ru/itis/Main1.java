package ru.itis;

import java.io.BufferedReader;
import java.io.FileReader;

public class Main1 {

    public static void main(String[] args) throws Exception{

        BufferedReader reader = new BufferedReader(new FileReader("file.txt"));

        //Считываем круги
        int RoundsAmount = Integer.parseInt(reader.readLine());
        Rounds[] r = new Rounds[RoundsAmount];
        for (int i = 0; i < RoundsAmount; i++) {
            String radiusWithPoints[] = reader.readLine().split(" ");
            int radius = Integer.parseInt(radiusWithPoints[0]);
            int score = Integer.parseInt(radiusWithPoints[1]);
            Rounds circle = new Rounds(radius, score);
            r[i] = circle;
        }

        //Сортировка кругов
        Rounds circle = new Rounds();
        circle.sort(r);


        //Считываем выстрелы
        int ShootsAmount = Integer.parseInt(reader.readLine());
        ShootCoordinates[] c = new ShootCoordinates[ShootsAmount];
        for (int i = 0; i < ShootsAmount; i++) {
            String shootsCoordinates[] = reader.readLine().split(" ");
            int x = Integer.parseInt(shootsCoordinates[0]);
            int y = Integer.parseInt(shootsCoordinates[1]);
            ShootCoordinates sc = new ShootCoordinates(x, y);
            c[i] = sc;
        }

        //Подсчет очков
        int result = 0;
        for (int i = 0; i < ShootsAmount; i++) {
            result += getScore(c[i], r);
        }
        for (int i = 0; i < r.length; i++) {
            System.out.println(r[i].radius);
        }
        System.out.println(result);

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
