package com.paxotech.selenium.framework.pom;

import org.openqa.selenium.WebDriver;

public class Page {
	
	protected WebDriver driver;
	
	public Page(WebDriver driver){
		this.driver = driver;
	}
	
	
	public void delayFor(int ms){
		try {
			Thread.sleep(ms);
		} catch (InterruptedException e) {
		}
	}

}
