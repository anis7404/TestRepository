package com.paxotech.selenium.framework.model;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPageModel extends ModeBase {


	@FindBy(how=How.NAME,using="j_username")
	WebElement emailAddressElement;
	
	@FindBy(how=How.NAME,using="j_password")
	WebElement passwordElement;
	
	@FindBy(how=How.XPATH,using="//*[@id='login']/div/form/div[3]/input")
	WebElement loginButton ;
	
	@FindBy(how=How.XPATH,using="//*[@id='login']/span/p/span")
	WebElement errorMsg;
	
	
	public LoginPageModel(WebDriver driver){
		super(driver);
		PageFactory.initElements(this.driver, this);
	}


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
	
	
	
}
