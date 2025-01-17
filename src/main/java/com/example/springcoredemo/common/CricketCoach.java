package com.example.springcoredemo.common;

import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Component
public class CricketCoach implements Coach {
    public CricketCoach() {
        System.out.println("In: " + getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout() {
        return "Practice Fast Bowling for 20 mins";
    }

    @PostConstruct
    public void init(){
        System.out.println("Called after the beans are initialised");
    }

    @PreDestroy
    public void destroy(){
        System.out.println("Called before the beans are destroyed");
    }

}