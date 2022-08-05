package com.aop.demo;

import com.aop.demo.dao.AccountDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class AfterReturnDemoApp {

	public static void main(String[] args) {

		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(DemoConfig.class);
		AccountDAO theAccountDAO = context.getBean("accountDAO", AccountDAO.class);

		List<Account> theAccounts = theAccountDAO.findAccounts(false);
		System.out.println("\n in Main Program:After Returning\n --------");
		System.out.println(theAccounts);
		System.out.println("\n");

		context.close();
	}

}










