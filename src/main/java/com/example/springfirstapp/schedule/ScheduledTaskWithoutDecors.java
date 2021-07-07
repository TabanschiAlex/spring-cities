package com.example.springfirstapp.schedule;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

@Component
public class ScheduledTaskWithoutDecors implements CommandLineRunner {
    @Override
    public void run(String... args) {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("Time is :" + new Date());
            }
        }, 0, 5000);
    }
}
