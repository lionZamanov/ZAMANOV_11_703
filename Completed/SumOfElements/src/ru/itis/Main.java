package ru.itis;

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	    Scanner scanner = new Scanner(System.in);
	    Random random = new Random();
	    int n = 1000000,
                sum = 0,
                sumThreads = 0;
	    int array[] = new int[n];

        for (int i = 0; i < n; i++) {
            array[i] = random.nextInt(1000);
            sum += array[i];
        }

        System.out.println(sum);

        int k = scanner.nextInt();

        SumThread[] threadArray = new SumThread[k];
        for (int i = 0; i < k; i++) {
            threadArray[i] = new SumThread(i * n/k, n/k * (i + 1), array);
            try {
                threadArray[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        for (int i = 0; i < k; i++) {
            sumThreads += threadArray[i].getResult();
            System.out.println(threadArray[i].getResult());
        }

        if(sumThreads == sum){
            System.out.println("OK");
        }else{
            System.out.println("Not OK");
        }
    }
}
