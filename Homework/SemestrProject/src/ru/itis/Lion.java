package ru.itis;

public class Lion {
    public String area;
    public String sex;
    public int age;
    public int pawCounter;

    public Lion() {
        this("default", "default", 0, 4);
    }

    public Lion(String area, String sex, int age, int pawCounter) {

        this.area = area;
        this.sex = sex;
        this.age = age;
        this.pawCounter = pawCounter;
    }
}
