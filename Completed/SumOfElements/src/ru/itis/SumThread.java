package ru.itis;

public class SumThread extends Thread {

    private int result;
    private int start;
    private int end;
    private int[] array;

    public SumThread(int start, int end, int[] array){
        this.start = start;
        this.end = end;
        this.array = array;
        result = 0;
        this.start();
    }

    @Override
    public void run() {
        for (int i = start; i < end; i++) {
            result += array[i];
        }
    }

    public int getResult() {
        return result;
    }
}
