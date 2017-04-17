package com.serenity.demo.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

public class MenuNavigationpage extends PageObject {

	@FindBy(css = "#wrap > nav > div > div.navbar-collapse.collapse > ul > li:nth-child(2) > a > span.fa.fa-gamepad")
	private WebElementFacade menuOptionApp;

	public void clickOnAppsMenuOption() {
		clickOn(menuOptionApp);
	}

	public boolean verifyTitle(String titleTextToVerify) {
		return getTitle().contains(titleTextToVerify);
	}
}
