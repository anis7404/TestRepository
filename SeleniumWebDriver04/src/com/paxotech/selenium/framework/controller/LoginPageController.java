package com.paxotech.selenium.framework.controller;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.WebDriver;

import com.paxotech.selenium.framework.model.LoginPageModel;

public class LoginPageController  extends ControllerBase{
	

	LoginPageModel loginPageModel;
	
	public LoginPageController(WebDriver driver){
		super(driver);
		loginPageModel = new LoginPageModel(driver);
	}

	

	public void login(String userid, String password){
		loginPageModel.emailAddressElement().sendKeys(userid);
		loginPageModel.passwordElement().sendKeys(password);
		loginPageModel.loginButton().click();
		delayFor(2000);
	}
	
	public boolean verifyLoginNotSuccess(){

		String msg = loginPageModel.errorMsg().getText();	
		assertEquals("The e-mail address and/or password entered do not match our records. Please try again", msg);
		return true;	
		
	}
}
