package ru.itis;

public class Book extends Publication{

    public String authors;


    public Book(String caption, String text, String authors) {
        super(caption, text);
        this.authors = authors;
    }
    @Override
    public String toString() {
        return super.toString() + "authors='" + authors + '\'';
    }

}
