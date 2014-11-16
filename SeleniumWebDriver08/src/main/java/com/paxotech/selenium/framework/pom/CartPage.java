package com.paxotech.selenium.framework.pom;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CartPage extends Page{

	public CartPage(WebDriver driver) {
		super(driver);
	}
	
	private WebElement cart;
	private WebElement checkoutButton;
	private WebElement subtotalText;
	private WebElement lineItemRow;
	private WebElement closeButton;
	
	public WebElement cart(){
		cart = driver.findElement(By.id("cart"));
		return cart;
	}

	public WebElement checkoutButton(){
		checkoutButton = driver.findElement(By.xpath("//div[@id='checkout']/a"));
		return checkoutButton;
	}
	
	public WebElement closeButton(){
		closeButton = driver.findElement(By.xpath("//*[@id='simplemodal-container']/a"));
		
		return closeButton;
	}
	public WebElement subtotalText(){
		subtotalText = driver.findElement(By.id("subtotal"));
		return subtotalText;
	}
	
	public WebElement lineItemRow(int rowNumber){
		String xpath = "//*[@id='cart_products']//*[starts-with(@id,'productRow')][" + rowNumber  + "]";
	
		//String xpath2 = "//*[@id='cart_products']/tbody/tr[" + rowNumber + "]";
		
		lineItemRow = driver.findElement(By.xpath(xpath));
		
		return lineItemRow;
	}
	
	public WebElement lineItemRow(String productName){
		String xpath = "//*[@id='cart_products']/tbody//td[@class='name']/a[text()=\"" + productName +   "\"]/../..";
		lineItemRow = driver.findElement(By.xpath(xpath));
		return lineItemRow;
	}
	
	
	public void verifyCartDisplay(){
		
		boolean exist = cart().isDisplayed();
		Assert.assertTrue("Cart doe not display",exist);
	}
	
	public void verifySubTotal(String price){
		String actualText = subtotalText().getText();
		Assert.assertEquals(price, actualText);
	}
	
	public void verifyItemQuantity(int rowNumber, int expectedNumber){
		
		WebElement lineitem = lineItemRow(rowNumber);
		WebElement textbox = lineitem.findElement(By.className("quantityInput"));
		String text = textbox.getAttribute("value");
		
		Assert.assertEquals(expectedNumber, Integer.parseInt(text));
	}
	
	public void verifyItemQuantity(String itemName, int expectedNumber){
		
		WebElement textbox = lineItemRow(itemName).findElement(By.className("quantityInput"));
		String text = textbox.getAttribute("value");
		
		Assert.assertEquals(expectedNumber, Integer.parseInt(text));
	}
	
	public void verifyItemPrice(int rowNumber, String expected){
		String text = lineItemRow(rowNumber).findElement(By.xpath("td[4]")).getText();
		
		Assert.assertEquals(expected, text);
	}
	
	public void verifyItemPrice(String itemName, String expected){
		String text = lineItemRow(itemName).findElement(By.xpath("td[4]")).getText();
		
		Assert.assertEquals(expected, text);
	}
	
	public void verifyItemTotalSaving(int rowNumber, String expected){
		String text = lineItemRow(rowNumber).findElement(By.xpath("td[5]")).getText();
		
		Assert.assertEquals(expected, text);
	}
	
	public void verifyItemTotalSaving(String itemName, String expected){
		String text = lineItemRow(itemName).findElement(By.xpath("td[5]")).getText();
		
		Assert.assertEquals(expected, text);
	}
	
	public void verifyItemTotal(int rowNumber, String expected){
		delayFor(2000);
		String text = lineItemRow(rowNumber).findElement(By.className("value")).getText();
		
		Assert.assertEquals(expected, text);
	}
	
	public void verifyItemTotal(String itemName, String expected){
		delayFor(2000);
		String text = lineItemRow(itemName).findElement(By.className("value")).getText();
		
		Assert.assertEquals(expected, text);
	}
	
	
	
	public void changeItemQuantity(int rowNumber, int newQuantity){
		lineItemRow(rowNumber).findElement(By.className("quantityInput")).clear();;
		lineItemRow(rowNumber).findElement(By.className("quantityInput")).sendKeys(newQuantity + "");
	}
	
	public void changeItemQuantity(String itemName, int newQuantity){
		lineItemRow(itemName).findElement(By.className("quantityInput")).clear();;
		lineItemRow(itemName).findElement(By.className("quantityInput")).sendKeys(newQuantity + "");
	}
	
	public void updateItemQuantity(int rowNumber){
		lineItemRow(rowNumber).findElement(By.className("updateQuantity")).click();
		delayFor(2000);
	}
	
	public void updateItemQuantity(String itemName){
		lineItemRow(itemName).findElement(By.className("updateQuantity")).click();
		delayFor(2000);
	}
	
	public void removeItem(int rowNumber){
		lineItemRow(rowNumber).findElement(By.className("remove_from_cart")).click();
		delayFor(2000);
	}
	
	public void removeItem(String itemName){
		lineItemRow(itemName).findElement(By.className("remove_from_cart")).click();
		delayFor(2000);
	}
	
	public void removeAllItemsNotGood(){
		
		List<WebElement> links = driver.findElements(By.xpath("//*[@id='cart_products']//td//*[text()='Remove']"));
		for(WebElement item : links){
			item.click();
			delayFor(1000);
			links = driver.findElements(By.xpath("//*[@id='cart_products']//td//*[text()='Remove']"));
		}	
	}
	
	public void removeAllItems(){
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		List<WebElement> links = driver.findElements(By.xpath("//*[@id='cart_products']//td//*[text()='Remove']"));
	
		while (links.size() > 0) {
			links.get(0).click();
			delayFor(1000);
			links = driver.findElements(By.xpath("//*[@id='cart_products']//td//*[text()='Remove']"));
		};
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	
	
	public void close(){
		closeButton().click();
	}
	public void checkout(){
		checkoutButton().click();
	}
}
