package com.paxovision.cucumber;

import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.testng.annotations.Test;

import com.paxovision.cucumber.framework.SpringTestScript;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.testng.TestNGCucumberRunner;

public class HeatClinicTestRunner extends SpringTestScript {

	 @Test(groups = "CucumberTest", description = "TestNGCucumberRunner to invoke Cucumber")
	 public void cucumberTest() throws IOException {
	        new TestNGCucumberRunner(getClass()).runCukes();
	 }
	 
	//-Dcucumber.options="--tags @debug"
	//-Dcucumber.options="classpath:com/company/my_feature.feature:6"

	//-DenvTarget=default -Dbrowser=firefox -Dcucumber.options="--tags @debug" 
}
