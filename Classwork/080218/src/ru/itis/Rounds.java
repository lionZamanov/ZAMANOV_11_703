package ru.itis;

public class Rounds {
    public int scores;
    public int radius;

    public Rounds(){
        scores = 0;
        radius = 0;
    }
    public Rounds(int scores, int radius){
        this.scores = scores;
        this.radius = radius;
    }

    public boolean check(ShootCoordinates c){
        return c.x*c.x + c.y*c.y < radius*radius;
    }

    public void sort(Rounds[] r){
        for (int i = 0; i < r.length; i++) {
            for (int j = 0; j < r.length - 1; j++) {
                if(r[j + 1].radius <= r[j].radius){
                    Rounds round = r[j + 1];
                    r[j + 1] = r[j];
                    r[j] = round;
                }
            }
        }
    }
}
