package com.paxovision.selenium;


import java.io.IOException;

import org.testng.annotations.Test;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import cucumber.api.testng.TestNGCucumberRunner;


@CucumberOptions(   dryRun = false,
					strict = true,
					monochrome = true,
					tags = { "@debug" },
					features = "src/test/resources",
					glue = "com.paxovision.selenium.steps",
					plugin={
							"pretty",
			        		 "html:target/test-report",
			        		 "json:target/test-report.json",
			        		 "json:target/cucumber-report.json",
			        		 "junit:target/test-report.xml"
							}
				)
public class HeatclinicTestRunner extends AbstractTestNGCucumberTests {
	
	  @Test(groups = "CucumberTest", description = "TestNGCucumberRunner to invoke Cucumber")
	  public void cucumberTest() throws IOException {
	        new TestNGCucumberRunner(getClass()).runCukes();
	  }
}
