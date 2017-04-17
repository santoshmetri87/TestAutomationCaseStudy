package com.serenity.demo.pages;

import org.openqa.selenium.support.ui.Select;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

public class AddNewAppPage extends PageObject {

	@FindBy(id = "app_platform_id")
	private WebElementFacade appPlatform;

	@FindBy(name = "app[store_application_id]")
	private WebElementFacade appIdOrPackageName;

	@FindBy(name = "app[title]")
	private WebElementFacade appNickName;

	@FindBy(name = "app[main_category_id]")
	private WebElementFacade appCategory;

	@FindBy(name = "commit")
	private WebElementFacade finishButton;

	public void selectAppPlatform(String platForm) {
		Select dropdown = new Select(appPlatform);
		dropdown.selectByVisibleText(platForm);
	}

	public void selectAppCategory(String category) {
		Select dropdown = new Select(appCategory);
		dropdown.selectByVisibleText(category);
	}

	public void enterAppIdOrPackageName(String packageName) {
		appIdOrPackageName.type(packageName);
	}

	public void enterAppNickName(String nickName) {
		appNickName.type(nickName);
	}

	public void clickOnFinishButton() {
		clickOn(finishButton);
	}

}
