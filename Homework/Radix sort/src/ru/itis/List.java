package ru.itis;

public interface List<T> extends Collection<T> {

    int indexOf(T element);

    T get(int index);
}
