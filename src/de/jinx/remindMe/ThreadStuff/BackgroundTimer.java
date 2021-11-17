package de.jinx.remindMe.ThreadStuff;

import javafx.scene.control.TextArea;
import java.util.Timer;
import java.util.TimerTask;

public class BackgroundTimer extends Thread{

    TextArea textArea;
    int time;

    public BackgroundTimer(int time, TextArea textArea){
        this.time = time;
        this.textArea = textArea;
    }

    @Override
    public void run() {
        textArea.setEditable(false);
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {

            public void run() {
                synchronized (this) {
                    if (time > 0) {
                        time--;
                        System.out.println("Count: " + time);
                    } else {
                        System.out.println(textArea.getText());
                        textArea.setEditable(true);
                        timer.cancel();
                    }
                }
            }
        }, 0, 1000L);

    }
}
