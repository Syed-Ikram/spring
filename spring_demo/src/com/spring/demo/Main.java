package com.spring.demo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        Coach theCoach=context.getBean("myCoach",Coach.class);
        System.out.println(theCoach.getDailyFortune());
        System.out.println(theCoach.getDailyWorkout());
        Coach theCoach2=context.getBean("myCoach",Coach.class);
        System.out.println(theCoach2.getDailyFortune());
        System.out.println(theCoach2.getDailyWorkout());
        boolean b = (theCoach == theCoach2);
        System.out.println("same or not = "+b);

        CricketCoach theCricketCoach=context.getBean("myCricketCoach",CricketCoach.class);
        System.out.println(theCricketCoach.getDailyFortune());
        System.out.println(theCricketCoach.getDailyWorkout());
        System.out.println(theCricketCoach.getEmailAddress());
        System.out.println(theCricketCoach.getTeam());
        context.close();
    }
}
