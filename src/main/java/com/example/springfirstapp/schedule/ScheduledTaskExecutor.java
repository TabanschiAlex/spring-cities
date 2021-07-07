package com.example.springfirstapp.schedule;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Component
public class ScheduledTaskExecutor implements CommandLineRunner {
    private final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

    @Override
    public void run(String... args) {
        scheduler.scheduleAtFixedRate(this::sayHi, 5, 5, TimeUnit.SECONDS);
    }

    public void sayHi() {
        System.out.println("Hi");
    }
}
