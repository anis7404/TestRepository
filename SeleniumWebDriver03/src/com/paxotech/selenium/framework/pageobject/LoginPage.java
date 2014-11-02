package com.paxotech.selenium.framework.pageobject;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	protected WebDriver driver;
	
	@FindBy(how=How.NAME,using="j_username")
	WebElement emailAddressElement;
	
	@FindBy(how=How.NAME,using="j_password")
	WebElement passwordElement;
	
	@FindBy(how=How.XPATH,using="//*[@id='login']/div/form/div[3]/input")
	WebElement loginButton ;
	
	@FindBy(how=How.XPATH,using="//*[@id='login']/span/p/span")
	WebElement errorMsg;
	
	
	public LoginPage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
	}
	
	public void login(String userid, String password){
		emailAddressElement.sendKeys(userid);
		passwordElement.sendKeys(password);
		loginButton.click();
	}
	
	public boolean verifyLoginNotSuccess(){

		String msg = errorMsg.getText();	
		assertEquals("The e-mail address and/or password entered do not match our records. Please try again", msg);
		return true;	
		
	}
}
