package com.paxotech.selenium.framework.pageobject;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class HomePage {
	
	protected WebDriver driver;
	
	@FindBy(how=How.XPATH,using="//*[@id='cart_info']/a[1]/span")
	WebElement loginLink;
	
	
	public HomePage(WebDriver driver){
		this.driver = driver;
	}

	public void showLoginPage(){
		loginLink.click();
	}
	
	public boolean verifyLoginSuccess(String loginUser){
		
		WebElement loginUserElement = driver.findElement(By.xpath(".//*[@id='cart_info']/span/a"));
		
		if(loginUserElement != null){
			String text = loginUserElement.getText();
			assertEquals(loginUser, text);
			return true;
		}
		
		return false;
	}
}
