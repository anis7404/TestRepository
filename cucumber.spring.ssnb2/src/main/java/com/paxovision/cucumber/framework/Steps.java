package com.paxovision.cucumber.framework;

import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.test.context.ContextConfiguration;


@ContextConfiguration(locations = { "classpath:spring-test-config.xml"})
public class Steps {

	@Autowired
	protected Environment environment;
	@Autowired 
	protected WebDriver driver;
	
}
