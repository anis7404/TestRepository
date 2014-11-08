package com.paxotech.selenium.framework.model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePageModel extends ModeBase{
	

	private WebElement loginLink;
	private WebElement loginUserElement ;
	
	
	
	public HomePageModel(WebDriver driver){
		super(driver);
	}

	
	public WebElement loginLink(){
		delayFor(2000);
		loginLink = driver.findElement(By.xpath("//*[@id='cart_info']/a[1]/span"));
		return loginLink;
	}
	
	public WebElement loginUserElement(){

		loginUserElement = driver.findElement(By.xpath(".//*[@id='cart_info']/span/a"));
	
		return loginUserElement;
	}
	
	
	
	
	
	
	
	
	
	/*
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
	}*/
}
