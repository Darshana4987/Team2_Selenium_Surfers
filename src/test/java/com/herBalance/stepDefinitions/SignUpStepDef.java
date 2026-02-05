package com.herBalance.stepDefinitions;

import java.io.IOException;
import java.util.Map;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.herBalance.driverFactory.DriverFactory;
import com.herBalance.pageObjects.SignUpPage;
import com.herBalance.utils.ExcelReader;

import io.cucumber.java.en.*;

public class SignUpStepDef {

	private SignUpPage signupobj;

	public SignUpStepDef() {
		signupobj = new SignUpPage(DriverFactory.getDriver());

	}

	WebDriverWait wait;
	Map<String, String> testData;

	@Given("User is on the herbalance launch page")
	public void user_is_on_the_herbalance_launch_page() {

		signupobj.geturll();
	}

	@When("User clicks the Sign up button")
	public void user_clicks_the_sign_up_button() {

		signupobj.signUpButtonClick();
	}

	@Then("The email ID input field with place value {string} is displayed")
	public void the_email_id_input_field_with_place_value_is_displayed(String string) throws InterruptedException {

		Assert.assertEquals(signupobj.isEmailDisplayed(), string);

	}

	@Given("User is on the her balance auth page")
	public void user_is_on_the_her_balance_auth_page() {

		signupobj.geturll();
	}

	@When("User enters valid username,password, confirm password and clicks register button")
	public void user_enters_valid_username_password_confirm_password_and_clicks_register_button() throws IOException {

		/*
		 * Using config properties signupobj.getUserEmail(); signupobj.clickTerms();
		 * signupobj.registerButton();
		 */

		signupobj.signUpButtonClick();

		testData = ExcelReader.readExcelData("SignUp", "TC_01");

		String username = testData.get("Username");
		String password = testData.get("Password");
		String confirmPassword = testData.get("Confirm Password");

		signupobj.registerUser(username, password, confirmPassword);

	}

	@Then("The password input field with masked value should be visible")
	public void the_password_input_field_with_masked_value_should_be_visible() {

		Assert.assertTrue(signupobj.isPasswordDisplayed());
	}

	@Then("The confirm password input field with masked value should be visible")
	public void the_confirm_password_input_field_with_masked_value_should_be_visible() {

		Assert.assertTrue(signupobj.isConfirmPasswordDisplayed());
	}

	@Then("user should be landed on the onboarding step page")
	public void user_should_be_landed_on_the_onboarding_step_page() throws InterruptedException {

		Assert.assertEquals(signupobj.getUploadYourBloodWorkTitle(), "Upload Your Recent Blood Work");
		Assert.assertTrue(signupobj.isOnboardingPage());
		Thread.sleep(5000);
	}

}
