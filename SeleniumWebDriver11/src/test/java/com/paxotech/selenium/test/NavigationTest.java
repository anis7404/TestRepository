package com.paxotech.selenium.test;

import org.testng.annotations.Test;

import com.paxotech.selenium.framework.ScriptBase;

public class NavigationTest extends ScriptBase{

	@Test
	public void faqTest(){
		
		heatClinic().homePage().clickOnFAQs();
		heatClinic().homePage().delayFor(8000);	
	}
}
