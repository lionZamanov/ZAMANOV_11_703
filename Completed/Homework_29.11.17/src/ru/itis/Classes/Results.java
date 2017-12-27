package ru.itis.Classes;

public class Results {
    private static final int CAPACITY = 100;
    private int size;
    private int[] storage;
    public Results(){
        size = 0;
        storage = new int[CAPACITY];
    }
    public void addResults(int[] Results){
        for (int i = 0; i < Results.length; i++) {
            storage[i] = Results[i];
            size = Results.length;
        }
    }
    public int[] sortUp(){
        int a;
        boolean flag = false;
        for (int i = 0; i < size - 1 && !flag; i++) {
            flag = true;
            for (int j = 0; j < size-1; j++) {
                if(storage[j] > storage[j+1]){
                    a = storage[j];
                    storage[j] = storage[j+1];
                    storage[j+1] = a;
                    flag = false;
                }
            }
        }
        return storage;
    }
    public int[] sortDown(){
        int a;
        boolean flag = false;
        for (int i = 0; i < size - 1 && !flag; i++) {
            flag = true;
            for (int j = 0; j < size; j++) {
                if(storage[j] < storage[j+1]){
                    a = storage[j];
                    storage[j] = storage[j+1];
                    storage[j+1] = a;
                    flag = false;
                }
            }
        }
        return storage;
    }
    public int winner(){
        int a = storage[0];
        for (int i = 1; i < size; i++) {
            if(storage[i] < a){
                a = storage[i];
            }
        }
        return a;
    }

    public int[] winner3(){
        sortDown();
        int[] a = new int[3];
        for (int i = 0; i < 3; i++) {
            a[i] = storage[i];
        }
        return a;
    }

    public double averageResult(){
        double a = 0;
        for (int i = 0; i < size; i++) {
            a += storage[i];
        }
        return a/size;
    }
    public int quantity(){
        return size;
    }

    @Override
    public String toString() {
        String result = "";
        for (int i = 0; i < size; i++) {
            result = result + storage[i] + " ";
        }
        return result;
    }
}
