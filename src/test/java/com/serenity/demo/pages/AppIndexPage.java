package com.serenity.demo.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

public class AppIndexPage extends PageObject {

	@FindBy(css = "#wrap > div.container > div.form-group > a")
	private WebElementFacade addAppButton;

	@FindBy(css = "#application-list-grid > tbody:nth-child(4) > tr:nth-child(2) > td:nth-child(4) > p > a:nth-child(2)")
	private WebElementFacade integrationOption;

	public void clickOnAddButton() {
		clickOn(addAppButton);
	}

	public void clickOnIntegrationOption() {
		clickOn(integrationOption);
	}

}
