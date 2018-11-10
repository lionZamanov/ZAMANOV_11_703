package ru.itis;

public class MuteSpeech implements SpeechBehavior {
    @Override
    public void say() {
        System.out.println("ssshsshshsh");
    }
}
