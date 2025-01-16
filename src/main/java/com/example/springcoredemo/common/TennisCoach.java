package com.example.springcoredemo.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy
public class TennisCoach implements Coach {

    @Autowired
    public TennisCoach() {
        System.out.println("In: " + getClass().getSimpleName());
    }

    public String getDailyWorkout() {
        return "Doing smtg idk";
    }
}
