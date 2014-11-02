package com.paxotech.selenium.test;

import org.junit.Test;

import com.paxotech.selenium.framework.HomePage;
import com.paxotech.selenium.framework.LoginPage;
import com.paxotech.selenium.framework.ScriptBase2;

public class MyTest3 extends ScriptBase2{

	private HomePage homePage;
	private LoginPage loginPage;
	
	
	@Test
	public void positiveTestCase() {
		homePage = new HomePage(driver);
		loginPage = new LoginPage(driver);
		
		homePage.showLoginPage();
		loginPage.login("iivaan@gmail.com", "ameera");
		homePage.verifyLoginSuccess("Iftekhar");
		
	}
	
	@Test
	public void negativeTestCase() {
		homePage = new HomePage(driver);
		loginPage = new LoginPage(driver);
		
		homePage.showLoginPage();
		loginPage.login("iivaan@gmail.com", "simrohn");
		loginPage.verifyLoginNotSuccess();	
	}
}
