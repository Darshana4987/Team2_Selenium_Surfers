package com.herBalance.stepDefinitions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.herBalance.driverFactory.DriverFactory;
import com.herBalance.pageObjects.OnBoardingPagePart1;
import com.herBalance.pageObjects.OnBoardingPageStep6;
import com.herBalance.pageObjects.OnBoardingPageStep7;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class OnBoardingStepDefinitionStep7 {
	
private static final Logger logger = LoggerFactory.getLogger(OnBoardingStepDefinitionStep7.class);
	
	private OnBoardingPageStep7 obj_OnboardStep7;
	private OnBoardingPageStep6 obj_OnboardStep6;

	public OnBoardingStepDefinitionStep7() {
		
		obj_OnboardStep7 = new OnBoardingPageStep7(DriverFactory.getDriver());
		obj_OnboardStep6= new OnBoardingPageStep6(DriverFactory.getDriver());
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
	
	
	
	
	
	
	@When("User clicks continue button without entering current weight")
	public void user_clicks_continue_button_without_entering_current_weight() {
	   
	}

	@When("User clicks continue button after entering invalid weight")
	public void user_clicks_continue_button_after_entering_invalid_weight() {
	   
	}

	@Then("Error message {string} shouldbe displayed")
	public void error_message_shouldbe_displayed(String string) {
	  
	}

	@When("User clicks continue button without entering height")
	public void user_clicks_continue_button_without_entering_height() {
	  
	}

	@Given("User clicks continue button after entering invalid height")
	public void user_clicks_continue_button_after_entering_invalid_height() {
	    
	}

	@When("User clicks weight\\(kg) dropdown")
	public void user_clicks_weight_kg_dropdown() {
	   
	}

	@Then("Options {string} and {string} should be displayed")
	public void options_and_should_be_displayed(String string, String string2) {
	    
	}

	@When("User clicks height\\(cm) dropdown")
	public void user_clicks_height_cm_dropdown() {
	   
	}

	@When("User enters valid height and weight")
	public void user_enters_valid_height_and_weight() {
	  
	}

	@Then("BMI bar should be displayed")
	public void bmi_bar_should_be_displayed() {
	   
	}

	@Given("User clicks continue after entering valid weight and height")
	public void user_clicks_continue_after_entering_valid_weight_and_height() {
	  
	}

	@Then("Redirected to Step {int}")
	public void redirected_to_step(Integer int1) {
	    
	}




}
