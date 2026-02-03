package com.herBalance.stepDefinitions;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.herBalance.driverFactory.DriverFactory;
import com.herBalance.pageObjects.SubscriptionSlide26Page;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SubscriptionSlide26StepDefinition {
	
	private SubscriptionSlide26Page subscriptionSlide26Page;
	//private final Scenario scenario;
    
	public SubscriptionSlide26StepDefinition() {
		subscriptionSlide26Page = new SubscriptionSlide26Page(DriverFactory.getDriver());
		//this.scenario = scenario;
	}
	WebDriverWait wait;

	@Given("User logged in to Her balance application and is on dashboard")
	public void user_logged_in_to_her_balance_application_and_is_on_dashboard() {
		subscriptionSlide26Page.loginPage();
	}

	@When("The user clicks on profile button on dashboard")
	public void the_user_clicks_on_profile_button_on_dashboard() {
	  
		subscriptionSlide26Page.clickProfileButton();
	}

	@When("The user clicks Subscription option from the profile dropdown")
	public void the_user_clicks_subscription_option_from_the_profile_dropdown() {
		subscriptionSlide26Page.clickSubscriptionOption();
	}

	@Then("The user navigates to Subscription page")
	public void the_user_navigates_to_subscription_page() {
		
	//	Assert.assertTrue(subscriptionSlideNo26Page.getUrl().contains("subscription"), "Failed");
		Assert.assertEquals(subscriptionSlide26Page.getTitle(), "HerBalance - Women's Health & Weight Loss App");
	}

	@Then("The User should see Subscription page {string} element as {string} value")
	public void the_user_should_see_subscription_page_element_as_value(String Subselement, String Subsvalue) {
		subscriptionSlide26Page.seeSubscriptionPageElement(Subselement, Subsvalue);
		
	}
	
	
	
}
