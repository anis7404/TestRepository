package com.paxovision.selenium.heatclinic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;


public class CheckoutPage extends Page {

	public CheckoutPage(WebDriver driver) {
		super(driver);
	}
	
	private WebElement emailAddressTextbox;
	private WebElement checkOutAsGuestButton;
	private WebElement stateCombobox;
	
	public WebElement emailAddressTextbox(){
		emailAddressTextbox = waitForElementDisplayed(By.id("emailAddress"));
		return emailAddressTextbox;
	}
	
	public WebElement checkOutAsGuestButton(){
		checkOutAsGuestButton = waitForElementDisplayed(By.cssSelector(".submit-row .small.red"));
		return checkOutAsGuestButton;
	}
	
	public Select stateCombobox(){
		stateCombobox = waitForElementDisplayed(By.id("state"));	
		
		Select cmbBox = new Select(stateCombobox);
		
		return cmbBox;
	
	}
	
	
	public void checkOutAsGuest(String guestEmailAddress){
		
		emailAddressTextbox().sendKeys(guestEmailAddress);
		checkOutAsGuestButton().click();
	}
	
	public void billingInformation(String fName, String lName, 
								   String phone,String address1, 
								   String address2, String city, 
								   String state, String zipcode ){
		
		
		stateCombobox().selectByVisibleText(state);

		
		delayFor(10000);
		
	}
	

}
