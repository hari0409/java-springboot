package com.example.springcoredemo.common;

import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements Coach {

    public TennisCoach() {
        System.out.println("In: " + getClass().getSimpleName());
    }

    public String getDailyWorkout() {
        return "Doing smtg idk";
    }
}
