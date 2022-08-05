package com.spring.demo;

public class TrackCoach implements Coach{
    private FortuneService fortuneService;
    public TrackCoach(FortuneService theFortuneService){
        this.fortuneService=theFortuneService;
    }
    @Override
    public String getDailyWorkout() {
        return "Run hard 5k";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }
}
