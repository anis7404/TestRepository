package com.paxotech.selenium;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class MySeleniumScript {

	public static void main(String[] args) throws MalformedURLException {

		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		
		driver.navigate().to("http://demo.broadleafcommerce.org/");
		
		
		//URL url = new URL("http://demo.broadleafcommerce.org/");
		//driver.navigate().to(url);
		//driver.navigate().to(new URL("http://demo.broadleafcommerce.org/"));
		
		
		WebElement loginLink = driver.findElement(By.xpath("//*[@id='cart_info']/a[1]/span"));
		loginLink.click();
		
		String title = driver.getTitle();
		if(title.contentEquals("Login - Broadleaf Demo - Heat Clinic")){
			
			System.out.println("Script Pass");
		}
		else
		{
			System.out.println("Script Fail");
		}
		
		
		driver.close();
		
	}

}
