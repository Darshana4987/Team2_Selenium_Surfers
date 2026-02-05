package com.herBalance.stepDefinitions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import com.herBalance.driverFactory.DriverFactory;
import com.herBalance.pageObjects.LoginPageObject;
import com.herBalance.pageObjects.SubscriptionSlide26Page;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SubscriptionSlide26StepDefinition {
	private static Logger logger = LogManager.getLogger();
	private SubscriptionSlide26Page subscriptionSlide26Page;
	private LoginPageObject loginPageObject;
	WebDriverWait wait;
	//private final Scenario scenario;
    
	public SubscriptionSlide26StepDefinition() {
		subscriptionSlide26Page = new SubscriptionSlide26Page(DriverFactory.getDriver());
		loginPageObject = new LoginPageObject(DriverFactory.getDriver());
		//this.scenario = scenario;
	}
	
	@Given("User logged in to Her balance application and is on dashboard")
	public void user_logged_in_to_her_balance_application_and_is_on_dashboard() {
		loginPageObject.getusernamePwd();
		loginPageObject.loginbtn();
		logger.info("Logging in Her balance application");
	}

	@When("The user clicks on profile button on dashboard")
	public void the_user_clicks_on_profile_button_on_dashboard() {
	  
		subscriptionSlide26Page.clickProfileButton();
		logger.info("Clicked Profile button on dashboard");
	}

	@When("The user clicks Subscription option from the profile dropdown")
	public void the_user_clicks_subscription_option_from_the_profile_dropdown() {
		subscriptionSlide26Page.clickSubscriptionOption();
		logger.info("Clicked Subscription Option from profile dropdown");
	}

	@Then("The user navigates to Subscription page")
	public void the_user_navigates_to_subscription_page() {
		
		Assert.assertTrue(subscriptionSlide26Page.getUrl().contains("subscription"), "Failed");
		//Assert.assertEquals(subscriptionSlide26Page.getTitle(), "HerBalance - Women's Health & Weight Loss App");
		logger.info("Navigated to Subscription page");
	}

	@Then("The User should see Subscription page {string} element as {string} value")
	public void the_user_should_see_subscription_page_element_as_value(String Subselement, String Subsvalue) {
		subscriptionSlide26Page.seeSubscriptionPageElement(Subselement, Subsvalue);
		
	}
	
}
