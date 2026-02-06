package com.herBalance.hooks;

import java.util.Collection;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.herBalance.driverFactory.DriverFactory;
import com.herBalance.utils.ConfigReader;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.Scenario;
import io.qameta.allure.Allure;
import java.io.ByteArrayInputStream;

public class Hooks {
	private WebDriver driver;
	public static Collection<String> scenarioTags;
	
	@BeforeAll
	public static void loadConfigProp() {
		ConfigReader.loadProperties();
	}
	
	@Before
	public void setup(Scenario scenario) {
		driver= DriverFactory.initBrowser(ConfigReader.getBrowserType());	
		driver.get(ConfigReader.getUrl());
		scenarioTags = scenario.getSourceTagNames(); 
	}

	@AfterStep
	public void takeScreenshot(Scenario scenario) {
		if (scenario.isFailed() || scenarioTags.contains("@GeneratePlan")) {
			TakesScreenshot takesScreenshot = (TakesScreenshot) DriverFactory.getDriver();
			byte[] screenShot = takesScreenshot.getScreenshotAs(OutputType.BYTES);
			scenario.attach(screenShot, "image/png", scenario.getName());
			Allure.addAttachment(scenario.getName(), new ByteArrayInputStream(screenShot));
		}
	}

	@After
	public void tearDown() {
		DriverFactory.quitDriver();
	}

}