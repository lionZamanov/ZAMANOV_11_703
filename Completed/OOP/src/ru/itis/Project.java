package ru.itis;

import java.util.Calendar;
import java.util.Random;

public class Project implements Team{
    public String name;
    public int cost;
    public int money;

    public Project(String name, int cost, int money){
        this.name = name;
        this.cost = cost;
        this.money = money;
    }

    public void showPresentation(){
        cost += cost*0.2;
    }

    public void askMoneyFromSponsors(){
        Calendar c = Calendar.getInstance();
        Random r = new Random();
        Integer dayOfWeek = c.get(Calendar.DAY_OF_WEEK);
        if(dayOfWeek == r.nextInt(7)){
            money += 5500;
        }
    }
    public void work(){};
}
