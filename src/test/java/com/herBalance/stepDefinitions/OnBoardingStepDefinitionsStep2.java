package com.herBalance.stepDefinitions;

import com.herBalance.driverFactory.DriverFactory;
import com.herBalance.pageObjects.OnBoardingPagePart1;

import io.cucumber.java.en.When;

public class OnBoardingStepDefinitionsStep2 {
	private OnBoardingPagePart1 onBoardingPage;
	
	public OnBoardingStepDefinitionsStep2() {
		onBoardingPage = new OnBoardingPagePart1(DriverFactory.getDriver());
	}
	
	@When("User clicks continue button")
	public void user_clicks_continue_button() {
		onBoardingPage.clickContinue();
	   
	}

}
