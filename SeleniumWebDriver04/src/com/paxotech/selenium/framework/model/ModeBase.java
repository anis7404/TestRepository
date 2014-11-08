package com.paxotech.selenium.framework.model;

import org.openqa.selenium.WebDriver;

public class ModeBase {
	
	protected WebDriver driver;
	
	public ModeBase(WebDriver driver){
		this.driver = driver;
	}
	
	public void delayFor(int ms){
		try {
			Thread.sleep(ms);
		} catch (InterruptedException e) {
		}
	}

}
