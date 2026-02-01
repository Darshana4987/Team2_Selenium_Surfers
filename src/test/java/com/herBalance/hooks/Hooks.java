package com.herBalance.hooks;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.herBalance.driverFactory.DriverFactory;
import com.herBalance.utils.ConfigReader;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {
	private ConfigReader configReader;
	private WebDriver driver;
	
	@Before
	public void setup() {
		configReader = new ConfigReader();
		configReader.loadProperties();
		driver= DriverFactory.initBrowser(ConfigReader.getBrowserType());	
		driver.get(ConfigReader.getUrl());
	}

	@AfterStep
	public void takeScreenshot(Scenario scenario) {
		if (scenario.isFailed()) {
			final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(screenshot, "image/png", scenario.getName());
		}
	}

	@After
	public void tearDown() {
		DriverFactory.quitDriver();
	}

}
