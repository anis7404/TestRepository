package com.paxotech.selenium.framework.controller;

import org.openqa.selenium.WebDriver;

public class ControllerBase {

	protected WebDriver driver;
	
	public ControllerBase(WebDriver driver){
		this.driver = driver;
	}
	
	public void delayFor(int ms){
		try {
			Thread.sleep(ms);
		} catch (InterruptedException e) {
		}
	}
}
