package com.herBalance.stepDefinitions;

import org.testng.Assert;

import com.herBalance.driverFactory.DriverFactory;
import com.herBalance.pageObjects.OnBoardingPagePart1;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class OnBoardingStepDefinitionStep5 {
	private OnBoardingPagePart1 onBoardingPage;

	public OnBoardingStepDefinitionStep5() {
		onBoardingPage = new OnBoardingPagePart1(DriverFactory.getDriver());
	}

	@Given("User is in step5 of onboarding")
	public void user_is_in_step5_of_onboarding() {
		onBoardingPage.gotoSignPage();
		onBoardingPage.clickRgister();
		onBoardingPage.clickContunueWithOutReportButton();
		onBoardingPage.clickContinue();
		onBoardingPage.giveValidPersonalDetails();
		onBoardingPage.clickContinue();
	}

	@When("User clicks continue button without selecting menstrual cycle")
	public void user_clicks_continue_button_without_selecting_menstrual_cycle() {
		onBoardingPage.clickContinue();
	}

	@Then("Error message {string} should be displayed")
	public void error_message_should_be_displayed(String errorMessage) {
		Assert.assertTrue(onBoardingPage.isErrorMessageDisplayed());
	}

	@When("User clicks back button in step5")
	public void user_clicks_back_button_in_step5() {
		onBoardingPage.clickBackButton();
	}

	@Then("Redirected to Step {int}")
	public void redirected_to_step(Integer expectedStepNumber) {
		String actualStepNumber = onBoardingPage.getProcessBarStepNumber();
		Assert.assertTrue(actualStepNumber.contains(expectedStepNumber.toString()));
	}

	@When("User clicks continue after selecting menstrual cycle info")
	public void user_clicks_continue_after_selecting_menstrual_cycle_info() {
		onBoardingPage.selectMenstralCycleInfo();
		onBoardingPage.clickContinue();
	}

	@Then("Calendar icon should be visible inside the date input field")
	public void calendar_icon_should_be_visible_inside_the_date_input_field() {
		Assert.assertTrue(onBoardingPage.isCalendarIconVisible());
	}

	@Then("Date input field with placeholder mm\\/dd\\/yyyy should be displayed")
	public void date_input_field_with_placeholder_mm_dd_yyyy_should_be_displayed() {
		Assert.assertTrue(onBoardingPage.getDateInputField());
	}

	@Then("Label {string} should be visible")
	public void label_should_be_visible(String expectedLabel) {
		Assert.assertEquals(onBoardingPage.getLabelUnderDateField(), expectedLabel);
	}

	@Then("Slider control for cycle length should be displayed")
	public void slider_control_for_cycle_length_should_be_displayed() {
		Assert.assertTrue(onBoardingPage.isSliderControlVisible());
	}

	@Then("Default cycle length value e.g., {string} should be shown beside the slider")
	public void default_cycle_length_value_e_g_should_be_shown_beside_the_slider(String expectedValue) {
		Assert.assertEquals(onBoardingPage.getCycleLengthValue(), expectedValue);
	}

	@Then("Information text {string} should be visible")
	public void information_text_should_be_visible(String expectedText) {
		Assert.assertEquals(onBoardingPage.getInformationText(), expectedText);
	}
}
