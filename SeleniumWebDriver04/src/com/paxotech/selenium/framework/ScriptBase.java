package com.paxotech.selenium.framework;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

import com.paxotech.selenium.framework.controller.ApplicationController;
import com.paxotech.selenium.framework.controller.HomePageController;
import com.paxotech.selenium.framework.controller.LoginPageController;
import com.paxotech.selenium.framework.model.HomePageModel;
import com.paxotech.selenium.framework.model.LoginPageModel;

public class ScriptBase {

	protected WebDriver driver ;
	
	private ApplicationController heatClinic;
	

	
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
	

	public ApplicationController heatClinic(){
		if(heatClinic == null){
			heatClinic = new ApplicationController(driver);
		}
		
		return heatClinic;
	}
	
	
}
