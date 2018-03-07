package ru.itis;

public class ArrayList<Integer> implements List {

    private static final int DEFAULT_SIZE = 4;

    private int count;

    private int elements[];

    public ArrayList(){
        this.elements = new int[DEFAULT_SIZE];
        this.count = 0;
    }

    @Override
    public int indexOf(Object element) {
        for (int i = 0; i < count; i++) {
            if(element.equals(elements[i])){
                return i;
            }
        }
        return -1;
    }

    @Override
    public Object get(int index) {
        return elements[index];
    }

    @Override
    public void addToBegin(Object element) {
        if(count < elements.length){
            for (int i = count + 1; i > 0; i--) {
                elements[i] = elements[i - 1];
            }
        }
        elements[0] = (int)element;
    }

    @Override
    public void add(Object element) {
        if(count < elements.length){
            elements[count++] = (int)element;
        }
    }

    @Override
    public void remove(Object element) {
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
    public boolean contains(Object element) {
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
