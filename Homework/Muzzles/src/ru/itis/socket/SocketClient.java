package ru.itis.socket;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.transform.Rotate;
import javafx.util.Duration;
import ru.itis.game.Engine;
import ru.itis.game.Muzzle;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class SocketClient {
    // поле, содержащее сокет-клиента
    private Socket clientSocket;
    private PrintWriter out;
    private BufferedReader in;
    private int id;

    @FXML
    private Label windLabel;

    @FXML
    private Label hpLabel1;

    @FXML
    private Label hpLabel2;

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
    private Muzzle muzzle1;
    private Muzzle muzzle2;
    private boolean locked;

    @FXML
    public void initialize() {
        muzzle1 = new Muzzle(muzzleImg1, whizzbang1, 1);
        muzzle2 = new Muzzle(muzzleImg2, whizzbang2, -1);
        gridPane.setOnMouseMoved(this::rotate);
        startConnection("127.0.0.1", 6666);
        gridPane.setOnMouseClicked(this::shoot);
        //gridPane.setOnMouseClicked(this::shoot);
    }

    private void shoot(MouseEvent event) {
        if (!locked) {
            currentMuzzle.getWhizzbang().setVisible(true);
            double x0 = currentMuzzle.getWhizzbang().getLayoutX() - event.getX();
            double y0 = currentMuzzle.getWhizzbang().getLayoutY() - event.getY();
            out.println(id + " shootParams " + Math.sqrt(x0 * x0 + y0 * y0) + " " + getAngle(event.getX(), event.getY(), currentMuzzle.getDirection()));
        }
    }

    public void rotate(MouseEvent event) {
        //out.println(id + " rotate " + event.getX() + " " + event.getY());
        muzzleRotate(event.getX(), event.getY(), currentMuzzle);
    }


    private void muzzleRotate(double x, double y, Muzzle muzzle) {
        muzzle.transform(new Rotate(-getAngle(x, y, muzzle.getDirection()), 0, 30));
    }

    private double getAngle(double x, double y, double vector) {
        double angle;
        double ax = Math.abs(x - currentMuzzle.getLayoutX());
        double ay = Math.abs(y - (currentMuzzle.getLayoutY() + currentMuzzle.getFitHeight() / 4));
        double bx = vector;
        double by = 0;
        double cos = (ax * bx + ay * by) / (Math.sqrt(ax * ax + ay * ay) * Math.sqrt(bx * bx + by * by));
        angle = 180 * Math.acos(cos) / Math.PI;
        return angle;
    }

    private Runnable receiverMessagesTask = new Runnable() {
        @Override
        public void run() {
            while (true) {
                try {
                    String response = in.readLine();
                    if (response != null) {
                        // id 0 rotate 25 12
                        // id 1 shootParams 124 513
                        // id 0 whizzbangCoordinates 52 12
                        // setId 0
                        // windResist 0.54
                        // id 0 invisible
                        // id 1 hp 80
                        String responseArray[] = response.split(" ");
                        if (responseArray[0].equals("setId")) {
                            id = Integer.valueOf(responseArray[1]);
                            if (responseArray[1].equals("0")) {
                                currentMuzzle = muzzle1;
                                enemyMuzzle = muzzle2;
                            } else {
                                currentMuzzle = muzzle2;
                                enemyMuzzle = muzzle1;
                            }
                        } else if (responseArray[0].equals("windResist")) {
                            windLabel.setText("Сопротивление ветра: " + responseArray[1]);
                        } else if (responseArray[2].equals("hp")) {
                            if(responseArray[1].equals("0")){
                                hpLabel1.setText("Player1: " + responseArray[3]);
                            }else{
                                hpLabel2.setText("Player2: " + responseArray[3]);
                            }
                        } else if (responseArray[2].equals("isVisible")) {
                            if(responseArray[1].equals("0")){
                                currentMuzzle.getWhizzbang().setVisible(false);
                            }else{
                                enemyMuzzle.getWhizzbang().setVisible(false);
                            }
                        } else if (responseArray[2].equals("rotate")) {
                            muzzleRotate(Double.parseDouble(responseArray[3]), Double.parseDouble(responseArray[4]), enemyMuzzle);
                        } else if (responseArray[2].equals("whizzbangCoordinates")) {
                            if (responseArray[1].equals(String.valueOf(id))) {
                                currentMuzzle.getWhizzbang().setTranslateX(Integer.parseInt(responseArray[3]));
                                currentMuzzle.getWhizzbang().setTranslateY(Integer.parseInt(responseArray[4]));
                            } else {
                                enemyMuzzle.getWhizzbang().setTranslateX(Integer.parseInt(responseArray[3]));
                                enemyMuzzle.getWhizzbang().setTranslateY(Integer.parseInt(responseArray[4]));
                            }
                        }
                        System.out.println(response);
                    }
                } catch (IOException e) {
                    throw new IllegalStateException(e);
                }
            }
        }
    };


    public void stopConnection() {
        try {
            in.close();
            out.close();
            clientSocket.close();
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }

    // начало сессии - получаем ip-сервера и его порт
    public void startConnection(String ip, int port) {
        try {
            // создаем подключение
            clientSocket = new Socket(ip, port);
            // получили выходной поток
            out = new PrintWriter(clientSocket.getOutputStream(), true);
            // входной поток
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            // запустили слушателя сообщений
            new Thread(receiverMessagesTask).start();
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }
}
