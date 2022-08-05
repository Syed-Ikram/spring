package com.spring.annotation;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyApp {
    public static void main(String []args){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("annotationApplicationContext.xml");
        Coach theCoach = context.getBean("thatSillyCoach",Coach.class);
        System.out.println(theCoach.getDailyWorkout());
        System.out.println(theCoach.getDailyFortune());
        Coach theBatmintonCoach = context.getBean("batmintonCoach",Coach.class);
        System.out.println(theBatmintonCoach.getDailyWorkout());
        System.out.println(theBatmintonCoach.getDailyFortune());
        context.close();
    }
}
