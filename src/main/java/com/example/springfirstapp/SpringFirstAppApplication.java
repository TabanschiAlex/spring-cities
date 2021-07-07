package com.example.springfirstapp;

import com.example.springfirstapp.schedule.ScheduledTask;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringFirstAppApplication {
    public static void main(String[] args) {
        SpringApplication.run(new Class[]{SpringFirstAppApplication.class, ScheduledTask.class}, args);
    }
}