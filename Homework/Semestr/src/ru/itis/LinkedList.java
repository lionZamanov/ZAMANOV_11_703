package ru.itis;

/**
 * 15.02.2018
 * LinkedList
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */

import java.util.Iterator;

/**
 * Реализация списка на основе узлов (связного списка)
 */
public class LinkedList<T> implements List<T> {

    /*@Override
    public Iterator<T> iterator() {
        return new LinkedListIterator();
    }

    // вложенный класс
    private class LinkedListIterator implements Iterator<T> {
        // указывает на текущий индекс
        private Node currentNode;

        public LinkedListIterator() {
            this.currentNode = head;
        }

        @Override
        public boolean hasNext() {
            return currentNode != null;
        }

        @Override
        public T next() {
            T result = currentNode.value;
            currentNode = currentNode.next;
            return result;
        }
    }*/

    public class Node {
        T value;
        Node next;

        Node(T value) {
            this.value = value;
        }
    }

    public Node head;
    public Node tail;

    private int count;

    public LinkedList() {
        this.count = 0;
    }

    @Override
    public int indexOf(T element) {
        return 0;
    }

    @Override
    public T get(int index) {
        if (index >= count) {
            throw new IllegalArgumentException();
        }
        Node current = this.head;
        int i = 0;

        while (i < index) {
            current = current.next;
            i++;
        }

        return current.value;
    }

    // TODO: реализовать
    @Override
    public void addToBegin(T element) {
        Node newNode = new Node(element);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }

        count++;
    }

    @Override
    public void add(T element) {
//        Node newNode = new Node(element);
//
//        if (head == null) {
//            head = newNode;
//        } else {
//            // создаем переменную, которая указывает
//            //  на начало списка
//            Node current = head;
//            // пока следующий после текущего есть
//            while (current.next != null) {
//                // идем дальше
//                current = current.next;
//            }
//            current.next = newNode;
//        }
        Node newNode = new Node(element);

        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            if(head.next == null){
                head.next = newNode;
            }
            tail.next = newNode;
            tail = newNode;
        }
        count++;
    }

    @Override
    public void remove(T element) {
        Node current = head;
        Node current1 = head.next;

        if(contains(element)) {
            if(element.equals(current.value)){
                head = current1;
            }else {
                while (!element.equals(current1.value)) {
                    current = current1;
                    current1 = current1.next;
                }
                current.next = current1.next;
            }
            count--;
        }
    }

    // TODO: реализовать
    @Override
    public boolean contains(T element) {
        Node current = head;
        while(current != null){
            if(current.value.equals(element)){
                return true;
            }
            current = current.next;
        }
        return false;
    }

    @Override
    public int size() {
        return count;
    }

    /*
    public static <E extends Comparable<E>> LinkedList merge(LinkedList<E> a, LinkedList<E> b) {
        Iterator<E> iteratorA = a.iterator();
        Iterator<E> iteratorB = b.iterator();
        LinkedList result = new LinkedList();

        result.add(iteratorA.next().compareTo(iteratorB.next()));
        while(iteratorA.hasNext()){
            result.add(iteratorA.next().compareTo(iteratorB.next()));
        }


        return result;
    }
    */
}

