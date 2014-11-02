package com.paxotech.selenium.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.paxotech.selenium.framework.ScriptBase1;

public class MyTest2 extends ScriptBase1{


	@Test
	public void positiveTestCase() {
		
		showLoginPage();
		login("iivaan@gmail.com", "ameera");
		verifyLoginSuccess("Iftekhar");
		
	}
	
	@Test
	public void negativeTestCase() {
		
		showLoginPage();
		login("iivaan@gmail.com", "simrohn");
		verifyLoginNotSuccess();	
	}
	
	
}
