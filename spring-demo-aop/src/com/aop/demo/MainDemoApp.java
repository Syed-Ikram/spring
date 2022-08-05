package com.aop.demo;

import com.aop.demo.dao.MemberShipDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.aop.demo.dao.AccountDAO;

public class MainDemoApp {

	public static void main(String[] args) {

		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(DemoConfig.class);
		AccountDAO theAccountDAO = context.getBean("accountDAO", AccountDAO.class);
		Account theAccount = new Account();
		theAccount.setName("john");
		theAccount.setLevel("gold");
		theAccountDAO.addAccount(theAccount,true);
		theAccountDAO.doWork();

		theAccountDAO.setName("foobar");
		theAccountDAO.setServiceCode("silver");
		String name = theAccountDAO.getName();
		String code = theAccountDAO.getServiceCode();

		MemberShipDAO theMemberShipDAO = context.getBean("memberShipDAO",MemberShipDAO.class);
		theMemberShipDAO.addSillyMember();
		theMemberShipDAO.goToSleep();
		context.close();
	}

}










