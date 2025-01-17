package com.example.springcoredemo.common;

public class SwimCoach implements Coach {
    @Override
    public String getDailyWorkout() {
        return "100 meter in 2 mins";
    }
}
