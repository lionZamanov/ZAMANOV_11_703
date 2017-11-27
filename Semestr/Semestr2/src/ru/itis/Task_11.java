package ru.itis;

import java.util.Random;

public class Task_11 {
    public static void main(String[] args) {
        Random in = new Random();
        int[][] A = new int[4][3];
        double[] x = new double[4];

        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[i].length; j++) {
                A[i][j] = in.nextInt(15);
            }
        }
        showMatrix(A);
        for (int i = 0; i < A.length; i++) {
            if(A[i][0] > A[i][2]*A[i][2]) {
                x[i] = F(A[i]);
            }else{
                x[i] = G(A[i]);
            }
            System.out.print(x[i] + " ");
        }
    }

    public static void showMatrix(int[][] a){
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static double F(int[] line){
        double sum = 0;
        for (int i = 0; i < line.length; i++) {
            sum += Math.sin(line[i] - 8.2)*Math.sin(line[i] - 8.2);
        }
        return sum;
    }
    public static double G(int[] line){
        double mult = 1;
        for (int i = 0; i < line.length; i++) {
            mult *= Math.cos(line[i] - 3.5)*Math.cos(line[i] - 3.5);
        }
        return mult;
    }
}
