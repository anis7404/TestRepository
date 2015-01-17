package com.paxovision.cucumber;

import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;

import com.paxovision.cucumber.framework.SpringTestScript;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.testng.TestNGCucumberRunner;

public class HeatClinicTestRunner extends SpringTestScript {

	@Autowired
	private WebDriver driver;
	
	
	 @Test(groups = "CucumberTest", description = "TestNGCucumberRunner to invoke Cucumber")
	 public void cucumberTest() throws IOException {
	        new TestNGCucumberRunner(getClass()).runCukes();
	 }
	 
	 @Before
	 public void beforeScenario(/*Scenario scenario*/) throws Exception {

	    	//String scenarioId = scenario.getId();
	    	//String featureName = scenarioId.substring(0, scenarioId.indexOf(";"));
	 }
	 
	 @After
	 public void afterScenario(/*Scenario scenario*/) throws Exception {
	    	/*if (scenario.isFailed()) {
	            final byte[] screenshot = ((TakesScreenshot) driver)
	                        .getScreenshotAs(OutputType.BYTES);
	            scenario.embed(screenshot, "image/png"); //stick it in the report
	    	}*/
	    	
	    	driver.close();
	 }
	 
}
