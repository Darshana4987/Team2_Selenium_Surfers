package com.herBalance.runner;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;

import com.beust.jcommander.Parameters;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(plugin = { "pretty", "html:target/dsAlgo.html", "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm",
		"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:" }, monochrome = false, tags = " ", features = "src/test/resources/dsAlgo_FeatureFiles", glue = {
				"dsAlgo_StepDefinition", "dsAlgo_hooks" })

public class Runner extends AbstractTestNGCucumberTests {

	@BeforeTest
//	@Parameters("browserType")
//	public void browserChange(@Optional() String browserType) {
//
//		if (browserType != null && !browserType.equals("param-val-not-found")) {
//			DriverFactory.setBrowserType(browserType);
//
//		}
//	}

	@Override
	@DataProvider(parallel = false)
	public Object[][] scenarios() {

		return super.scenarios();
	}

}
