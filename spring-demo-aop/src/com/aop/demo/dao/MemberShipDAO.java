package com.aop.demo.dao;

import org.springframework.stereotype.Component;

@Component
public class MemberShipDAO {

	public void addSillyMember() {
		
		System.out.println(getClass() + ": DOING MY WORK: ADDING A MEMBERSHIP ACCOUNT");
		
	}
	public void goToSleep(){
		System.out.println(getClass()+".going to sleep");
	}
}
