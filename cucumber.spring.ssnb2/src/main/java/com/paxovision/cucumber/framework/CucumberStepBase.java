package com.paxovision.cucumber.framework;

import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

@ContextConfiguration(locations = { "classpath:spring-test-config.xml"})
public class CucumberStepBase {

	@Autowired 
	protected WebDriver driver;
	
}
