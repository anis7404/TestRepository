package com.paxotech.selenium.framework.controller;

import org.openqa.selenium.WebDriver;

public class ApplicationController {

	private WebDriver driver;
	
	private HomePageController homePage;
	private LoginPageController loginPage;
	
	
	
	public ApplicationController(WebDriver driver){
		this.driver = driver;
	}
	
	
	
	public HomePageController homePage(){
		if(homePage == null){
			homePage = new HomePageController(driver);
		}
		return homePage;
	}
	
	public LoginPageController loginPage(){
		if(loginPage == null){
			loginPage = new LoginPageController(driver);
		}
		return loginPage;
	}
}
