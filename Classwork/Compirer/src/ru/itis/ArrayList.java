package ru.itis;

/**
 * 15.02.2018
 * ArrayList
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */

import java.util.Iterator;

/**
 * Реализация List на основе массива
 */
public class ArrayList<T> implements List<T> {

    private static final int DEFAULT_SIZE = 4;

    private int count;

    private T elements[];

    public ArrayList(){
        this.elements = (T[])(new Object[DEFAULT_SIZE]);
        this.count = 0;
    }

    @Override
    public int indexOf(T element) {
        for (int i = 0; i < count; i++) {
            if(element.equals(elements[i])){
                return i;
            }
        }
        return -1;
    }

    @Override
    public T get(int index) {
        return elements[index];
    }

    @Override
    public void addToBegin(T element) {
        if(count < elements.length){
            for (int i = count + 1; i > 0; i--) {
                elements[i] = elements[i - 1];
            }
        }
        elements[0] = element;
    }

    @Override
    public void add(T element) {
        if(count < elements.length){
            elements[count++] = element;
        }
    }

    @Override
    public void remove(T element) {
        boolean flag = false;
        int i = 0;
        while(i < count && !flag){
            if(element.equals(elements[i])){
                flag = true;
            }
        }
        if(flag) {
            for (int j = i; j < count - 1; j++) {
                elements[j] = elements[j + 1];
            }
            count--;
        }else throw new IllegalArgumentException();
    }

    @Override
    public boolean contains(T element) {
        for (int i = 0; i < count; i++) {
            if(element.equals(elements[i])){
                return true;
            }
        }
        return false;
    }

    @Override
    public int size() {
        return count;
    }

    public void deleteArray(){
        count = 0;
    }
}
