package com.pelatro.automation.gui.backend.thirdpartysite.login;

import org.openqa.selenium.WebDriver;

import com.pelatro.automation.gui.backend.thirdpartysite.generic.Page;

public class LoginPage extends Page {

	public LoginPage(WebDriver driver) {
		super(driver);
	}
	
	public boolean containLogoutButton(String xpath)
	{
		if(containElement(xpath))
			return true;
		else
			return false;
	}
	

}
