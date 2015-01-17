package com.paxovision.selenium.heatclinic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegisterPage extends Page{

	public RegisterPage(WebDriver driver) {
		super(driver);
	}
	
	private WebElement emailTextbox;
	private WebElement firstNameTextbox;
	private WebElement lastNameTextbox;
	private WebElement passwordTextbox;
	private WebElement confirmPasswordTextbox;
	private WebElement registerButton;
	
	public WebElement emailTextbox(){
		emailTextbox = driver.findElement(By.id("customer.emailAddress"));
		return emailTextbox;
	}
	
	public WebElement firstNameTextbox(){
		firstNameTextbox = driver.findElement(By.id("customer.firstName"));
		return firstNameTextbox;
	}
	
	public WebElement lastNameTextbox(){
		lastNameTextbox = driver.findElement(By.id("customer.lastName"));
		return lastNameTextbox;
	}

	public WebElement passwordTextbox(){
		passwordTextbox = driver.findElement(By.id("password"));
		return passwordTextbox;
	}
	
	public WebElement confirmPasswordTextbox(){
		confirmPasswordTextbox = driver.findElement(By.id("passwordConfirm"));
		return confirmPasswordTextbox;
	}
	
	public WebElement registerButton(){
		registerButton = driver.findElement(By.xpath("//*[@id='registrationForm']/div/input[@value='Register']"));
		return registerButton;
	}
	
	
	public void register(String email,String fName, String lName, String password, String confPassword){
		emailTextbox().sendKeys(email);
		firstNameTextbox().sendKeys(fName);
		lastNameTextbox().sendKeys(lName);
		passwordTextbox().sendKeys(password);
		confirmPasswordTextbox().sendKeys(confPassword);
		registerButton().click();
	}

}
