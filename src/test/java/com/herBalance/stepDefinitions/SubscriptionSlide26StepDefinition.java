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

    
	public SubscriptionSlide26StepDefinition() {
		subscriptionSlide26Page = new SubscriptionSlide26Page(DriverFactory.getDriver());
		loginPageObject = new LoginPageObject(DriverFactory.getDriver());

	}
	
	@Given("User logged in to Her balance application and is on dashboard")
	public void user_logged_in_to_her_balance_application_and_is_on_dashboard() {
		loginPageObject.getusernamePwd();
		loginPageObject.loginbtn();
		//Assert.assertTrue(subscriptionSlide26Page.getUrl().contains("dashboard"), "Failed");
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
		Assert.assertTrue(subscriptionSlide26Page.getUrl().contains("subscription"), "Failed");
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
		Assert.assertTrue(subscriptionSlide26Page.seeSubscriptionPageElement(Subselement, Subsvalue), Subselement+" "+Subsvalue+" Present ");
		
	}
	
	@Then("User Click on Go To Dashboard Button in Current Subscription section")
	public void user_click_on_goto_dashboard_button_in_current_subscription_section() { 
		Assert.assertTrue(subscriptionSlide26Page.gotoDashboardCurrent(),"Dashboard Page Displayed.");
		logger.info("Clicked Goto Dashboard from Current Subscription Section");
	}
	
	@Then("User Click on Go To Dashboard Button in Subscription History section")
	public void user_click_on_goto_dashboard_button_in_subscription_history_section() {
		Assert.assertTrue(subscriptionSlide26Page.gotoDashboardHistory(),"Dashboard Page Displayed.");
		logger.info("Clicked Goto Dashboard from Subscription History Section");
	}

	@Then("The User should see Dashboard page")
	public void the_user_should_see_dashboard_page() {
		
		Assert.assertTrue(subscriptionSlide26Page.getUrl().contains("dashboard"), "Failed");
		logger.info("Navigated to Subscription page");
	}
	
	@Then("User Click on View Available Plans Button")
	public void user_click_on_view_available_plans_button() {
		Assert.assertTrue(subscriptionSlide26Page.viewAllPlans(),"All Plans page displayed.");
		logger.info("Clicked Goto Dashboard from Current Subscription Section");
	}

	@Then("The User should see All Plans page")
	public void the_user_should_see_all_plans_page() {
		
		Assert.assertTrue(subscriptionSlide26Page.getUrl().contains("/plans"), "Failed");
		logger.info("Navigated to Subscription page");
	}
}
