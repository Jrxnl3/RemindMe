package de.jinx.remindMe.ThreadStuff;

import de.jinx.remindMe.Main;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.util.Timer;
import java.util.TimerTask;

public class BackgroundTimer extends Thread{

    TextArea textArea;
    TextField remainingTextField;
    int time;


    public BackgroundTimer(int time, TextArea textArea, TextField remainingTextField){
        this.time = time;
        this.textArea = textArea;
        this.remainingTextField = remainingTextField;
    }

    @Override
    public void run() {
        textArea.setEditable(false);
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {

            public void run() {
                if (time > 0) {
                    time--;
                    Main.controller.setRemainingTime(time + " minuten");
                    Main.controller.setRunning(true);

                } else {

                    System.out.println(textArea.getText());
                    textArea.setEditable(true);
                    Main.controller.setRemainingTime("Done!");
                    Main.controller.setRunning(false);

                    Main.displayMessage("Remind Me Counter!","The Counter is done! Don't forget it!");
                    timer.cancel();
                }
            }
        }, 0, 1000L); //TODO: Change 1000L to 10000L wegen Minuten nicht Sekunden
    }
}
