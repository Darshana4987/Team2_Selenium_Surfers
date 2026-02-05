package com.herBalance.stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import com.herBalance.driverFactory.DriverFactory;
import com.herBalance.pageObjects.ActivityInsightsWTPage;
import com.herBalance.pageObjects.LoginPageObject;

public class ActivityInsightsWTStepDefinition {
	
	private static Logger logger = LogManager.getLogger();
	private ActivityInsightsWTPage activityInsightsWTPage;
	private LoginPageObject loginPageObject;

	public ActivityInsightsWTStepDefinition() {
		activityInsightsWTPage = new ActivityInsightsWTPage(DriverFactory.getDriver());
		loginPageObject = new LoginPageObject(DriverFactory.getDriver());
	}

	@Given("The User logged in to Her balance application and is on dashboard")
	public void the_user_logged_in_to_her_balance_application_and_is_on_dashboard() {
		loginPageObject.getusernamePwd();
		loginPageObject.loginbtn();
		logger.info("Logging in Her balance application");
	}

	@When("The user clicks on Activity Insights button on dashboard")
	public void the_user_clicks_on_activity_insights_button_on_dashboard() {
		Assert.assertTrue(activityInsightsWTPage.clickActivityInsights(),"Activity Insight Menu Clicked.");
	}

	@Then("The user clicks Track Weight option from dropdown")
	public void the_user_clicks_track_weight_option_from_dropdown() {
		Assert.assertTrue(activityInsightsWTPage.clickTrackWeight(),"Track Weight Button Clicked");
	}

	@Then("The user sees the Weight Tracking page")
	public void the_user_sees_the_weight_tracking_page() {
		Assert.assertTrue(activityInsightsWTPage.getUrl().contains("weight"), "Failed");
	}
	
	@Then("The User should see Weight Tracking page {string} element as {string} value")
	public void the_user_should_see_weight_tracking_page_element_as_value(String element, String value) {
		Assert.assertTrue(activityInsightsWTPage.seeTrackWeightPageElement(element,value),value+" "+element+" Present ");
	}

	@Then("The user clicks Log Weight button after entering weight {string}, expect {string} message")
	public void the_user_clicks_log_weight_button_after_entering_valid_invalid_value_in_weight(String weight, String logMessage) {
		Assert.assertTrue(activityInsightsWTPage.logWeightPageElement(weight,logMessage),"Expected Current Weight value"+weight);

	}

	@Then("Entered weight {string} should be added to the Current Weight card")
	public void entered_weight_should_be_added_to_the_current_weight_card_display_message(String weight) {
		Assert.assertTrue(activityInsightsWTPage.verifyCurrentWeightElement(weight),"Change in Current Weight value.");
	}

	@Then("User clicks Back to Dashboard button")
	public void back_to_dashboard() {
		Assert.assertTrue(activityInsightsWTPage.backToDashboard()," Dashboard page should display.");
	}


	@Then("It should display Dashboard page")
	public void it_should_display_dashboard_page() {
		Assert.assertTrue(activityInsightsWTPage.getUrl().contains("dashboard"), "Failed");
	}

}
