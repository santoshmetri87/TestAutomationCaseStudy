package com.serenity.demo.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

public class NewAppIntegrationPage extends PageObject {

	@FindBy(name = "integration-code")
	private WebElementFacade tokenText;

	public String getTokenForIntegration() {
		return tokenText.getText();
	}
}
