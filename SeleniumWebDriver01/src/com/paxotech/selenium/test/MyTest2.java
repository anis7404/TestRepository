package com.paxotech.selenium.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.paxotech.selenium.framework.ScriptBase;

public class MyTest2 extends ScriptBase{


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
}
