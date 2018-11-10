package ru.itis;

import java.util.Calendar;
import java.util.Random;

public class ICOProjects extends Project {
    int tokenPrice;

    public ICOProjects(String name, int cost, int money, int tokenPrice){
        super(name, cost, money);
        this.tokenPrice = tokenPrice;
    }
    public ICOProjects(){
        this("ICOProject", 100, 1000, 1);
    }

    public void showPresentation(){
        tokenPrice += tokenPrice*0.4;
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
