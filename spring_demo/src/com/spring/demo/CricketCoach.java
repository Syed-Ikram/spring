package com.spring.demo;

public class CricketCoach implements Coach{
    private FortuneService fortuneService;
    private String emailAddress;
    private String team;
    public CricketCoach(){
        System.out.println("inside const");
    }
    @Override
    public String getDailyWorkout() {
        return "bowling practice";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }

    public void setFortuneService(FortuneService fortuneService) {
        System.out.println("inside setter");
        this.fortuneService = fortuneService;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public String getEmailAddress() {
        System.out.println("inside email ");
        return emailAddress;
    }

    public String getTeam() {
        System.out.println("inside setter team");
        return team;
    }
}
