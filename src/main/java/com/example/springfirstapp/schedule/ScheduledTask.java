package com.example.springfirstapp.schedule;

import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.text.SimpleDateFormat;
import java.util.Date;

@EnableScheduling
public class ScheduledTask {
    @Scheduled(fixedRate = 5000)
    public void showCurrentTime() {
        System.out.println(new SimpleDateFormat("hh : mm : ss").format(new Date()));
    }

    @Scheduled(cron = "*/10 * * * * *")
    public void sayHello() {
        System.out.println("hello!");
    }
}
