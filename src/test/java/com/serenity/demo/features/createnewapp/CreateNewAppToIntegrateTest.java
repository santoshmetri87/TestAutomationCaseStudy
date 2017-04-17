package com.serenity.demo.features.createnewapp;

import java.util.Properties;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import com.serenity.demo.helpers.PropertyFileHelper;
import com.serenity.demo.steps.serenity.PubNativeLoginPageSteps;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.ClearCookiesPolicy;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Screenshots;
import net.thucydides.core.annotations.Steps;

@RunWith(SerenityRunner.class)
public class CreateNewAppToIntegrateTest {

	private static Properties configFileReader = PropertyFileHelper
			.loadPropertyFile("src/test/resources/config.properties");

	@Managed(uniqueSession = true, clearCookies = ClearCookiesPolicy.BeforeEachTest)
	public WebDriver webdriver;

	@Steps
	public PubNativeLoginPageSteps user;

	@Before
	public void initialSetup() {
		webdriver.manage().window().maximize();
	}

	@Test
	@Screenshots(afterEachStep=true)
	public void userCreatesNewApp() {
		user.login(configFileReader.getProperty("userEmailAddress"), configFileReader.getProperty("password"));
		user.addNewApp(configFileReader.getProperty("appPlatform"), configFileReader.getProperty("appPackageName"),
				configFileReader.getProperty("appNickName"), configFileReader.getProperty("appCategory"));
		user.callPubNativeAPIService().prettyPrint();
	}

}
