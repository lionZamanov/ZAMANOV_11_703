package ru.itis;

import javax.swing.text.Element;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.transform.Rotate;

public class Muzzle {

    ImageView muzzle;
    ImageView whizzbang;
    double direction;

    public ImageView getMuzzle() {
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
    }

    public void transform(Rotate rotate){
        muzzle.getTransforms().setAll(rotate);
    }

    public double getLayoutX(){
        return muzzle.getLayoutX();
    }

    public double getLayoutY(){
        return muzzle.getLayoutY();
    }

    public double getFitHeight(){
        return muzzle.getFitHeight();
    }
}
