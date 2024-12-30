package com.pelatro.automation.gui.backend.thirdpartysite.testcase.step;

import com.pelatro.automation.gui.backend.thirdpartysite.login.LoginPage;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginSteps {
	
	private LoginPage loginPage;
	
	@Given("I opened the app using following (.*)")
	public void openApp(String url) {
		loginPage.openAt(url);
	}
	
	@When("I type (.*) into Username field")
	public void enterUsername(String username) {
		loginPage.type("//*[@id=\"username\"]", username);
	}
	
	@And("I type (.*) into Password field")
	public void enterPassword(String password) {
		loginPage.type("//*[@id=\"password\"]", password);
	}
	
	@And("I Push Submit button")
	public void pressSubmitButton() {
		loginPage.click("/html[1]/body[1]/div[1]/div[1]/section[1]/section[1]/div[1]/button[1]");
	}
	
	 @Then("I should see success page")
	    public void verifySuccessPage() {
		 
	        assert loginPage.containUrl("practicetestautomation.com/logged-in-successfully/");
	    }
	 
	 @Then("I see the success message (.*) or (.*)")
	    public void verifySuccessMessage(String message1,String message2) {
		 
	        assert loginPage.containText(message1);
	        assert loginPage.containText(message2);
	    }
	 @Then("I see the logout button")
	    public void verifyLogoutButton() {
		 
	        assert loginPage.containLogoutButton("//a[@class='wp-block-button__link has-text-color has-background has-very-dark-gray-background-color']");
	    }
	 
	 @Then("I see the failure message (.*)")
	    public void verifyFailureMessage(String message) {
		 	assert loginPage.containText(message);
	    }
	 
	 @Then("I see the error message displayed")
	    public void verifyFailurePresence() {
		 
	        assert loginPage.containElement("//section[@id='main-container']");
	    }
}
