package com.spring.demo;

public class BasketballCoach implements Coach {
    private FortuneService fortuneService;
    public BasketballCoach(FortuneService theFortuneService){
        this.fortuneService= theFortuneService;
    }
    public String getDailyWorkout(){
        return "shoot free throws";
    }
    public String getDailyFortune(){
        return fortuneService.getFortune();
    }
}
