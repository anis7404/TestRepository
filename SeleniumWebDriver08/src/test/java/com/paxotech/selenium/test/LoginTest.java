package com.paxotech.selenium.test;

import org.junit.Test;

import com.paxotech.selenium.framework.ScriptBase;
import com.paxotech.selenium.framework.util.Utils;


public class LoginTest extends ScriptBase{

	@Test
	public void validUserValidPassword() {
		heatClinic().homePage().clickLoginLink();
		heatClinic().loginPage().login("iivaan@gmail.com", "ameera");
		heatClinic().homePage().verifyLoginSuccess("Iftekhar");	
	}
	
	
	

	@Test
	public void validUserInvalidPassword() {
		heatClinic().homePage().clickLoginLink();
		heatClinic().loginPage().login("iivaan@gmail.com", "notvalidpassword");
		heatClinic().loginPage().verifyLoginNotSuccess();
		System.out.println(new Utils().takeScreenshot());
		
	}
	

	@Test
	public void invalidUserValidPassword() {
		
		heatClinic().homePage().clickLoginLink();
		heatClinic().loginPage().login("notvalid@gmail.com", "ameera");
		heatClinic().loginPage().verifyLoginNotSuccess("The e-mail address and/or password entered do not match our records. Please try again");
	}
	
	
	
	
	
}
