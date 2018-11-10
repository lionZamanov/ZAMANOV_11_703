package ru.itis;

public class Snake {
    private MoveBehavior moveBehavior;
    private SpeechBehavior speechBehavior;
    private int experience;

    public Snake(){
        moveBehavior = new CrawlBehavior();
        speechBehavior = new MuteSpeech();
        experience = 0;
    }
    public void performSay(){
        speechBehavior.say();
    }
    public void performMove(){
        moveBehavior.move();
    }

    public void getExp(int a){
        experience += a;
        if(experience >= 100){
            moveBehavior = new FlyBehavior();
            if(experience >= 200){
                speechBehavior = new Speech();
            }
        }
    }
}
