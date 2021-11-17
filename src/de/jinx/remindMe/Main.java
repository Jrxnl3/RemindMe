package de.jinx.remindMe;

import de.jinx.remindMe.UI.ReminderController;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    public static ReminderController controller;

    @Override
    public void start(Stage primaryStage) throws Exception{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("UI/remindWindow.fxml"));
        Parent root = loader.load();
        primaryStage.setTitle("Reminde Me");
        primaryStage.setScene(new Scene(root, 400, 400));
        primaryStage.show();
        controller = loader.getController();

    }
    @Override
    public void stop() {
        System.out.println("Stop");
        Platform.exit();
    }

}
