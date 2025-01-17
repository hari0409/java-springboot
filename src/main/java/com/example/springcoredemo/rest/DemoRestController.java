package com.example.springcoredemo.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springcoredemo.common.Coach;

@RestController
public class DemoRestController {
    private Coach myCoach;

    @Autowired
    public DemoRestController(@Qualifier("SwimmingCoach") Coach theCoach) {
        this.myCoach = theCoach;
    }

    // Default home page controller
    @GetMapping("/getCoach")
    public String getDailyCoach() {
        return myCoach.getDailyWorkout();
    }
}
