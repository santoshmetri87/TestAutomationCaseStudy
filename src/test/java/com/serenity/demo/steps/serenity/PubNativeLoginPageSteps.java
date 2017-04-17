package com.serenity.demo.steps.serenity;

import java.util.HashMap;
import java.util.Map;

import com.jayway.restassured.response.Response;
import com.serenity.demo.pages.AddNewAppPage;
import com.serenity.demo.pages.AppIndexPage;
import com.serenity.demo.pages.MenuNavigationpage;
import com.serenity.demo.pages.NewAppIntegrationPage;
import com.serenity.demo.pages.PubNativeLoginPage;
import com.serenity.demo.service.restful.PubNativeAPIservice;

import net.thucydides.core.annotations.Screenshots;
import net.thucydides.core.annotations.Step;

public class PubNativeLoginPageSteps {

	PubNativeLoginPage pubNativeLoginPage;
	MenuNavigationpage menuNavigationPage;
	AppIndexPage appIndexPage;
	AddNewAppPage addNewAppPage;
	NewAppIntegrationPage newAppIntegrationPage;
	PubNativeAPIservice pubNativeAPIservice;
	String APIToken;

	static Map<String, String> deviceProperties = new HashMap<String, String>();
	static {
		deviceProperties.put("bundle_id", "com.cleanmaster.mguard");
		deviceProperties.put("icon_size", "80x80");
		deviceProperties.put("banner_size", "1200x627");
		deviceProperties.put("os", "android");
		deviceProperties.put("os_version", "6.0");
		deviceProperties.put("device_model", "motorola 2CXT1068 2Ctitan_retaildsds");
		deviceProperties.put("android_advertiser_id_md5", "6d1424e3508b4800ab29b01c5b30e5e9");
	};

	@Step
	public void navigateToUrl() {
		pubNativeLoginPage.openUrl();
	}

	@Step("enters email address : {0}")
	public void enterEmailAddress(String emailAddress) {
		pubNativeLoginPage.enterEmailAddress(emailAddress);
	}

	@Step("enters password")
	public void enterPassword(String password) {
		pubNativeLoginPage.enterPassword(password);
	}

	@Step("clicks on login button")
	public void clickOnLogin() {
		pubNativeLoginPage.clickOnLogin();
	}

	@Step("login to the PubNative website")
	public void login(String emailAddress, String password) {
		navigateToUrl();
		enterEmailAddress(emailAddress);
		enterPassword(password);
		clickOnLogin();
		verifyTitleAfterLogin("PubNative - Genuinely Native");
	}

	@Step("verifies the page title after login : {0}")
	public void verifyTitleAfterLogin(String titleTextToVerify) {
		menuNavigationPage.verifyTitle(titleTextToVerify);
	}

	@Step("clicks on app option in the header menu")
	public void clickOnAppsMenuOption() {
		menuNavigationPage.clickOnAppsMenuOption();
	}

	@Step("clicks on add new app button")
	public void clickOnAddAppButton() {
		appIndexPage.clickOnAddButton();
	}

	@Step("selects app platform : {0}")
	public void selectAppPlatform(String appPlatForm) {
		addNewAppPage.selectAppPlatform(appPlatForm);
	}

	@Step("enters app_package_name : {0}")
	public void enterAppPackageName(String appPlatForm) {
		addNewAppPage.enterAppIdOrPackageName(appPlatForm);
	}

	@Step("enters application nick name : {0}")
	public void enterAppNickName(String nickName) {
		addNewAppPage.enterAppNickName(nickName);
	}

	@Step("selects app category : {0}")
	public void selectAppCategory(String category) {
		addNewAppPage.selectAppCategory(category);
	}

	@Step("clicks on finish button")
	public void clickOnFinishButton() {
		addNewAppPage.clickOnFinishButton();
	}

	@Step("adds new app")
	public void addNewApp(String appPlatForm, String appIdOrPackageName, String nickName, String category) {
		clickOnAppsMenuOption();
		clickOnAddAppButton();
		selectAppPlatform("Android");
		enterAppPackageName(appIdOrPackageName);
		enterAppNickName(nickName);
		selectAppCategory(category);
		clickOnFinishButton();
	}

	@Step("copies token string from app integration page")
	public String getTokenForIntegration() {
		menuNavigationPage.clickOnAppsMenuOption();
		appIndexPage.clickOnIntegrationOption();
		APIToken = newAppIntegrationPage.getTokenForIntegration();
		deviceProperties.put("app_token", APIToken);
		return APIToken;
	}

	@Step("calls API service")
	@Screenshots(disabled = true)
	public Response callPubNativeAPIservice() {
		return pubNativeAPIservice.callPubNativeAPIservice(deviceProperties);
	}

	@Step("displays API response on the report: {0}")
	@Screenshots(disabled = true)
	public Response displayAPIresponse(String response) {
		return pubNativeAPIservice.callPubNativeAPIservice(deviceProperties);
	}

	@Step("checks for API response for the new app added")
	@Screenshots(disabled = true)
	public Response callPubNativeAPIService() {
		getTokenForIntegration();
		Response serviceResponse = callPubNativeAPIservice();
		displayAPIresponse(serviceResponse.prettyPrint());
		return serviceResponse;
	}
}
