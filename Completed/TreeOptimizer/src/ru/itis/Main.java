package ru.itis;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        InputStream
    }

    public static int treeOptimize(int id){
        try{
            Scanner scanner = new Scanner(new File("input"+ id +".txt"));
            String firstLine[] = scanner.nextLine().split(" ");
            int size = Integer.parseInt(firstLine[0]);
            int P = 0;
            int maxHeir = Integer.parseInt(firstLine[1]);
            int[] nodes = new int[size];
            while (scanner.hasNextLine()){
                int currentLine = Integer.parseInt(scanner.nextLine());
                nodes[currentLine]++;
                /*if(nodes[currentLine] > maxHeir && nodes[currentLine] % (maxHeir - 1) == 0){
                    P++;
                }*/
                if(nodes[currentLine] > maxHeir && (nodes[currentLine] - (maxHeir + 1)) % (maxHeir - 1) == 0){
                    P++;
                }
            }
            /*for (int i = 0; i < nodes.length; i++) {
                if(nodes[i] / maxHeir > 0){
                    P += nodes[i] / maxHeir;
                }
                if(nodes[i] % maxHeir > 0){
                    P++;
                }

            }*/
            return P;

        }catch (FileNotFoundException e){
            return -1;
        }
    }
}
