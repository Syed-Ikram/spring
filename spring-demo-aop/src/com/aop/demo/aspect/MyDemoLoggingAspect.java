package com.aop.demo.aspect;

import com.aop.demo.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {
	@After("execution(* com.aop.demo.dao.AccountDAO.findAccounts(..))")
	public void afterFinallyFindAccountsAdivce(JoinPoint theJointPoint){
		String method = theJointPoint.getSignature().toShortString();
		System.out.println("\nMethod afterFinally:"+method);
	}
	@Before("com.aop.demo.aspect.AopExpressions.forDaoNoGetterAndSetter()")
	public void beforeAddAccountAdvice(JoinPoint theJoinPoint) {
		System.out.println("\nExecuting @Before advice on addAccount()");

		MethodSignature methodSig = (MethodSignature) theJoinPoint.getSignature();
		System.out.println("Method:"+methodSig);

		Object[] args= theJoinPoint.getArgs();

		for(Object tempArg: args){
			System.out.println(tempArg);
			if(tempArg instanceof Account){
				Account theAccount = (Account) tempArg;
				System.out.println("name:"+theAccount.getName());
				System.out.println("level:"+theAccount.getLevel());

			}
		}

	}

	@AfterReturning(pointcut = "execution(* com.aop.demo.dao.AccountDAO.findAccounts(..))",
				returning = "result")
	public void afterReturningFindAccountsAdvice(JoinPoint theJointPoint, List<Account> result){
		String method = theJointPoint.getSignature().toShortString();
		System.out.println("\nMethod afterReturn:"+method);
		System.out.println("\nResult is"+result);

		if(!result.isEmpty()){
			Account temp = result.get(0);
			temp.setName("Daffy Duck");
		}
	}
	@AfterThrowing(pointcut = "execution(* com.aop.demo.dao.AccountDAO.findAccounts(..))",
			throwing = "theExc")
	public void afterThrowingFindAccountsAdvice(JoinPoint theJointPoint, Throwable theExc){
		String method = theJointPoint.getSignature().toShortString();
		System.out.println("\nMethod afterThrow:"+method);
		System.out.println("\nException is:"+theExc);

	}
}










