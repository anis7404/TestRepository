package com.paxotech.selenium.framework.controller;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.paxotech.selenium.framework.model.HomePageModel;

public class HomePageController extends ControllerBase{

	private HomePageModel homePageModel ;
	
	public HomePageController(WebDriver driver){
		super(driver);
		homePageModel = new HomePageModel(driver);
	}
	
	public void clickLoginLink(){
		homePageModel.loginLink().click();
	}
	
	public boolean verifyLoginSuccess(String loginUser){
		
		
		if(homePageModel.loginUserElement() != null){
			String text = homePageModel.loginUserElement() .getText();
			assertEquals(loginUser, text);
			return true;
		}
		
		return false;
	}
}
