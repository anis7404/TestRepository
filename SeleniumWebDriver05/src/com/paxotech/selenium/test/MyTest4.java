package com.paxotech.selenium.test;

import org.junit.Test;
import org.openqa.selenium.WebElement;

import com.paxotech.selenium.framework.ScriptBase;
import com.sun.org.apache.xml.internal.security.utils.HelperNodeList;

public class MyTest4 extends ScriptBase{

	@Test
	public void positiveTestCase() {
		heatClinic().homePage().clickLoginLink();
		heatClinic().loginPage().login("iivaan@gmail.com", "ameera");
		heatClinic().homePage().verifyLoginSuccess("Iftekhar");	
	}
	
	
	

	@Test
	public void negativeTestCase() {
		heatClinic().homePage().clickLoginLink();
		heatClinic().loginPage().login("iivaan@gmail.com", "notvalidpassword");
		heatClinic().loginPage().verifyLoginNotSuccess();
	}
	

	@Test
	public void negativeTestCase2() {
		
		heatClinic().homePage().clickLoginLink();
		heatClinic().loginPage().login("notvalid@gmail.com", "ameera");
		heatClinic().loginPage().verifyLoginNotSuccess();
	}
	
	@Test
	public void registerUser() {
		
		heatClinic().homePage().clickRegisterLink();
		heatClinic().registerPage().register("iivaan1@gamil.com", "Iftekhar", "Ivaan", "123456", "123456");
	}
	
	@Test
	public void addToCart() {
		
		//heatClinic().homePage().addToCart("Day of the Dead Scotch Bonnet Hot Sauce");
		heatClinic().homePage().addToCartEx("Hoppin' Hot Sauce");
	}
}
