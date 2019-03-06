package ru.itis;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import ru.itis.socket.SocketClient;
import java.util.Scanner;

/**
 * 12.02.2019
 * ProgramClientStart
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class ProgramClientStart  extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("/test.fxml"));
        primaryStage.setTitle("Muzzle Battle");
        primaryStage.setScene(new Scene(root, 1500, 700));
        primaryStage.show();
    }
}
