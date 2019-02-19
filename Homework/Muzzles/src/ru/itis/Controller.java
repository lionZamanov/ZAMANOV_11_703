package ru.itis;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.animation.TimelineBuilder;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.transform.Rotate;
import javafx.util.Duration;

public class Controller {

    @FXML
    private Label helloLabel;

    @FXML
    private GridPane gridPane;

    @FXML
    private ImageView muzzle1;

    @FXML
    private ImageView muzzle2;

    @FXML
    private ImageView whizzbang;

    private ImageView currentMuzzle;
    private ImageView enemyMuzzle;

    @FXML
    public void initialize() {
        currentMuzzle = muzzle1;
        enemyMuzzle = muzzle2;
        gridPane.setOnMouseMoved(this::muzzleRotate);
        gridPane.setOnMouseClicked(this::shoot);
    }

    private void muzzleRotate(MouseEvent event) {
        currentMuzzle.getTransforms().setAll(new Rotate(-getAngle(event.getX(), event.getY()), 0, 30));
    }

    private void shoot(MouseEvent event) {
        final double[] t = {0};
        final double[] dropped = {0};
        Engine engine = new Engine();
        Timeline tick = TimelineBuilder.create()
                .keyFrames(
                        new KeyFrame(
                                new Duration(10),
                                s -> {
                                    t[0] += 0.07;
                                    double x0 = currentMuzzle.getLayoutX() - event.getX();
                                    double y0 = currentMuzzle.getLayoutY() - event.getX();
                                    double[] coord = engine.getCoordinatesByVector(Math.sqrt(x0 * x0 + y0 * y0), 0.3, 1, getAngle(event.getX(), event.getY()), t[0]);
                                    currentMuzzle.setTranslateX(coord[0]);
                                    helloLabel.setText(coord[0] + " " + coord[1]);
                                    if (coord[1] > 10) {
                                        dropped[0] += 0.01;
                                        currentMuzzle.getTransforms().add(new Rotate(1 / (dropped[0] * 3), 20, 20));
                                    } else {
                                        currentMuzzle.setTranslateY(coord[1]);
                                        currentMuzzle.getTransforms().add(new Rotate(3, 20, 20));
                                    }
                                }
                        )
                )
                .cycleCount(Timeline.INDEFINITE)
                .build();
        tick.play();
        ImageView change = currentMuzzle;
        currentMuzzle = enemyMuzzle;
        enemyMuzzle = change;
    }

    private double getAngle(double x, double y) {
        final double[] angle = {0.0};
        double ax = x - currentMuzzle.getLayoutX();
        double ay = y - (currentMuzzle.getLayoutY() + currentMuzzle.getFitHeight() / 4);
        double bx = 10;
        double by = 0;
        double cos = (ax * bx + ay * by) / (Math.sqrt(ax * ax + ay * ay) * Math.sqrt(bx * bx + by * by));
        angle[0] = 180 * Math.acos(cos) / Math.PI;
        return angle[0];
    }


}
