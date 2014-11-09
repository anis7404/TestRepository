package com.paxotech.selenium.framework.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class HeatclinicApplication extends Page{

	private HomePage homePage;
	private LoginPage loginPage;
	private RegisterPage registerPage;
	
	public HeatclinicApplication(WebDriver driver) {
		super(driver);
	}

	
	public HomePage homePage(){
		if(homePage == null){
			homePage = new HomePage(driver);
		}
		return homePage;
	}
	
	public LoginPage loginPage(){
		if(loginPage == null){
			loginPage = new LoginPage(driver);
			PageFactory.initElements(driver, loginPage);
		}
		return loginPage;
	}
	
	public RegisterPage registerPage(){
		if(registerPage == null){
			registerPage = new RegisterPage(driver);
			PageFactory.initElements(driver, registerPage);
		}
		return registerPage;
	}
}
