package com.paxovision.selenium.heatclinic;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class LoginPage extends Page{


	public LoginPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
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
		highlightElement(emailAddressElement);
		return emailAddressElement;
	}


	public WebElement passwordElement() {
		highlightElement(passwordElement);
		return passwordElement;
	}


	public WebElement loginButton() {
		highlightElement(loginButton);
		return loginButton;
	}


	public WebElement errorMsg() {
		highlightElement(errorMsg);
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
		Assert.assertEquals("The e-mail address and/or password entered do not match our records. Please try again", msg);
		return true;	
		
	}
	public boolean verifyLoginNotSuccess(String expectedMsg){

		String msg = errorMsg().getText();	
		Assert.assertEquals(expectedMsg, msg);
		return true;	
		
	}
	
}	

