package de.jinx.remindMe.UI;

import de.jinx.remindMe.ThreadStuff.BackgroundTimer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class ReminderController implements Initializable {

    @FXML
    private TextArea note;

    @FXML
    private ChoiceBox<Integer> timer;

    @FXML
    private Button reminder;

    @FXML
    private TextField remainingTimer;

    private boolean isRunning;

    private BackgroundTimer backgroundTimer;

    @FXML
    void startReminder(ActionEvent event) {
        if(!isRunning) {
            backgroundTimer = new BackgroundTimer(timer.getValue(), note, remainingTimer);
            backgroundTimer.start();
        }
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        timer.getItems().add(0,10);
        timer.getItems().add(0,15);
        timer.getItems().add(0,20);
        timer.getItems().add(0,25);
        timer.getItems().add(0,30);
        timer.getItems().add(0,45);
        timer.getItems().add(0,60);
    }

    public void setRemainingTime(String time) {
        remainingTimer.setText(time);
    }

    public void setRunning(boolean state){
        isRunning = state;
    }
}
