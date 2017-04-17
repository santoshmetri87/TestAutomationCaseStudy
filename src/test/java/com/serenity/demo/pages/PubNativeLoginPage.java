package com.serenity.demo.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;

@DefaultUrl("https://dashboard.pubnative.net/apps")
public class PubNativeLoginPage extends PageObject {

	@FindBy(name = "email")
	private WebElementFacade emailAddressfield;

	@FindBy(name = "password")
	private WebElementFacade passwordField;

	@FindBy(name = "commit")
	private WebElementFacade loginButton;

	public void enterEmailAddress(String emailAddress) {
		emailAddressfield.type(emailAddress);
	}

	public void enterPassword(String passwrd) {
		waitFor(passwordField);
		passwordField.type(passwrd);
	}

	public void clickOnLogin() {
		clickOn(loginButton);
	}

	public void openUrl() {
		open();
		waitForAngularRequestsToFinish();
	}

}
