package ru.itis;

import java.util.ArrayList;
import java.util.List;

public class CompoundArmy implements Army {
    private List<Division> armyChilds = new ArrayList<>();

    @Override
    public void attack() {
        for (Division division : armyChilds) {
            division.attack();
        }
    }


    public void add(Division division) {
        armyChilds.add(division);
    }

    public void remove(Division division) {
        armyChilds.remove(division);
    }
}
