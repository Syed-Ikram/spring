package com.spring.annotation;

import com.spring.annotation.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class BatmintonCoach implements Coach {
    private FortuneService fortuneService;
    @Autowired
    @Qualifier("happyFortuneService")
    public void setFortuneService(FortuneService theFortuneService){
        this.fortuneService = theFortuneService;
    }
    @Override
    public String getDailyWorkout() {
        return "practice backhand shots";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }
    @PostConstruct
    public void doMyStartUpStuff(){
        System.out.println("Batminton: Start up");
    }
    @PreDestroy
    public void doMyCleanUpStuff(){
        System.out.println("Batminton: clean up");
    }
}
