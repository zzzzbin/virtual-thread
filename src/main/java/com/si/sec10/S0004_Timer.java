package com.si.sec10;

import java.util.Timer;
import java.util.TimerTask;

public class S0004_Timer {
    public static void main(String[] args) {
        var task = new TimerTask() {
            @Override
            public void run() {
                System.out.println("Hello World");
            }
        };
        var timer = new Timer();
        timer.scheduleAtFixedRate(task, 0, 2000);
    }
}
