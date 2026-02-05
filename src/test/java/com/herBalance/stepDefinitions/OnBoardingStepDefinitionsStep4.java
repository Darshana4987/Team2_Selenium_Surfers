package com.herBalance.stepDefinitions;

import org.testng.Assert;

import com.herBalance.driverFactory.DriverFactory;
import com.herBalance.pageObjects.OnBoardingPagePart1;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class OnBoardingStepDefinitionsStep4 {
	private OnBoardingPagePart1 onBoardingPage;

	public OnBoardingStepDefinitionsStep4() {
		onBoardingPage = new OnBoardingPagePart1(DriverFactory.getDriver());
	}

	@Given("User is in step4 of onboarding")
	public void user_is_in_step4_of_onboarding() {
		onBoardingPage.gotoSignPage();
		onBoardingPage.clickRgister();
		onBoardingPage.clickContunueWithOutReportButton();
		onBoardingPage.clickContinue();
	}

	@When("User clicks continue button after entering {string} in first name")
	public void user_clicks_continue_button_after_entering_in_first_name(String firstName) {
		onBoardingPage.enterInvalidValuesIntoPersonalDetails(firstName);
		onBoardingPage.clickContinue();
	}

	@Then("Error message {string} should be displayed in Step4")
	public void error_message_should_be_displayed_in_step4(String errorMessage) {
		Assert.assertTrue(onBoardingPage.getErrorMsgForInvalidValues(errorMessage));
	}

	@When("User clicks continue button after entering {string} in age")
	public void user_clicks_continue_button_after_entering_in_age(String age) {
		onBoardingPage.enterInvalidAge(age);
		onBoardingPage.clickContinue();
	}

	@When("User clicks continue button without selecting blood pressure status")
	public void user_clicks_continue_button_without_selecting_blood_pressure_status() {
		onBoardingPage.clickContinue();
	}

	@When("User clicks back button in step4")
	public void user_clicks_back_button_in_step4() {
		onBoardingPage.clickBackButton();
	}

	@When("User clicks continue after entering all required details")
	public void user_clicks_continue_after_entering_all_required_details() {
		onBoardingPage.giveValidPersonalDetails();
		onBoardingPage.clickContinue();
	}

	@Then("Redirected to Step5")
	public void redirected_to_step5() {
		String actualStepNumber = onBoardingPage.getProcessBarStepNumber();
		Assert.assertTrue(actualStepNumber.contains("5"));
	}

	@Then("Continue button should be enabled after selecting currently tracking option")
	public void continue_button_should_be_enabled_after_selecting_currently_tracking_option() {
		Assert.assertTrue(onBoardingPage.isContinueButtonEnabledForStep5());
	}

	@Then("Description text {string}")
	public void description_text(String descriptionText) {
		Assert.assertEquals(onBoardingPage.getDescriptionTextForSteps(), descriptionText);
	}

	@Then("Question {string} should be visible")
	public void question_should_be_visible(String expectedQuestion) {
		Assert.assertEquals(onBoardingPage.getQuestionAboutMestruation(), expectedQuestion);
	}

	@Then("{int} radio button should be visible on step5")
	public void radio_button_should_be_visible_on_step5(Integer expectedRadioButtonCount) {
		Assert.assertEquals(onBoardingPage.getRadioButtonCountForStep5(), expectedRadioButtonCount);
	}

	@Then("Radio {string} for  menstrual cycle awareness should be displayed")
	public void radio_for_menstrual_cycle_awareness_should_be_displayed(String expectedOption) {
		Assert.assertTrue(onBoardingPage.getMenstrualCycleAwarenessOptions(expectedOption));
	}

}
