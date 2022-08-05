package com.spring.annotation;

import com.spring.annotation.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("thatSillyCoach")
public class TennisCoach implements Coach {
    //@Autowired
    //@Qualifier("randomFortuneService")
    private FortuneService fortuneService;

    @Autowired
    public TennisCoach(@Qualifier("randomFortuneService") FortuneService theFortuneService){
        fortuneService = theFortuneService;
    }

    @Override
    public String getDailyWorkout() {
        return "Practice tennis ";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }
}
