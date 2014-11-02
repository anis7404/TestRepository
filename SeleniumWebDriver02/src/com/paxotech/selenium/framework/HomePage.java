package com.paxotech.selenium.framework;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
	
	protected WebDriver driver;
	
	public HomePage(WebDriver driver){
		this.driver = driver;
	}

	public void showLoginPage(){
		WebElement loginLink = driver.findElement(By.xpath("//*[@id='cart_info']/a[1]/span"));
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
