package com.springdemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component
public class CRMLoggingAspect {
    private Logger myLogger = Logger.getLogger(getClass().getName());

    @Pointcut("execution(* com.springdemo.controller.*.*(..))")
    private void forControllerPackage(){}

    @Pointcut("execution(* com.springdemo.service.*.*(..))")
    private void forServicePackage(){}

    @Pointcut("execution(* com.springdemo.dao.*.*(..))")
    private void forDaoPackage(){}

    @Pointcut("forControllerPackage() || forServicePackage() || forDaoPackage()")
    private void forAppFlow(){}

    @Before("forAppFlow()")
    public void before(JoinPoint theJointPoint){
        String method = theJointPoint.getSignature().toShortString();
        myLogger.info("====> in Before : calling method is "+method);

        Object[] args = theJointPoint.getArgs();
        for(Object tempArg : args){
            myLogger.info("===> argument:"+tempArg);
        }

    }

    @AfterReturning(pointcut = "forAppFlow()",
                    returning = "theResult")
    public void afterReturning(JoinPoint theJointPoint, Object theResult){
        String method = theJointPoint.getSignature().toShortString();
        myLogger.info("====> in AfterReturning: method is "+method);

        myLogger.info("====> result: "+theResult);
    }


}
