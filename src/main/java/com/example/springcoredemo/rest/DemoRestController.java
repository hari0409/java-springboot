package com.example.springcoredemo.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springcoredemo.common.Coach;

@RestController
public class DemoRestController {
    private Coach myCoach;
    private Coach myAnotherCoach;

    @Autowired
    public DemoRestController(@Qualifier("cricketCoach") Coach theCoach, @Qualifier("cricketCoach") Coach anotherCoach) {
        System.out.println("In: " + getClass().getSimpleName());
        this.myCoach = theCoach;
        this.myAnotherCoach = anotherCoach;
    }

    // Default home page controller
    @GetMapping("/getCoach")
    public String getDailyCoach() {
        return "Are they form the same Bean: " + (myAnotherCoach == myCoach);
    }
}
