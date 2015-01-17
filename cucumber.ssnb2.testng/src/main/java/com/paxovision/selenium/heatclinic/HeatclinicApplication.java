package com.paxovision.selenium.heatclinic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class HeatclinicApplication extends Page{

	private HomePage homePage;
	private LoginPage loginPage;
	private RegisterPage registerPage;
	private CartPage cartPage;
	private CheckoutPage checkoutPage;
	
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
	
	public CartPage cart(){
		if(cartPage == null){
			cartPage = new CartPage(driver);
			PageFactory.initElements(driver, cartPage);
		}
		return cartPage;
	}
	
	public CheckoutPage checkoutPage(){
		if(checkoutPage == null){
			checkoutPage = new CheckoutPage(driver);
			PageFactory.initElements(driver, checkoutPage);
		}
		return checkoutPage;
	}
}
