package com.spring.annotation;

import org.springframework.stereotype.Component;

@Component
public class RandomFortuneService implements FortuneService {
    private String [] fortuneService={"Luckday","Bad Day","LuckiestDay"};
    private int r = (int) (Math.random()*3);
    @Override
    public String getFortune(){
        return fortuneService[r];
    }
}
