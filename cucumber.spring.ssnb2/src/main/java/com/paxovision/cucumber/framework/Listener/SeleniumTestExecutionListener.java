package com.paxovision.cucumber.framework.Listener;

import org.openqa.selenium.WebDriver;
import org.springframework.test.context.TestContext;
import org.springframework.test.context.support.AbstractTestExecutionListener;

import com.paxovision.cucumber.framework.TestScope;


public class SeleniumTestExecutionListener extends AbstractTestExecutionListener {
	
	@Override
	public void beforeTestMethod(TestContext testContext) throws Exception {
		testContext.getApplicationContext().getBean(TestScope.class).reset();
	}

	@Override
	public void afterTestMethod(TestContext testContext) throws Exception {
		testContext.getApplicationContext().getBean(WebDriver.class).quit();
	}

}
