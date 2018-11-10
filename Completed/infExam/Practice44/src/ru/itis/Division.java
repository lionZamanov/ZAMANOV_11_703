package ru.itis;

import java.util.ArrayList;
import java.util.List;

public class Division implements Army {
    private List<Legion> armyChilds = new ArrayList<>();

    @Override
    public void attack() {
        for (Legion legion : armyChilds) {
            legion.attack();
        }
    }

    public void add(Legion legion) {
        armyChilds.add(legion);
    }

    public void remove(Legion legion) {
        armyChilds.remove(legion);
    }
}
