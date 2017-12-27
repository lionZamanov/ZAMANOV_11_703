package ru.itis;

public class Piano extends MusicalInstruments{

    public Piano(){
        setName("Пианино");
        setPrice(0);
        setSound("ла-ла-ла");
    }
    public Piano(int price, String name, String sound){
        setName(name);
        setPrice(price);
        setSound(sound);
    }

}
