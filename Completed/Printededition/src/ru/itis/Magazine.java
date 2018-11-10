package ru.itis;

public class Magazine extends Publication{
    int year;
    int number;
    public Magazine(String caption, String text, int year) {
        super(caption, text);
        this.year = year;
        this.number = number;
    }

    @Override
    public String toString() {
        return super.toString() + "authors='" + year + '\'';
    }

}
