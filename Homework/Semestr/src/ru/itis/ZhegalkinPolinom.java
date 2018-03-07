package ru.itis;

public class ZhegalkinPolinom {
    private LinkedList polinom;

    public ZhegalkinPolinom() {
        polinom = new LinkedList();
    }

    public ZhegalkinPolinom(String S) {
        polinom = new LinkedList();
        String[] subStr = S.split("\\+");

        for (int i = 0; i < subStr.length; i++) {
            String subStr1 = "";
            for (int j = 0; j < subStr[i].length(); j++) {
                if (Character.isDigit(subStr[i].charAt(j)) || subStr[i].charAt(j) == '-') {
                    subStr1 += subStr[i].charAt(j);
                }
            }
            subStr[i] = subStr1;
        }

        for (int i = 0; i < subStr.length; i++) {
            Konj konj = new Konj();
            boolean flag = false;
            for (int j = 0; j < subStr[i].length(); j++) {
                if (subStr[i].charAt(j) == '-') {
                    flag = true;
                } else {
                    if (flag) {
                        konj.konj.add(Character.digit(subStr[i].charAt(j), 10) * -1);
                        flag = false;
                    } else {
                        konj.konj.add(Character.digit(subStr[i].charAt(j), 10));
                    }
                }
            }
            polinom.add(konj);
        }
    }


    public String toString() {
        if(polinom.head == null){
            return "0";
        }
        LinkedList.Node current = polinom.head;
        String result = "";
        while (current.next != null) {
            result += current.value.toString() + "+";
            current = current.next;
        }
        result += current.value;
        return result;
    }


    public void insert(Konj k) {
        if (polinom.contains(k)) {
            polinom.remove(k);
        } else {
            polinom.add(k);
        }
    }


    public ZhegalkinPolinom sum(ZhegalkinPolinom p) {
        ZhegalkinPolinom result = this;
        LinkedList.Node current = p.polinom.head;

        while (current != null) {
            result.insert((Konj) current.value);
            current = current.next;
        }
        return result;
    }


    public byte value(byte[] v) {
        LinkedList.Node current = polinom.head;
        Konj konj;
        byte result = 0;
        while (current != null) {
            konj = (Konj) current.value;
            result += konj.value(v) % 2;
            current = current.next;

        }
        return result;
    }


    public void sortByLength() {
        LinkedList.Node node = polinom.head;
        if (node.next != null) {
            LinkedList.Node node1 = node.next;
            Konj p1, konj, konj1;
            while (node.next != null) {
                while (node1 != null) {
                    konj = (Konj) node.value;
                    konj1 = (Konj) node1.value;
                    if (konj.konj.size() < konj1.konj.size()) {
                        p1 = konj;
                        node.value = konj1;
                        node1.value = p1;
                    }
                    node1 = node1.next;
                }
                node = node.next;
                node1 = node.next;
            }
        }

    }


    public ZhegalkinPolinom polinomWith(byte i) {
        ZhegalkinPolinom result = this;
        LinkedList.Node current = polinom.head;
        Konj konj;
        while (current != null) {
            konj = (Konj) current.value;
            int[] a = new int[4];
            for (int j = 0; j < konj.konj.size(); j++) {
                if((int)konj.konj.get(j) < 0){
                    a[j] = -i;
                }else {
                    a[j] = i;
                }
            }
            konj.setValue(a);
            current = current.next;
        }
        return result;
    }
}
