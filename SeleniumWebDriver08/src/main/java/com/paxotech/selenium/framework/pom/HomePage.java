package com.paxotech.selenium.framework.pom;

import static org.junit.Assert.assertEquals;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends Page{

	private WebElement loginLink;
	private WebElement registerLink;
	private WebElement loginUserElement ;
	private WebElement buyNowButton;
	private WebElement productContainer;
	private WebElement cartLink;
	private WebElement notificationBarElement;
	
	
	public HomePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	public WebElement loginLink(){
		delayFor(2000);
		loginLink = driver.findElement(By.xpath("//*[@id='cart_info']/a[1]/span"));
		return loginLink;
	}
	
	public WebElement registerLink(){
		//registerLink = driver.findElement(By.xpath("//*[@id='cart_info']/a/span[text()='Register']"));
		registerLink = waitForElementDisplayed(By.xpath("//*[@id='cart_info']/a/span[text()='Register']"));
		
		return registerLink;
	}
	
	public WebElement loginUserElement(){

		loginUserElement = driver.findElement(By.xpath(".//*[@id='cart_info']/span/a"));
	
		return loginUserElement;
	}

	public  WebElement notificationBarElement(){
		notificationBarElement = waitForElement(By.id("notification_bar"));
		return notificationBarElement;
	}
	
	public WebElement buyNowButton(String productName){
		
		String xpath = "//ul[@id='products']//div[text()=\"" + productName + "\"]/../../div[contains(@class,'productActions')]//input[@class='addToCart']";
		System.out.println(xpath);
		buyNowButton = driver.findElement(By.xpath(xpath));
		return buyNowButton;
	}
	
	public WebElement productContainer(String productName){
		
		String xpath = "//ul[@id='products']//div[text()=\"" + productName+ "\"]/../..";
		System.out.println(xpath);
		productContainer = driver.findElement(By.xpath(xpath));
		return productContainer;
	}
	
	public WebElement cartLink(){
		cartLink = driver.findElement(By.id("cartLink"));
		
		return cartLink;
	}
	
	
	public void clickLoginLink(){
		loginLink().click();
	}
	
	public void clickRegisterLink(){
		registerLink().click();
	}
	
	public void clickCartLink(){
		cartLink().click();
	}
	
	public boolean verifyLoginSuccess(String loginUser){
		
		
		if(loginUserElement() != null){
			String text = loginUserElement() .getText();
			assertEquals(loginUser, text);
			return true;
		}
		
		return false;
	}
	
	public void addToCart(String productName){
		
		WebElement buElement = buyNowButton(productName);
		buElement.click();
		
		boolean notification  =  notificationBarElement().isDisplayed();
		System.out.println("Notification" + notification);
		delayFor(4000);
		
		boolean notification2  =  notificationBarElement().isDisplayed();
		System.out.println("Notification" + notification2);
		
	}
	
	public void addToCartEx(String productName){
		
		WebElement productCon = productContainer(productName);
		
		WebElement bn = productCon.findElement(By.xpath("//div[contains(@class,'productActions')]//input[@class='addToCart']"));
		//WebElement bn = productCon.findElement(By.className("addToCart"));
		bn.click();
		
		WebElement element =  waitForElementDisplayed(By.id("notification_bar"));
		boolean notification  = element.isDisplayed();
		System.out.println("Notification" + notification);
		System.out.println(element.getText());
		
		element =  waitForElementNotDisplayed(By.id("notification_bar"));
		Assert.assertNotNull(element);
		
	}
	
	
}
