package com.paxotech.selenium.framework;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

import com.paxotech.selenium.framework.pageobject.HomePage;
import com.paxotech.selenium.framework.pageobject.LoginPage;

public class ScriptBase3 {

	protected WebDriver driver ;
	
	private HomePage homePage;
	private LoginPage loginPage;
	
	
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
	
	
	public HomePage homePage(){
		if(homePage == null){
			homePage = new HomePage(driver);
			PageFactory.initElements(driver, homePage);
		}
		return homePage;
	}
	
	public LoginPage loginPage(){
		if(loginPage == null){
			loginPage = new LoginPage(driver);
		}
		return loginPage;
	}
	
	
}
