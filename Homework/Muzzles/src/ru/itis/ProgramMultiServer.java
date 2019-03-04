package ru.itis;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import ru.itis.socket.MultiServer;

public class ProgramMultiServer extends Application {
    public static void main(String[] args) {
        MultiServer server = new MultiServer();
        launch(args);
        server.start(6666);
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("/test.fxml"));
        primaryStage.setTitle("Muzzle Battle");
        primaryStage.setScene(new Scene(root, 1500, 700));
        primaryStage.show();
    }

}
