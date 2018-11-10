package ru.itis;

public class SimpleExecutorService extends Thread {


    public void setData(int start, int end, int[] array){
        SumThread thread = new SumThread(start, end, array);
        thread.start();
    }
}
