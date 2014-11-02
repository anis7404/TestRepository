package com.paxotech.selenium;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class MySeleniumJUnitTest2 {

private WebDriver driver ;
	
	@Before
	public void setUp() throws Exception {
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.navigate().to("http://demo.broadleafcommerce.org/");
		
	}

	@Test
	public void test() {
		WebElement loginLink = driver.findElement(By.xpath("//*[@id='cart_info']/a[1]/span"));
		loginLink.click();
		
		String title = driver.getTitle();
		
		assertEquals("Login - Broadleaf Demo - Heat Clinic", title);
		
	}
	
	@Test
	public void test2() {
		WebElement loginLink = driver.findElement(By.xpath("//*[@id='cart_info']/a[1]/span"));
		loginLink.click();
		
		WebElement emailAddress = driver.findElement(By.name("j_username"));
		emailAddress.sendKeys("iivaan@gmail.com");
		
		WebElement password = driver.findElement(By.name("j_password"));
		password.sendKeys("ameera6786");
		
		WebElement loginButton = driver.findElement(By.xpath("//*[@id='login']/div/form/div[3]/input"));
		loginButton.click();
		
		WebElement errorMsg = driver.findElement(By.xpath("//*[@id='login']/span/p/span"));
		String msg = errorMsg.getText();
		
		assertEquals("The e-mail address and/or password entered do not match our records. Please try again", msg);
		
		
	}
	
	@After
	public void tearDown() throws Exception {
		driver.close();
	}



}
