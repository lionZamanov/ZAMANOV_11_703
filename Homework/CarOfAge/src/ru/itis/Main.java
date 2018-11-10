package ru.itis;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        int[] arrayOfAges = new int[100];
        StringBuffer sb = new StringBuffer();
        int c;
        int spaceCounter = 0;
        try {
            FileReader userReader = new FileReader("Car.txt");
            while((c = userReader.read()) != -1){
                if(c == ' '){
                    spaceCounter++;
                }
                if(spaceCounter == 2){
                    while((c = userReader.read()) != '\r'){
                        sb.append((char)c);
                    }
                    if(findUserById(sb.toString()) != -1) {
                        arrayOfAges[findUserById(sb.toString())]++;
                    }
                    spaceCounter = 0;
                    sb.setLength(0);
                }
            }
            userReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < arrayOfAges.length; i++) {
            if(arrayOfAges[i] != 0){
                System.out.println(i + " лет, а уже столько машин : " + arrayOfAges[i]);
            }
        }
    }

    public static int findUserById(String id){
        StringBuffer idBuffer = new StringBuffer();
        StringBuffer ageBuffer = new StringBuffer();
        int c;
        try {
            FileReader carReader = new FileReader("User.txt");
            while((c = carReader.read()) != -1){
                idBuffer.append((char)c);
                while((c = carReader.read()) != ' '){
                    idBuffer.append((char)c);
                }
                while((c = carReader.read()) != ' '){}

                while((c = carReader.read()) != '\r'){
                    ageBuffer.append((char)c);
                }
                carReader.read();
                if(idBuffer.toString().equals(id)){
                    carReader.close();
                    return Integer.parseInt(ageBuffer.toString());
                }
                idBuffer.setLength(0);
                ageBuffer.setLength(0);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return -1;
    }
}
//Количество полей, пробелов
//Данные подаются корректно?
