package com.herBalance.runner;

import org.slf4j.LoggerFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import io.cucumber.testng.CucumberOptions;
import com.herBalance.utils.ConfigReader;

import io.cucumber.testng.AbstractTestNGCucumberTests;

@CucumberOptions(features = "src/test/resources/features", 
		glue = { "com.herBalance.hooks","com.herBalance.stepDefinitions" }, 
		tags = "not @Bug", 
		plugin = { "pretty","html:cucumber-reports.html", "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"}, 
		dryRun = false, 
		monochrome = false)
public class Runner extends AbstractTestNGCucumberTests {
	@Override
	@DataProvider(parallel = true)
	public Object[][] scenarios() {
		return super.scenarios();
	}

	@BeforeClass
	@Parameters({ "browserType" })
	public void beforeClass(@Optional String browser) {
		LoggerFactory.getLogger(Runner.class).info("browserType value from testNG file {}", browser);
		ConfigReader.setBrowserType(browser);
	}
}
