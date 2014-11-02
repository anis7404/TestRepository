package com.paxotech.selenium.framework;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ScriptBase1 {

	protected WebDriver driver ;
	
	@Before
	public void setUp() throws Exception {
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.navigate().to("http://demo.broadleafcommerce.org/");
	}
	
	
	@After
	public void tearDown() throws Exception {
		driver.close();
	}
	
	public void showLoginPage(){
		WebElement loginLink = driver.findElement(By.xpath("//*[@id='cart_info']/a[1]/span"));
		loginLink.click();
	}
	
	public void login(String userid, String password){
		
		WebElement emailAddressElement = driver.findElement(By.name("j_username"));
		emailAddressElement.sendKeys(userid);
		
		WebElement passwordElement = driver.findElement(By.name("j_password"));
		passwordElement.sendKeys(password);
		
		WebElement loginButton = driver.findElement(By.xpath("//*[@id='login']/div/form/div[3]/input"));
		loginButton.click();
		
	}
	
	public boolean verifyLoginSuccess(String loginUser){
		
		WebElement loginUserElement = driver.findElement(By.xpath(".//*[@id='cart_info']/span/a"));
		if(loginUserElement != null){
			String text = loginUserElement.getText();
			assertEquals(loginUser, text);
			return true;
		}
		
		return false;
	}

	public boolean verifyLoginNotSuccess(){

		WebElement errorMsg = driver.findElement(By.xpath("//*[@id='login']/span/p/span"));
		String msg = errorMsg.getText();
		
		assertEquals("The e-mail address and/or password entered do not match our records. Please try again", msg);
		return true;	
		
	}
}
