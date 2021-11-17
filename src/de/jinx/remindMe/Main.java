package de.jinx.remindMe;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("UI/remindWindow.fxml"));
        primaryStage.setTitle("Reminde Me");
        primaryStage.setScene(new Scene(root, 400, 400));
        primaryStage.show();
    }
}
