package com.paxotech.selenium.experiment.test;


import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.paxotech.selenium.framework.pom.Page;
import com.paxotech.selenium.framework.util.SpecializedScreenRecorder;



public class PopupTest {
	
	protected WebDriver driver ;
	private SpecializedScreenRecorder screenRecorder;
	
	

	@BeforeMethod
	public void beforeMethod() throws Exception {
		startRecording();
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.navigate().to("http://www.abercrombie.com");
	}
	
	
	@Test
	public void popUpTestForabercrombie(){
		
		Page page = new Page(driver);
		WebElement popup = null;
		
		try{
			popup = page.waitForElementDisplayed(By.id("simplemodal-data"),5);
		}
		catch(Exception ex)
		{
			//ex.printStackTrace();
		}
		
		if(popup != null){
			WebElement close = driver.findElement(By.cssSelector(".simplemodal-close"));
			close.click();
		}
		
		WebElement loginTopLink = driver.findElement(By.xpath("//*[@id='util-account']/a"));
		page.hoverItem(loginTopLink);
		
		WebElement login = page.waitForElementDisplayed(By.xpath("//*[@id='util-account-nav']/ul/li[1]/a"));
		login.click();
		
	}
	
	
	
	@AfterMethod
	public void afterMethod() throws Exception {
		driver.close();
		driver.quit();
		driver = null;
		stopRecording();
	}
	
	
	public void startRecording() throws Exception {

		String useDir = System.getProperty("user.dir");
		String timeString = new SimpleDateFormat("yyyyMMdd").format(new Date());
		String fileNameStartWith = "TestScript";

		File path = new File(useDir + System.getProperty("file.separator")
				+ "target" + System.getProperty("file.separator") + "videos"
				+ System.getProperty("file.separator") + timeString
				+ System.getProperty("file.separator"));
		if (!path.exists()) {
			path.mkdir();
		}

		this.screenRecorder = new SpecializedScreenRecorder(path,fileNameStartWith);
		this.screenRecorder.start();

	}

	public void stopRecording() throws Exception {
		this.screenRecorder.stop();
	}

}
