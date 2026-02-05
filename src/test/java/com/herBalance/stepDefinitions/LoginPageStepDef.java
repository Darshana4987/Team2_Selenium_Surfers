package com.herBalance.stepDefinitions;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.herBalance.driverFactory.DriverFactory;
import com.herBalance.pageObjects.DashboardPage1;
import com.herBalance.pageObjects.LoginPageObject;
import com.herBalance.pageObjects.WorkoutPage;

import io.cucumber.java.en.*;

public class LoginPageStepDef {

	private LoginPageObject loginPageObject;

	private DashboardPage1 dashboardPage;

	public LoginPageStepDef() {
		loginPageObject = new LoginPageObject(DriverFactory.getDriver());
	}

	WebDriverWait wait;

	@Given("User is on the HerBalance auth page")
	public void user_is_on_the_her_balance_auth_page() {
		loginPageObject.geturll();
	}

	@When("User clicks the login button after entering valid username and password")
	public void user_clicks_the_login_button_after_entering_valid_username_and_password() {
		loginPageObject.getusernamePwd();
		loginPageObject.loginbtn();
	}

	@Then("user should be redirected to the dashboard")
	public void user_should_be_redirected_to_the_dashboard() throws InterruptedException {

		Assert.assertTrue(loginPageObject.isDashboardLoaded());

	}

	@Then("The user should see the {string} title")
	public void the_user_should_see_the_title(String string) {
		
		dashboardPage = new DashboardPage1(DriverFactory.getDriver());
		Assert.assertTrue(dashboardPage.isProfileNameDisplayed());

	}

	@Then("The user should see the username on the top right corner of the dashboard page")
	public void the_user_should_see_the_username_on_the_top_right_corner_of_the_dashboard_page() {

		dashboardPage = new DashboardPage1(DriverFactory.getDriver());
		Assert.assertTrue(dashboardPage.isUserNameDisplayed());

	}

	@Then("User should be able to see {string} in login page")
	public void user_should_be_able_to_see_in_login_page(String tabName) {
		Assert.assertTrue(loginPageObject.isTabVisible(tabName), tabName + " tab is not displayed on the login page");
	}

	@Then("User should see the HerBalance logo on the page")
	public void user_should_see_the_her_balance_logo_on_the_page() {
		Assert.assertTrue(loginPageObject.verifyLogo().isDisplayed(), "Logo is not displayed on the page");
	}

	@Then("Login tab should be active")
	public void login_tab_should_be_active() {
		Assert.assertTrue(loginPageObject.isLoginTabActive(), "Login tab is not active by default");
	}

	@Then("Email ID input field with placeholder {string} should be visible")
	public void email_id_input_field_with_placeholder_should_be_visible(String placeholderText) {

		Assert.assertTrue(loginPageObject.isEmailFieldVisibleWithPlaceholder(placeholderText),
				"Email ID input field with placeholder '" + placeholderText + "' is not visible");
	}

	@Then("Password input field with masked entry should be visible")
	public void password_input_field_with_masked_entry_should_be_visible() {

		Assert.assertTrue(loginPageObject.isPasswordFieldVisibleAndMasked(),
				"Password input field with masked entry is not visible");
	}

	@Then("Show password option should be visible")
	public void show_password_option_should_be_visible() {

		Assert.assertTrue(loginPageObject.isShowPasswordOptionVisible(),
				"Show password option is not visible on the login page");
	}
}