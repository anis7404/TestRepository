package com.paxovision.cucumber.framework;

import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.util.StringUtils;

import com.paxovision.cucumber.framework.Listener.SeleniumTestExecutionListener;

import cucumber.api.CucumberOptions;


@CucumberOptions( dryRun = false,
				  strict = true,
				  monochrome = true,
				  tags = { "@debug" },
				  features = "src/test/resources/feature",
				  glue = {"com.paxovision.cucumber.steps","com.paxovision.cucumber.framework.hooks"},
				  plugin={
						 "pretty",
						 "html:target/test-report",
						 "json:target/test-report.json",
						 "json:target/cucumber-report.json",
						  "junit:target/test-report.xml"
						 }
)
@ContextConfiguration(locations = { "classpath:spring-test-config.xml"})
@TestExecutionListeners({SeleniumTestExecutionListener.class,  DependencyInjectionTestExecutionListener.class})
public class SpringTestScript extends AbstractTestNGSpringContextTests {

	@Autowired
	private Environment environment;
	@Autowired
	private WebDriver driver;
	
	
	public SpringTestScript(){
		super();
		
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
