package com.paxovision.cucumber.steps;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalToIgnoringCase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.paxovision.cucumber.framework.Steps;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class HeatclinicSteps extends Steps {

	@Given("^As a not validated user$")
	public void as_a_not_validated_user() throws Throwable {
		driver.manage().deleteAllCookies();
	}

	@When("^Browse to the \"(.*?)\"$")
	public void browse_to_the(String url) throws Throwable {
		System.out.println(url);
	    driver.navigate().to(url);
	}
	
	@When("^Browse to the application$")
	public void browse_to_the_app() throws Throwable {
		String url = environment.getProperty("root.url");
		System.out.println(url);
	    driver.navigate().to(url);
	}
	

	@Then("^Broadlief home page should show$")
	public void broadlief_home_page_should_show() throws Throwable {
		String title = driver.getTitle();
		Assert.assertEquals(title, "Broadleaf Commerce Demo Store - Heat Clinic");
	}

	@When("^User click login button$")
	public void user_click_login_button() throws Throwable {
		WebElement loginLink = driver.findElement(By.cssSelector("a.account"));
		loginLink.click();
	}

	@When("^Enter \"(.*?)\" as emaill address$")
	public void enter_as_emaill_address(String email) throws Throwable {
		driver.findElement(By.name("j_username")).sendKeys(email);
	}

	@When("^Enter \"(.*?)\" as password$")
	public void enter_as_password(String pass) throws Throwable {
		driver.findElement(By.name("j_password")).sendKeys(pass);
	}

	@When("^Click login$")
	public void click_login() throws Throwable {
		 driver.findElement(By.cssSelector("input.login_button.big.red")).click();
	}

	@Then("^Invalid email or password message display as \"(.*?)\"$")
	public void invalid_email_or_password_message_display_as(String msg) throws Throwable {
		 String text = driver.findElement(By.cssSelector("span.error")).getText();
		 System.out.println(text);
		 assertThat(text.trim(), equalToIgnoringCase(msg));
	}
}
