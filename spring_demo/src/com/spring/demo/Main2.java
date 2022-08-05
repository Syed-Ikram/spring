package com.spring.demo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main2 {
    public static void main(String []args){
        ClassPathXmlApplicationContext context= new ClassPathXmlApplicationContext("applicationContext2.xml");
        Coach theCoach = context.getBean("tennisCoach",Coach.class);
        System.out.println(theCoach);
        Coach theAlphaCoach = context.getBean("tennisCoach",Coach.class);
        System.out.println(theAlphaCoach);
        boolean check =(theCoach==theAlphaCoach);
        System.out.println(check);

        context.close();
    }
}
