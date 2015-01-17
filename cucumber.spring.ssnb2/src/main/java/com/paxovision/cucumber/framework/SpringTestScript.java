package com.paxovision.cucumber.framework;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.util.StringUtils;

import cucumber.api.CucumberOptions;


@CucumberOptions( dryRun = false,
				  strict = true,
				  monochrome = true,
				  tags = { "@debug" },
				  features = "src/test/resources/feature",
				  glue = "com.paxovision.cucumber.steps",
				  plugin={
						 "pretty",
						 "html:target/test-report",
						 "json:target/test-report.json",
						 "json:target/cucumber-report.json",
						  "junit:target/test-report.xml"
						 }
)
@ContextConfiguration(locations = { "classpath:spring-test-config.xml"})
public class SpringTestScript extends AbstractTestNGSpringContextTests {

	public SpringTestScript(){
		super();
	}	
}
