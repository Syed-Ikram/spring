package com.aop.demo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class AopExpressions {
    @Pointcut("execution(* com.aop.demo.dao.*.*(..))")
    public void forDaoPackage(){}

    @Pointcut("execution(* com.aop.demo.dao.*.get*(..))")
    public void getter(){}

    @Pointcut("execution(* com.aop.demo.dao.*.set*(..))")
    public void setter(){}

    @Pointcut("forDaoPackage() && !(getter() || setter())")
    public void forDaoNoGetterAndSetter(){}
}
