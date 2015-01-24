package com.paxovision.cucumber.framework;

import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.util.StringUtils;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;


//https://github.com/cucumber/cucumber/wiki/Tags
	
	
@RunWith(Cucumber.class)
@CucumberOptions(
		  //dryRun = false,
		  //strict = true,
		  monochrome = true,
		  tags = { "@debug" },
		  //tags = { "@functional","@debug" }, /*AND*/
		  //tags = { "@functional,@debug" }, /*OR*/
		  //tags = { "@functional,@debug","@debug" }, /*AND-OR*/
		  features = "src/test/resources/features",
		  glue = {"com.paxovision.steps","com.paxovision.cucumber.framework.hooks"},
	 plugin={
		 "pretty",
		 "html:target/test-report",
		 "json:target/test-report.json",
		 "json:target/cucumber-report.json",
		 "junit:target/test-report.xml"
		 }
)
public class CucumberTestRunner {
	
	@BeforeClass
	public static void setUp(){
		String envTarget = System.getProperty("envTarget");
        if (!StringUtils.hasText(envTarget)) {
            envTarget = "default";
            System.setProperty("envTarget", envTarget);
        }
        
        String browser = System.getProperty("browser");
	    if(!StringUtils.hasText(browser)){
	        browser = "firefox";
	        System.setProperty("browser", browser);
	    }
	}
}
