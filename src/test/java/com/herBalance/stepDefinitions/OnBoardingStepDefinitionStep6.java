package com.herBalance.stepDefinitions;

import org.testng.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.herBalance.driverFactory.DriverFactory;
import com.herBalance.pageObjects.OnBoardingPagePart1;
import com.herBalance.pageObjects.OnBoardingPageStep6;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class OnBoardingStepDefinitionStep6 {
	
	private static final Logger logger = LoggerFactory.getLogger(OnBoardingStepDefinitionStep6.class);
	
	private OnBoardingPageStep6 obj_OnboardStep6;

	public OnBoardingStepDefinitionStep6() {
		
		obj_OnboardStep6 = new OnBoardingPageStep6(DriverFactory.getDriver());
	}
	
	@Given("User is in step {int} of onboarding")
	public void user_is_in_step_of_onboarding(Integer int1) {
	   
		
		obj_OnboardStep6.gotoSignPage();
		obj_OnboardStep6.clickRgister();
		obj_OnboardStep6.clickContunueWithOutReportButton();
		
		obj_OnboardStep6.clickHealthCondition();
		obj_OnboardStep6.clickContinueBtn();
		
		obj_OnboardStep6.enterPersonalDetails();
		obj_OnboardStep6.clickBloodPressureStatus();
		obj_OnboardStep6.clickContinueBtn();
		
		obj_OnboardStep6.clickMenstrualCycleAwarenessOptions();
		obj_OnboardStep6.clickContinueBtn();
		
		logger.info("You are on Onboard Process step 6");
	}

	@When("User clicks continue button without selecting last menstrual date")
	public void user_clicks_continue_button_without_selecting_last_menstrual_date() {
		
		obj_OnboardStep6.clickContinueBtn();
	}

	@Then("Error message {string} should be displayed")
	public void error_message_should_be_displayed(String errormessage) {
	   
		Assert.assertEquals(obj_OnboardStep6.getErrorText(), errormessage);
		logger.info("Please select your last period start date");
	}
	
	@When("User selects last menstrual date")
	public void user_selects_last_menstrual_date() {
		
		obj_OnboardStep6.inputlastMenstrualDate();
	}

	@When("User clicks continue after selecting last menstrual date")
	public void user_clicks_continue_after_selecting_last_menstrual_date() {
		
		obj_OnboardStep6.clickContinueBtn();
	}

	@Then("Progress bar shows the current step {string}")
	public void progress_bar_shows_the_current_step(String progressBarCurrentStep) {
	    
		Assert.assertEquals(obj_OnboardStep6.getprogressBarCurrentStep(), progressBarCurrentStep);
		logger.info("Current progress bar shows 6 of 10");
	}

	@When("User clicks back button in step {int}")
	public void user_clicks_back_button_in_step(Integer int1) {
	  
		obj_OnboardStep6.clickBackBtn();
		// call here swori's method that user is on step 5
	}

	@Then("User redirected to back Step {int}")
	public void user_redirected_to_back_step(Integer int1) {
		// call here swori's method that user is on step 5
	}

	@Then("User redirected to next Step {int}")
	public void user_redirected_to_next_step(Integer int1) {
	    
	}

	@When("User clicks continue button after entering invalid value in date")
	public void user_clicks_continue_button_after_entering_invalid_value_in_date() {
		
		obj_OnboardStep6.inputInvalid_lastMenstrualDate();
	   
	}


}
