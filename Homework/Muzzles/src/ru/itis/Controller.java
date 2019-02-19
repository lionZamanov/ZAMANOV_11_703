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
    private ImageView whizzbang1;

    @FXML
    private ImageView whizzbang2;

    private ImageView currentWhizzbang;
    private ImageView currentMuzzle;
    private ImageView enemyMuzzle;

    @FXML
    public void initialize() {
        currentMuzzle = muzzle1;
        enemyMuzzle = muzzle2;
        currentWhizzbang = whizzbang1;
        gridPane.setOnMouseMoved(this::muzzleRotate);
        gridPane.setOnMouseClicked(this::shoot);
    }

    private void muzzleRotate(MouseEvent event) {
        if (currentMuzzle == muzzle1) {
            currentMuzzle.getTransforms().setAll(new Rotate(-getAngle(event.getX(), event.getY(), 10), 0, 30));
        } else {
            currentMuzzle.getTransforms().setAll(new Rotate(180-getAngle(event.getX(), event.getY(), -10), 0, 30));
        }
    }

    private void shoot(MouseEvent event) {
        final double[] t = {0};
        final double[] dropped = {0};
        Engine engine = new Engine();
        Timeline timeline = new Timeline();
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.getKeyFrames().add(new KeyFrame(
                new Duration(10),
                s -> {
                    t[0] += 0.07;
                    double x0 = currentWhizzbang.getLayoutX() - event.getX();
                    double y0 = currentWhizzbang.getLayoutY() - event.getY();
                    double[] coord;
                    if (currentWhizzbang == whizzbang1) {
                        coord = engine.getCoordinatesByVector(Math.sqrt(x0 * x0 + y0 * y0), 0.3, 1, getAngle(event.getX(), event.getY(), 10), t[0]);
                    } else {
                        coord = engine.getCoordinatesByVector(Math.sqrt(x0 * x0 + y0 * y0), 0.3, 1, getAngle(event.getX(), event.getY(), -10), t[0]);
                    }
                    currentWhizzbang.setTranslateX(coord[0]);
                    if (t[0] > 15) {
                        ImageView change = currentMuzzle;
                        currentMuzzle = enemyMuzzle;
                        enemyMuzzle = change;
                        currentWhizzbang.setTranslateX(0);
                        currentWhizzbang.setTranslateY(0);
                        currentWhizzbang = currentWhizzbang == whizzbang2 ? whizzbang1 : whizzbang2;
                        t[0] = 0;
                        timeline.stop();
                    } else {
                        if (coord[1] > 10) {
                            dropped[0] += 0.01;
                            currentWhizzbang.getTransforms().add(new Rotate(1 / (dropped[0] * 3), 20, 20));
                        } else {
                            currentWhizzbang.setTranslateY(coord[1]);
                            currentWhizzbang.getTransforms().add(new Rotate(3, 20, 20));
                        }
                    }
                }
        ));
        timeline.play();
    }

    private double getAngle(double x, double y, double vector) {
        double angle;
        double ax = Math.abs(x - currentMuzzle.getLayoutX());
        double ay = Math.abs(y - (currentMuzzle.getLayoutY() + currentMuzzle.getFitHeight() / 4));
        double bx = vector;
        double by = 0;
        double cos = (ax * bx + ay * by) / (Math.sqrt(ax * ax + ay * ay) * Math.sqrt(bx * bx + by * by));
        angle = 180 * Math.acos(cos) / Math.PI;
        helloLabel.setText(angle + "");
        return angle;
    }


}
