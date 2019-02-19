package ru.itis.controllers;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.animation.TimelineBuilder;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.scene.transform.Rotate;
import javafx.util.Duration;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Controller {

    @FXML
    private Label helloLabel;

    @FXML
    private Button buttonHello;

    @FXML
    private GridPane gridPane;

    @FXML
    private ImageView muzzle1;

    @FXML
    public void initialize() {
        gridPane.setOnMouseMoved(event -> {
            double ax = event.getX() - muzzle1.getLayoutX();
            double ay = event.getY() - (muzzle1.getLayoutY() + muzzle1.getFitHeight() / 4);
            double bx = 10;
            double by = 0;
            double cos = (ax * bx + ay * by) / (Math.sqrt(ax * ax + ay * ay) * Math.sqrt(bx * bx + by * by));
            double angle = 180 * Math.acos(cos) / Math.PI;
            muzzle1.getTransforms().setAll(new Rotate(-angle, 0, 30));
        });
        gridPane.setOnMouseClicked((event) -> {
            Timeline tick = TimelineBuilder.create()
                    .keyFrames(
                            new KeyFrame(
                                    new Duration(100),
                                    t -> {
                                        Image image1 = null;
                                        try {
                                            image1 = new Image(new FileInputStream("resources/whizzbang.png"));
                                        } catch (FileNotFoundException e) {
                                            e.printStackTrace();
                                        }
                                        ImageView bang = new ImageView(image1);
                                        bang.setX(muzzle1.getLayoutX());
                                        bang.setY(muzzle1.getLayoutY());
                                    }
                            )
                    )
                    .cycleCount(Timeline.INDEFINITE)
                    .build();
            tick.play();
        });

    }

}
