package com.paxotech.selenium.framework.pom;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends Page{


	public LoginPage(WebDriver driver) {
		super(driver);
		//PageFactory.initElements(driver, this);
	}
	
	
	//**************** Model ****************************
	@FindBy(how=How.NAME,using="j_username")
	WebElement emailAddressElement;
	
	@FindBy(how=How.NAME,using="j_password")
	WebElement passwordElement;
	
	@FindBy(how=How.XPATH,using="//*[@id='login']/div/form/div[3]/input")
	WebElement loginButton ;
	
	@FindBy(how=How.XPATH,using="//*[@id='login']/span/p/span")
	WebElement errorMsg;
	
	
	public WebElement emailAddressElement() {
		return emailAddressElement;
	}


	public WebElement passwordElement() {
		return passwordElement;
	}


	public WebElement loginButton() {
		return loginButton;
	}


	public WebElement errorMsg() {
		return errorMsg;
	}
	
	
	
	//*************** Controller ******************************
	public void login(String userid, String password){
		emailAddressElement().sendKeys(userid);
		passwordElement().sendKeys(password);
		loginButton().click();
		delayFor(2000);
	}
	
	public boolean verifyLoginNotSuccess(){

		String msg = errorMsg().getText();	
		assertEquals("The e-mail address and/or password entered do not match our records. Please try again", msg);
		return true;	
		
	}
	public boolean verifyLoginNotSuccess(String expectedMsg){

		String msg = errorMsg().getText();	
		assertEquals(expectedMsg, msg);
		return true;	
		
	}
	
}	

