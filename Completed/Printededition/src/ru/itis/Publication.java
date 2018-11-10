package ru.itis;

public class Publication {

    String caption;
    String text;


    public Publication(String caption, String text){
        this.caption = caption;
        this.text = text;
    }

    @Override
    public String toString() {
        return
                "caption='" + caption + '\'' +
                ", text='" + text + '\'';
    }
}
