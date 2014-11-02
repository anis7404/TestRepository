package com.paxotech.selenium.framework;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ScriptBase2 {

	protected WebDriver driver ;
	
	@Before
	public void setUp() throws Exception {
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.navigate().to("http://demo.broadleafcommerce.org/");
	}
	
	
	@After
	public void tearDown() throws Exception {
		driver.close();
	}
	
	
}
