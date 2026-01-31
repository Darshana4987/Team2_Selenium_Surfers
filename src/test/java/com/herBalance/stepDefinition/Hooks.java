package com.herBalance.stepDefinition;

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
	
	DriverFactory driverFactory;
	ConfigReader configReader;
	WebDriver driver;
	String url;
	String browser;

	public Hooks() {
		this.driverFactory = new DriverFactory();
		this.configReader = new ConfigReader();
	}
	
	@Before
	public void setup() {
		browser = configReader.getBrowser();
		url = configReader.getUrl();
		driver= driverFactory.initBrowser(browser);	
		driver.get(url);
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
		if (driver != null) {
			driver.quit();
		}
	}

}
