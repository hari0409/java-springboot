package com.example.springcoredemo.common;

import org.springframework.stereotype.Component;

@Component
public class FootballCoach implements Coach {

    public FootballCoach() {
        System.out.println("In: " + getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout() {
        return "Practise passing for 10 mins";
    }

}
