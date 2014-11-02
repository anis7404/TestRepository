package com.paxotech.selenium.framework;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

protected WebDriver driver;
	
	public LoginPage(WebDriver driver){
		this.driver = driver;
	}
	
	public void login(String userid, String password){
		
		WebElement emailAddressElement = driver.findElement(By.name("j_username"));
		emailAddressElement.sendKeys(userid);
		
		WebElement passwordElement = driver.findElement(By.name("j_password"));
		passwordElement.sendKeys(password);
		
		WebElement loginButton = driver.findElement(By.xpath("//*[@id='login']/div/form/div[3]/input"));
		loginButton.click();
		
	}
	
	public boolean verifyLoginNotSuccess(){

		WebElement errorMsg = driver.findElement(By.xpath("//*[@id='login']/span/p/span"));
		String msg = errorMsg.getText();
		
		assertEquals("The e-mail address and/or password entered do not match our records. Please try again", msg);
		return true;	
		
	}
}
