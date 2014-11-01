package com.paxotech.selenium.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.paxotech.selenium.framework.ScriptBase;

public class MyTest extends ScriptBase{
	
	
	@Test
	public void test() {
		WebElement loginLink = driver.findElement(By.xpath("//*[@id='cart_info']/a[1]/span"));
		loginLink.click();
		
		String title = driver.getTitle();
		
		assertEquals("Login - Broadleaf Demo - Heat Clinic", title);
		
	}

}
