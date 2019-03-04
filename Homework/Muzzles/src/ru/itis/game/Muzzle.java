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

    double getHp() {
        return hp;
    }

    void setHp(double hp) {
        this.hp = hp;
    }

    ImageView getMuzzle() {
        return muzzle;
    }

    ImageView getWhizzbang() {
        return whizzbang;
    }

    double getDirection() {
        return direction;
    }

    Muzzle(ImageView muzzle, ImageView whizzbang, double direction) {
        whizzbang.setVisible(false);
        this.muzzle = muzzle;
        this.whizzbang = whizzbang;
        this.direction = direction;
        this.hp = 100;
    }

    void transform(Rotate rotate) {
        muzzle.getTransforms().setAll(rotate);
    }

    double getLayoutX() {
        return muzzle.getLayoutX();
    }

    double getLayoutY() {
        return muzzle.getLayoutY();
    }

    double getFitHeight() {
        return muzzle.getFitHeight();
    }
}
