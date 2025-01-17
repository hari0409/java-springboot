package com.example.springcoredemo.common;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwimConfig {
    @Bean("SwimmingCoach")
    public SwimCoach swimCoach() {
        return new SwimCoach();
    }
}
