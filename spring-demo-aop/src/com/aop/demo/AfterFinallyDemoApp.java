package com.aop.demo;

import com.aop.demo.dao.AccountDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class AfterFinallyDemoApp {

	public static void main(String[] args) {

		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(DemoConfig.class);
		AccountDAO theAccountDAO = context.getBean("accountDAO", AccountDAO.class);

		List<Account> theAccounts = null;
		try{
			boolean tripWire=true;
			theAccounts=theAccountDAO.findAccounts(tripWire);
		}
		catch (Exception theExc){
			System.out.println("Exception in catch Main:"+theExc);
		}
		System.out.println("\n in Main Program:After Returning\n --------");
		System.out.println(theAccounts);
		System.out.println("\n");

		context.close();
	}

}










