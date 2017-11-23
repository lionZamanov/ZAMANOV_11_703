package ru.itis;

public class Guitar extends MusicalInstruments{

    public Guitar(){
        setName("Гитара");
        setPrice(0);
        setSound("трунь-трунь");
    }
    public Guitar(int price, String name){
        setName(name);
        setPrice(price);
    }

}
