package com.spring.demo;

import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements Coach{
    @Override
    public String getDailyWorkout() {
        return "Practice tennis ";
    }

    @Override
    public String getDailyFortune() {
        return "fortune";
    }
}
