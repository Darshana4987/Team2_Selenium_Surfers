package com.herBalance.stepDefinitions;

import org.testng.Assert;

import com.herBalance.driverFactory.DriverFactory;
import com.herBalance.pageObjects.OnBoardingPagePart1;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class OnBoardingStepDefinitionsStep3 {
	private OnBoardingPagePart1 onBoardingPage;

	public OnBoardingStepDefinitionsStep3() {
		onBoardingPage = new OnBoardingPagePart1(DriverFactory.getDriver());
	}

	@When("User clicks continue without report")
	public void user_clicks_continue_without_report() {
		onBoardingPage.clickContunueWithOutReportButton();
	}

	@Then("OnBoarding progress bar is displayed")
	public void on_boarding_progress_bar_is_displayed() {
		Assert.assertTrue(onBoardingPage.isOnBoardingProcessBarVisible());
	}

	@Then("Back button is displayed")
	public void back_button_is_displayed() {
		Assert.assertTrue(onBoardingPage.isBackButtonVisible());
	}

	@Then("Back button should be enabled")
	public void back_button_should_be_enabled() {
		Assert.assertTrue(onBoardingPage.isBackButtonEnabled());
	}

	@Then("Continue button should be visible")
	public void continue_button_should_be_visible() {
		Assert.assertTrue(onBoardingPage.isContinueButtonVisible());
	}

	@Then("Continue button should be enabled")
	public void continue_button_should_be_enabled() {
		Assert.assertTrue(onBoardingPage.isContinueButtonEnabled());
	}

	@Then("Header should be {string}")
	public void header_should_be(String expectedHeader) {
		Assert.assertEquals(onBoardingPage.getHealthConditionHeader(), expectedHeader);
	}

	@Then("{string} header title should be displayed")
	public void header_title_should_be_displayed(String expectedTitle) {
		Assert.assertEquals(onBoardingPage.getWantToManuallyQuestionTitle(), expectedTitle);

	}

	@Then("{int} radio buttons should be visible")
	public void radio_buttons_should_be_visible(Integer expectedRadioButtonCount) {
		Assert.assertEquals(onBoardingPage.getradioButtonsCount(), expectedRadioButtonCount);
	}

	@Then("Following radio button {string} should be visible")
	public void following_radio_button_should_be_visible(String radioButtonOption) {
		Assert.assertTrue(onBoardingPage.isRadioButtonLabelVisible(radioButtonOption));
	}

	@Then("Note text should be displayed")
	public void note_text_should_be_displayed() {
		Assert.assertTrue(onBoardingPage.isNoteTextVisible());
	}

//Step3 functionality
	@Given("User is in step3 of onboarding")
	public void user_is_in_step3_of_onboarding() {
		onBoardingPage.gotoSignPage();
		onBoardingPage.clickRgister();
		onBoardingPage.clickContunueWithOutReportButton();
		onBoardingPage.clickContinue();
	}

	@When("User clicks continue by selecting one or more health conditions")
	public void user_clicks_continue_by_selecting_one_or_more_health_conditions() {
		onBoardingPage.clickToSelectHealthCondition();
	}

	@Then("Redirected to Step4")
	public void redirected_to_step4() {
		String actualStepNumber = onBoardingPage.getProcessBarStepNumber();
		Assert.assertTrue(actualStepNumber.contains("4"));
	}

	@Then("Should see the title {string}")
	public void should_see_the_title(String expectedTitle) {
		// Assert.assertEquals(onBoardingPage.getTitleForStep4(),expectedTitle);
		Assert.assertEquals(onBoardingPage.getTitleForAllSteps(), expectedTitle);
	}

	@Then("Description text {string} should be displayed")
	public void description_text_should_be_displayed(String expectedDescription) {
		Assert.assertEquals(onBoardingPage.getDescriptionTextForStep4(), expectedDescription);
	}

	@Then("{int} input boxes are visible")
	public void input_boxes_are_visible(Integer expectedInputBoxCount) {
		Assert.assertEquals(onBoardingPage.getInputBoxCount(), expectedInputBoxCount);
	}

	@Then("Input {string} labels should be visible")
	public void input_labels_should_be_visible(String expectedInputBoxLabel) {
		Assert.assertTrue(onBoardingPage.isInputLabelVisible(expectedInputBoxLabel));
	}

	@Then("Under each field following {string} should be displayed")
	public void under_each_field_following_should_be_displayed(String expectedHelperText) {
		Assert.assertTrue(onBoardingPage.isHelperTextVisible(expectedHelperText));
	}

	@Then("{int} radio button should be visible on step4")
	public void radio_button_should_be_visible_on_step4(Integer expectedCount) {
		Assert.assertEquals(onBoardingPage.getRadioButtonCountForStep4(), expectedCount);
	}

	@Then("Radio button {string} for blood pressure should be displayed")
	public void radio_button_for_blood_pressure_should_be_displayed(String expectedLabel) {
		Assert.assertTrue(onBoardingPage.isBloodPressureOptionsLabelVisible(expectedLabel));
	}

}
