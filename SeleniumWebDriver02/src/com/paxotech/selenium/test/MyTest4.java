package com.paxotech.selenium.test;

import org.junit.Test;

import com.paxotech.selenium.framework.HomePage;
import com.paxotech.selenium.framework.LoginPage;
import com.paxotech.selenium.framework.ScriptBase3;

public class MyTest4 extends ScriptBase3{

	@Test
	public void positiveTestCase() {
		homePage().showLoginPage();
		loginPage().login("iivaan@gmail.com", "ameera");
		homePage().verifyLoginSuccess("Iftekhar");	
	}
	
	@Test
	public void negativeTestCase() {
		homePage().showLoginPage();
		loginPage().login("iivaan@gmail.com", "simrohn");
		loginPage().verifyLoginNotSuccess();	
	}
}
