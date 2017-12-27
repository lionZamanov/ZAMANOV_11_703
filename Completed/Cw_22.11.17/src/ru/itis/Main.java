package ru.itis;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Guitar g = new Guitar();
        Guitar p1 = new Guitar();
        Piano p = new Piano(200,"Пианино 90-ых годов", "ла-ал-ла");

        MusicalInstruments[][] shelf = new MusicalInstruments[2][2];
        int x,
            y;

        shelf[0][0] = g;
        shelf[0][1] = p;
        shelf[1][0] = p1;
        System.out.println("Какая полка? " + "0 - " + (shelf.length - 1));
        x = in.nextInt();
        System.out.println("Какой музыкальный инструмент? " + "0 - " + (shelf[x].length - 1));
        y = in.nextInt();
        System.out.println("Так он звучит:");
        System.out.println(shelf[x][y].getSound());
        System.out.println("Полная информация:");
        System.out.println(shelf[x][y]);
    }
}
