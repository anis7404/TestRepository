package com.paxotech.selenium.test;

import org.junit.Test;

import com.paxotech.selenium.framework.ScriptBase;

public class RegisterUserTest extends ScriptBase{

	@Test
	public void registerUser() {
		
		heatClinic().homePage().clickRegisterLink();
		heatClinic().registerPage().register("iivaan1@gamil.com", "Iftekhar", "Ivaan", "123456", "123456");
	}
}
