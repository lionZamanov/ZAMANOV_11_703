package ru.itis;

import java.util.ArrayList;
import java.util.List;

public class Legion implements Army {
    private List<Soldier> armyChilds = new ArrayList<>();

    @Override
    public void attack() {
        for (Soldier soldier : armyChilds) {
            soldier.attack();
        }
    }

    public void add(Soldier soldier) {
        armyChilds.add(soldier);
    }

    public void remove(Soldier soldier) {
        armyChilds.remove(soldier);
    }
}
