package ru.itis.game;

import javax.swing.text.Element;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.transform.Rotate;

public class Muzzle {

    ImageView muzzle;
    ImageView whizzbang;
    double direction;
    double hp;

    public double getHp() {
        return hp;
    }

    public void setHp(double hp) {
        this.hp = hp;
    }

    ImageView getMuzzle() {
        return muzzle;
    }

    public ImageView getWhizzbang() {
        return whizzbang;
    }

    public double getDirection() {
        return direction;
    }

    public Muzzle(ImageView muzzle, ImageView whizzbang, double direction) {
        whizzbang.setVisible(false);
        this.muzzle = muzzle;
        this.whizzbang = whizzbang;
        this.direction = direction;
        this.hp = 100;
    }

    public Muzzle(double direction) {
        this.direction = direction;
        this.hp = 100;
    }

    public void subtractHp(int hp){
        this.hp -= hp;
    }
    public void transform(Rotate rotate) {
        muzzle.getTransforms().setAll(rotate);
    }

    public double getLayoutX() {
        return muzzle.getLayoutX();
    }

    public double getLayoutY() {
        return muzzle.getLayoutY();
    }

    public double getFitHeight() {
        return muzzle.getFitHeight();
    }
}
