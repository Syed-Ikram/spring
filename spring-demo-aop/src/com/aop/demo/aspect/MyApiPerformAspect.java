package com.aop.demo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(3)
public class MyApiPerformAspect {
    @Before("com.aop.demo.aspect.AopExpressions.forDaoNoGetterAndSetter()")
    public void perfomApiAnalytics(){
        System.out.println("\nperforming API Analytics");
    }
}
