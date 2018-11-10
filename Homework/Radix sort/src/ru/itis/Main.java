package ru.itis;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.*;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        HashSet
        Scanner scanner;
        int[] array = null;
        int i = 0;
        String fileName = "dataInput/" + i + ".txt";
        Data data = new Data();
        while ((new File(fileName)).exists()) {
            try {
                scanner = new Scanner(new File(fileName));
                String[] string = scanner.nextLine().split(" ");
                array = stringToIntArray(string);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            radixSort(array);
            data.dataOutput(array, i);
            i++;
            fileName = "dataInput/" + i + ".txt";
        }
    }

    public static int[] radixSort(int[] array) {
        long start = System.nanoTime(),
            end;
        ArrayList[] subArray = new ArrayList[10];
        int
            l = 1,
            iterationCounter = 0;

        int j, u;
        int max = array[0],
            counterOfRadix = 0;

        //Наибольший элемент
        for (int i = 1; i < array.length; i++) {
            max = max > array[i] ? max : array[i];
            iterationCounter++;
        }

        //Количество разрядов в наибольшем элементе
        while (max != 0) {
            max /= 10;
            counterOfRadix++;
            iterationCounter++;
        }
        for (int k = 0; k < subArray.length; k++) {
            subArray[k] = new ArrayList(array.length);
            iterationCounter++;
        }

        //Бежим по  всем разрядам
        for (int i = 0; i < counterOfRadix; i++) {
            for (int k = 0; k < subArray.length; k++) {
                subArray[k] = new ArrayList(array.length);
                iterationCounter++;
            }

            //Группируем массив по разрядам
            for (int e = 0; e < array.length; e++) {
                int k = (array[e] / l) % 10;
                subArray[k].add(array[e]);
                iterationCounter++;
            }

            //Куча counter'ов для возвращения всех значений в массив обратно
            u = 0;
            for (int k = 0; k < subArray.length; k++) {
                j = 0;
                while (subArray[k].size() != j) {
                    array[u] = (int) subArray[k].get(j);
                    j++;
                    u++;
                    iterationCounter++;
                }
                subArray[k].deleteArray();
            }
            l *= 10;
        }
        end = System.nanoTime();
        System.out.println(end - start);
        return array;
    }

    public static int[] stringToIntArray(String[] string) {
        int[] array = new int[string.length];
        for (int i = 0; i < string.length; i++) {
            array[i] = Integer.parseInt(string[i]);
        }
        return array;
    }

    public static void outputInExcel(int iterationCounter, long time) {
        /*try {
            // получаем файл в формате xls
            FileInputStream file = new FileInputStream(new File("C:\\results.xlsx"));

            try {
                // формируем из файла экземпляр HSSFWorkbook
                HSSFWorkbook workbook = new HSSFWorkbook(file);

            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        // выбираем первый лист для обработки
        // нумерация начинается с 0
        HSSFSheet sheet = workbook.getSheetAt(0);

        // получаем Iterator по всем строкам в листе
        Iterator<Row> rowIterator = sheet.iterator();

        // получаем Iterator по всем ячейкам в строке
        Iterator<Cell> cellIterator = row.cellIterator();*/

        Workbook book = new HSSFWorkbook();
        Sheet sheet = book.createSheet("Results");
        Row row = sheet.createRow(0);
        row.createCell(0).setCellValue("Array size");
        row.createCell(1).setCellValue("Count iteration");
        row.createCell(2).setCellValue("Time");








    }

}
