package ru.itis;

public class Main {

    public static void main(String[] args) {
	    int[] array = new int[1000];
	    radixSort(array);
    }

    public static int[] radixSort(int[] array, radix){
        int[] arrayOfIndex = new int[array.length];
        int[] subArray = new int[array.length];

        for (int i = 0; i < array.length; i++) {
            arrayOfIndex[i % 10]++;
        }
        for (int i = 0; i < arrayOfIndex.length; i++) {
            subArray[i] = arrayOfIndex[]
        }
    }
}
