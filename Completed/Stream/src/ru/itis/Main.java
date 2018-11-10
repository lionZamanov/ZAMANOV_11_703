package ru.itis;

import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add("bca");
        linkedList.add("Aa");
        linkedList.add("cs");
	    Stream<String> stream = new Stream<>(linkedList);

	  //  stream.filter(string -> string.length() % 2 == 0);

        System.out.println(stream.getList());

        stream.sorted((o1, o2) -> -o1.compareTo(o2));

        System.out.println(stream.getList());

        stream.map(string -> string + "_1");

        System.out.println(stream.getList());

        stream.filter(string -> string.length() % 2 == 0).filter(string -> string.charAt(0) == 'A');

        System.out.println(stream.getList());

    }
}
