package com.aop.demo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1)
public class MyCloudAsyncAspect {
    @Before("com.aop.demo.aspect.AopExpressions.forDaoNoGetterAndSetter()")
    public void logCloudAsync(){
        System.out.println("\nlogging to cloud");
    }
}
