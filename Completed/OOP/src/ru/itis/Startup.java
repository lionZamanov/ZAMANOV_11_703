package ru.itis;

import java.util.Calendar;
import java.util.Random;

public class Startup extends Project {
    int term;

    public Startup(String name, int cost, int money, int term){
        super(name, cost, money);
        this.term = term;
    }

    public void showPresentation(){
        cost += cost*0.4;
    }

    public void askMoneyFromSponsors(){
        Calendar c = Calendar.getInstance();
        Random r = new Random();
        Integer dayOfWeek = c.get(Calendar.DAY_OF_WEEK);
        if(dayOfWeek == r.nextInt(7)){
            money += 10000;
        }
    }
}
