package com.example.springcoredemo.common;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy
public class FootballCoach implements Coach {

    public FootballCoach() {
        System.out.println("In: " + getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout() {
        return "Practise passing for 10 mins";
    }

}
