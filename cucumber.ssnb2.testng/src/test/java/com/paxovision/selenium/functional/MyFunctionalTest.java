package com.paxovision.selenium.functional;

import org.testng.annotations.Test;

import com.paxovision.selenium.ScriptBase;

public class MyFunctionalTest  extends ScriptBase{

	@Test
	public void validUserValidPassword() {
			heatClinic().homePage().clickLoginLink();
			heatClinic().loginPage().login("iivaan@gmail.com", "ameera");
			heatClinic().homePage().verifyLoginSuccess("Iftekhar");	
			heatClinic().homePage().clickLogoutLink();	
			
	}
}
