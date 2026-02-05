package com.herBalance.stepDefinitions;

import com.herBalance.driverFactory.DriverFactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.herBalance.pageObjects.LaunchPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LaunchSteps {

	private LaunchPage launchPageObject;

	public LaunchSteps() {
		launchPageObject = new LaunchPage(DriverFactory.getDriver());
	}

	WebDriverWait wait;

	@Given("The user is on herbalance home page")
	public void the_user_is_on_herbalance_home_page() {
		launchPageObject.getUrl();
	}

	@When("User clicks Sign Up button")
	public void user_clicks_sign_up_button() {
		launchPageObject.clickSignupBtn();
	}

	@When("User clicks Get Started button")
	public void user_clicks_get_started_button() {
		launchPageObject.GetStartedBtn();
	}

	@When("User clicks Start your personalized journey button")
	public void user_clicks_start_your_personalized_journey_button() {
		launchPageObject.StartYourJourneyBtn();
	}

	@Then("User should be navigated to auth page Signup tab")
	public void user_should_be_navigated_to_auth_page_signup_tab() {
		String titleSignup = launchPageObject.Siguppagedisplayed();
		Assert.assertEquals(titleSignup, "Sign Up");
	}

	@When("the user clicks Login button")
	public void the_user_clicks_login_button() {
		launchPageObject.clickLoginBtn();
	}

	@Then("User should be navigated to auth page Login tab")
	public void user_should_be_navigated_to_auth_page_login_tab() {
		String titleLogin = launchPageObject.Loginpagedisplayed();
		Assert.assertEquals(titleLogin, "Login");
	}

	@Given("User is on the browser")
	public void user_is_on_the_browser() {
		launchPageObject.getUrl();
	}

	@When("User enters app url")
	public void user_enters_app_url() {

	}

	@Then("Display cards for different phases are displayed")
	public void display_cards_for_different_phases_are_displayed() {
		launchPageObject.CyclePhases();
	}

	@Then("the page with Sign Up button should be displayed")
	public void the_page_with_sign_up_button_should_be_displayed() {
		launchPageObject.displaySignupBtn();
	}

	@Then("the page with Get Started button should be displayed")
	public void the_page_with_get_started_button_should_be_displayed() {
		launchPageObject.displayGetStartedBtn();
	}

	@Then("the page with Start your personalized journey button should be displayed")
	public void the_page_with_start_your_personalized_journey_button_should_be_displayed() {
		launchPageObject.displayStartYourJourneyBtn();
	}

	@Then("the page with login button should be displayed")
	public void the_page_with_login_button_should_be_displayed() {
		launchPageObject.displayLoginBtn();
	}

	@Then("Details about the Cycle Tracking App and its features are displayed")
	public void details_about_the_cycle_tracking_app_and_its_features_are_displayed() {
		launchPageObject.CycleTrackApp();
	}

	@Then("Images in Sync should be displayed")
	public void images_in_sync_should_be_displayed() {
		launchPageObject.Imagedisplayed();
	}

	@Then("Display information about hormonal shifts and metabolism during the menstrual cycle")
	public void display_information_about_hormonal_shifts_and_metabolism_during_the_menstrual_cycle() {
		launchPageObject.Empowertitledisplayed();
	}

	@Then("User should see a light purple background and readable text content")
	public void user_should_see_a_light_purple_background_and_readable_text_content() {
		Assert.assertTrue(launchPageObject.backgroundcolorandtext(), "Light purple gradient is missing");

		Assert.assertTrue(launchPageObject.ReadableText(), "Readable text is not visible");

	}

}
