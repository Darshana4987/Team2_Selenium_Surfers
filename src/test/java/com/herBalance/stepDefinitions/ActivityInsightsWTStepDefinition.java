package com.herBalance.stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.testng.Assert;

import com.herBalance.driverFactory.DriverFactory;
import com.herBalance.pageObjects.ActivityInsightsWTPage;

public class ActivityInsightsWTStepDefinition {

	private ActivityInsightsWTPage activityInsightsWTPage;
	
	public ActivityInsightsWTStepDefinition() {
		activityInsightsWTPage = new ActivityInsightsWTPage(DriverFactory.getDriver());
		//this.scenario = scenario;
	}
	
	@Given("The User logged in to Her balance application and is on dashboard")
	public void the_user_logged_in_to_her_balance_application_and_is_on_dashboard() {
		activityInsightsWTPage.loginPage();
	}

	@When("The user clicks on Activity Insights button on dashboard")
	public void the_user_clicks_on_activity_insights_button_on_dashboard() {
		activityInsightsWTPage.clickActivityInsights();
	}

	@Then("The user clicks Track Weight option from dropdown")
	public void the_user_clicks_track_weight_option_from_dropdown() {
		activityInsightsWTPage.clickTrackWeight();
	}

	@Then("The user navigates to Weight Tracking page")
	public void the_user_navigates_to_weight_tracking_page() {
	 
	}

	@Then("The user clicks Weight Tracking option from dropdown")
	public void the_user_clicks_weight_tracking_option_from_dropdown() {
	  
	}

	@Then("The User should see Weight Tracking page {string} element as {string} value")
	public void the_user_should_see_weight_tracking_page_element_as_value(String element, String value) {
		Assert.assertTrue(activityInsightsWTPage.seeTrackWeightPageElement(element,value),value+" "+element+" Present ");
	}

	@Given("The user is on Weight Tracking page")
	public void the_user_is_on_weight_tracking_page() {
	   
	}

	@Then("The user clicks Log Weight button after entering weight {string}, Display {string} message")
	public void the_user_clicks_log_weight_button_after_entering_valid_invalid_value_in_weight(String weight, String logMessage) {
		activityInsightsWTPage.logWeightPageElement(weight,logMessage);
	}

	@Then("Entered weight {string} should be added to the Current Weight card")
	public void entered_weight_should_be_added_to_the_current_weight_card_display_message(String weight) {
		//activityInsightsWTPage.logWeightPageElement(weight,logMessage);
	}


	
}
