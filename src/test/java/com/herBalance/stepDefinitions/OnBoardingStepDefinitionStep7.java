package com.herBalance.stepDefinitions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

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
	private OnBoardingPagePart1 onBoardingPage;
	private OnBoardingPageStep6 obj_OnboardStep6;

	public OnBoardingStepDefinitionStep7() {

		obj_OnboardStep7 = new OnBoardingPageStep7(DriverFactory.getDriver());
		onBoardingPage = new OnBoardingPagePart1(DriverFactory.getDriver());
		obj_OnboardStep6 = new OnBoardingPageStep6(DriverFactory.getDriver());
	}

	@Given("User is in step seven of onboarding")
	public void user_is_in_step_seven_of_onboarding() {

		onBoardingPage.gotoSignPage();
		onBoardingPage.clickRgister();
		onBoardingPage.clickContunueWithOutReportButton(); // Onboard Step 2

		obj_OnboardStep6.clickHealthCondition();
		obj_OnboardStep6.clickContinueBtn(); // Step 3

		obj_OnboardStep6.enterPersonalDetails();
		obj_OnboardStep6.clickBloodPressureStatus();
		obj_OnboardStep6.clickContinueBtn(); // step4

		obj_OnboardStep6.clickMenstrualCycleAwarenessOptions();
		obj_OnboardStep6.clickContinueBtn(); // Step 5

		obj_OnboardStep6.enterlastMenstrualDate(); // Step 6
		obj_OnboardStep6.clickContinueBtn();

	}

	@When("User clicks continue button without entering current weight")
	public void user_clicks_continue_button_without_entering_current_weight() {

		obj_OnboardStep7.enterEmptyWeight();
		obj_OnboardStep6.clickContinueBtn();
	}

	@Then("Error message {string} should be displayed for empty weight")
	public void error_message_should_be_displayed_for_empty_weight(String errorMessage) {

		Assert.assertEquals(obj_OnboardStep7.getErrorText_EmptyWeight(), errorMessage);
		logger.info("Please enter weight");
	}

	@When("User clicks continue button after entering invalid weight")
	public void user_clicks_continue_button_after_entering_invalid_weight() {

		obj_OnboardStep7.enterInvalidWeight();
		obj_OnboardStep6.clickContinueBtn();
	}

	@Then("Error message {string} shouldbe displayed for invalid weight")
	public void error_message_shouldbe_displayed_for_invalid_weight(String errorMessage) {

		Assert.assertEquals(obj_OnboardStep7.getErrorText_InvalidWeight(), errorMessage);
		logger.info("Please enter weight");
	}

	@When("User clicks continue button without entering height")
	public void user_clicks_continue_button_without_entering_height() {

		obj_OnboardStep7.enterEmptyHeight();
		obj_OnboardStep6.clickContinueBtn();
	}

	@Then("Error message {string} should be displayed for empty height")
	public void error_message_should_be_displayed_for_empty_height(String errorMessage) {

		Assert.assertEquals(obj_OnboardStep7.getErrorText_EmptyHeight(), errorMessage);
		logger.info("Please enter height");
	}

	@When("User clicks continue button after entering invalid height")
	public void user_clicks_continue_button_after_entering_invalid_height() {

		obj_OnboardStep7.enterInvalidHeight();
		obj_OnboardStep6.clickContinueBtn();
	}

	@Then("Error message {string} should be displayed for invalid height")
	public void error_message_should_be_displayed_for_invalid_height(String errorMessage) {

		Assert.assertEquals(obj_OnboardStep7.getErrorText_InvalidHeight(), errorMessage);
		logger.info("Please enter wheight");
	}

	@When("User clicks weight\\(kg) dropdown")
	public void user_clicks_weight_kg_dropdown() {

		obj_OnboardStep7.isKGUnit_Visible();
		obj_OnboardStep7.isLBSUnit_Visible();
	}

	@Then("weight Options {string} and {string} should be displayed")
	public void weight_options_and_should_be_displayed(String kg, String lbs) {

		Assert.assertEquals(obj_OnboardStep7.getText_KGUnit(),kg);
		Assert.assertEquals(obj_OnboardStep7.getText_LBSUnit(),lbs);
	}

	@When("User clicks height\\(cm) dropdown")
	public void user_clicks_height_cm_dropdown() {

		obj_OnboardStep7.isCMunit_Visible();
	}

	@Then("height Options {string} and {string} should be displayed")
	public void height_options_and_should_be_displayed(String string, String string2) {

		Assert.assertEquals(obj_OnboardStep7.getText_CMunit(), string);
		Assert.assertEquals(obj_OnboardStep7.getText_CMunit(), string2);
	}

	@When("User enters valid height and weight")
	public void user_enters_valid_height_and_weight() {

		obj_OnboardStep7.enterWeight();
		obj_OnboardStep7.enterHeight();
	}

	@Then("BMI bar should be displayed")
	public void bmi_bar_should_be_displayed() {
		
		Assert.assertTrue(obj_OnboardStep7.isBMI_BarVisible());
	}

	@Then("Redirected to Step8")
	public void redirected_to_step8() {

		String actualStepNumber = onBoardingPage.getProcessBarStepNumber();
		Assert.assertTrue(actualStepNumber.contains("8"));

	}

}
