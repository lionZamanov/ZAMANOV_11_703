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
    private ImageView muzzleImg1;

    @FXML
    private ImageView muzzleImg2;

    @FXML
    private ImageView whizzbang1;

    @FXML
    private ImageView whizzbang2;

    private Muzzle currentMuzzle;
    private Muzzle enemyMuzzle;

    @FXML
    public void initialize() {
        Muzzle muzzle1 = new Muzzle(muzzleImg1, whizzbang1, 1);
        Muzzle muzzle2 = new Muzzle(muzzleImg2, whizzbang2, -1);
        currentMuzzle = muzzle1;
        enemyMuzzle = muzzle2;
        gridPane.setOnMouseMoved(this::muzzleRotate);
        gridPane.setOnMouseClicked(this::shoot);
    }

    private void muzzleRotate(MouseEvent event) {
        //currentMuzzle.getTransforms().setAll(new Rotate(getAngle(event.getX(), event.getY(), currentMuzzle.getDirection()), 0, 30));
        currentMuzzle.transform(new Rotate(-getAngle(event.getX(), event.getY(), currentMuzzle.getDirection()), 0, 30));
    }

    private void shoot(MouseEvent event) {
        final double[] t = {0};
        currentMuzzle.getWhizzbang().setVisible(true);
        Engine engine = new Engine();
        Timeline timeline = new Timeline();
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.getKeyFrames().add(new KeyFrame(
                new Duration(10),
                s -> {
                    t[0] += 0.07;
                    double x0 = currentMuzzle.getWhizzbang().getLayoutX() - event.getX();
                    double y0 = currentMuzzle.getWhizzbang().getLayoutY() - event.getY();
                    double[] coord;
                    coord = engine.getCoordinatesByVector(Math.sqrt(x0 * x0 + y0 * y0), 0.3, 1, getAngle(event.getX(), event.getY(), currentMuzzle.getDirection()), t[0]);
                    currentMuzzle.getWhizzbang().setTranslateX(coord[0]);
                    if (t[0] > 15) {
                        currentMuzzle.getWhizzbang().setTranslateX(0);
                        currentMuzzle.getWhizzbang().setTranslateY(0);
                        Muzzle change = currentMuzzle;
                        currentMuzzle = enemyMuzzle;
                        enemyMuzzle = change;
                        t[0] = 0;
                        timeline.stop();
                    } else {
                        if (coord[1] > 0) {
                            currentMuzzle.getWhizzbang().setVisible(false);
                        } else {
                            currentMuzzle.getWhizzbang().setTranslateY(coord[1]);
                            currentMuzzle.getWhizzbang().getTransforms().add(new Rotate(3 * currentMuzzle.getDirection(), 20, 20));
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
