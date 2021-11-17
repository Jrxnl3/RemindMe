package de.jinx.remindMe.UI;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class ReminderController {

    @FXML
    private TextArea note;

    @FXML
    private ChoiceBox<Integer> timer;

    @FXML
    private Button reminder;

    @FXML
    private TextField remainingTimer;

    @FXML
    void startReminder(ActionEvent event) {
        //Start Timer
    }

    @FXML
    public void initialize() {
        timer.getItems().add(0,10);
        timer.getItems().add(0,15);
        timer.getItems().add(0,20);
        timer.getItems().add(0,25);
        timer.getItems().add(0,30);
        timer.getItems().add(0,45);
        timer.getItems().add(0,60);
    }
}
