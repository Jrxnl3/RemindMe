package de.jinx.remindMe;

import de.jinx.remindMe.UI.ReminderController;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.awt.*;

public class Main extends Application {

    public static ReminderController controller;
    private static TrayIcon trayIcon;
    private static SystemTray tray;

    @Override
    public void start(Stage primaryStage) throws Exception{

        //Tray + Notification
        tray = SystemTray.getSystemTray();
        Image image = Toolkit.getDefaultToolkit().createImage(getClass().getResource("assets/RemindMeIcon.png"));
        trayIcon = new TrayIcon(image, "RemindMe");
        trayIcon.setImageAutoSize(true);
        trayIcon.setToolTip("RemindMe Application");
        tray.add(trayIcon);


        //Szenen Laden
        FXMLLoader loader = new FXMLLoader(getClass().getResource("UI/remindWindow.fxml"));
        Parent root = loader.load();
        primaryStage.setTitle("Reminde Me");
        primaryStage.setScene(new Scene(root, 400, 400));
        primaryStage.show();

        controller = loader.getController();
    }
    @Override
    public void stop() {
        tray.remove(trayIcon);
        Platform.exit();
    }

    public static void displayMessage(String header,String text){
        trayIcon.displayMessage(header, text, TrayIcon.MessageType.INFO);
    }
}
