package com.spring.demo;
import java.lang.Math;

public class HappyFortuneService implements FortuneService{
    private String [] fortuneService={"Luckday","Bad Day","LuckiestDay"};
    private int r = (int) (Math.random()*3);
    public String getFortune(){
        return fortuneService[r];
    }
}
