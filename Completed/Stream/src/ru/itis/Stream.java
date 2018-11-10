package ru.itis;

import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;

public class Stream<T> {

    private List<T> linkedList;

    public Stream(LinkedList linkedList){
        this.linkedList = linkedList;
    }

    public Stream<T> filter(Predicate<T> predicate){
        ListIterator<T> i = linkedList.listIterator();
        while (i.hasNext()) {
            if(!predicate.test(i.next())){
                i.remove();
            }
        }
        return this;
    }

//    public void add(T t){
//        linkedList.add(t);
//    }

    public Stream<T> map(Function<T, ?> function){
        ListIterator<T> i = linkedList.listIterator();
        while (i.hasNext()) {
            function.apply(i.next());
        }
        return this;
    }

    public Stream<T> sorted(Comparator<T> comparator){
        ListIterator<T> i = linkedList.listIterator();
        Collections.sort(linkedList, comparator);
        return this;
    }
    public List getList(){
        return linkedList;
    }
}
