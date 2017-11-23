package ru.itis;

public class MusicalInstruments {
    private int price;
    private String sound;
    private String name;

    public MusicalInstruments(){
        name = "Музыкальный инструмент";
        price = 0;
        sound = "AaaAAAaaa";
    }

    @Override
    public String toString() {
        return "Имя: " + name + ", "+
                "Цена: " + price + ", "+
                "Sound: " + sound ;
    }

    public void setPrice(int price){
        this.price = price;
    }
    public int getPrice(){
        return price;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }
    public void setSound(String sound){
        this.sound = sound;
    }
    public String getSound(){
        return sound;
    }
}
