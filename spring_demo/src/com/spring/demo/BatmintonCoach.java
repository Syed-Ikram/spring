package com.spring.demo;

import org.springframework.stereotype.Component;

@Component
public class BatmintonCoach implements Coach{
    public void doMyStartUpStuff(){
        System.out.println("Batminton: Start up");
    }
    public void doMyCleanUpStuff(){
        System.out.println("Batminton: clean up");
    }
    @Override
    public String getDailyFortune() {
        return "no implementation";
    }

    @Override
    public String getDailyWorkout() {
        return "practice backhand shots";
    }
}
