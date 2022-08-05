package com.spring.annotation;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class JavaConfigApp {
        public static void main(String []args){
            AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SportsConfig.class);
            SwimCoach theCoach = context.getBean("swimCoach",SwimCoach.class);
            System.out.println(theCoach.getDailyWorkout());
            System.out.println(theCoach.getDailyFortune());
            System.out.println(theCoach.getEmail());
            System.out.println(theCoach.getTeam());
            context.close();
       }
}

