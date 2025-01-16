package com.example.springcoredemo.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springcoredemo.common.Coach;
import com.example.springcoredemo.common.TennisCoach;

@RestController
public class DemoRestController {
    private Coach myCoach;

    @Autowired
    public DemoRestController(@Qualifier("footballCoach") Coach theCoach) {
    this.myCoach = theCoach;
    }

    public void sampleMethodCall(Coach cc){
        cc.getDailyWorkout();
    }


    // Default home page controller 
    @GetMapping("/getCoach")
    public String getDailyCoach() {
        sampleMethodCall(new TennisCoach());
        return this.myCoach.getDailyWorkout();
    }
}
