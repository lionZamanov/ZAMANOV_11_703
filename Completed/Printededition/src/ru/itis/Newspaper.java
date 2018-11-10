package ru.itis;

public class Newspaper extends Publication{
    int date;

    public Newspaper(String caption, String text, int date) {
        super(caption, text);
        this.date = date;
    }
    
}
