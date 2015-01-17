package com.paxovision.cucumber.framework;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SeleniumTestCaseContext {

	@Bean
	public WebDriver getDriver(){
		 WebDriver driver = null;
		
		 String browser = "firefox";  //System.getProperty("browser");
		 
	     if(browser.contentEquals("firefox")){
			driver= new FirefoxDriver();
		 }
		 else if(browser.contentEquals("chrome")){
			
			//String value = System.getProperty("user.dir");
			//System.setProperty("webdriver.chrome.driver", value + "/src/main/resources/driver/32/chromedriver.exe");
			//driver = new ChromeDriver();
		 }
		 else{
			driver= new FirefoxDriver();
		 }

    	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
		return driver;

	}
}
