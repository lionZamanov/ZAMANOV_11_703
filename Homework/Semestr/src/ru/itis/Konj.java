package ru.itis;

public class Konj {

    public ArrayList konj;

    public Konj() {
        konj = new ArrayList();
    }

    /*
    public Konj(ArrayList konjArray){
        konj = konjArray;
    }
    */

    public void setValue(int[] p) {
        int k = konj.size();
        konj.deleteArray();
        for (int i = 0; i < k; i++) {
            konj.add(p[i]);
        }
    }


    @Override
    public boolean equals(Object obj) {
        return this.toString().equals(obj.toString());
    }


    @Override
    public String toString() {
        int i = 0;
        String result = "";
        while ((int) konj.get(i) != 0 && i < konj.size()) {
            if (i == konj.size()) {
                result += "X" + konj.get(i);
            } else if ((int) konj.get(i + 1) == 0) {
                result += "X" + konj.get(i);
            } else {
                result += "X" + konj.get(i) + "&";
            }
            i++;
        }
        return result;
    }


    public int value(byte[] a) {
        int result = 1;
        int i = 0;
        while ((int) konj.get(i) != 0) {
            if ((int) konj.get(i) < 0) {
                if (a[Math.abs((int) konj.get(i))] == 1) {
                    result *= 0;
                } else {
                    result *= 1;
                }
            } else {
                result *= a[Math.abs((int) konj.get(i))];
            }
            i++;
        }
        return result;
    }
}
