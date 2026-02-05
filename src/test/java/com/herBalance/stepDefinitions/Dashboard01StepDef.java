package com.herBalance.stepDefinitions;

import org.openqa.selenium.support.ui.WebDriverWait;

import com.herBalance.driverFactory.DriverFactory;
import com.herBalance.pageObjects.DashboardPage1;
import com.herBalance.pageObjects.SignUpPage;

import io.cucumber.java.en.*;

public class Dashboard01StepDef {
	
	private DashboardPage1 dashboardObj;

	public Dashboard01StepDef() {
		
		dashboardObj = new DashboardPage1(DriverFactory.getDriver());
	}

	//WebDriverWait wait;

	
}
