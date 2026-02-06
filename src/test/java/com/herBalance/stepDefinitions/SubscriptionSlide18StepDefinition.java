package com.herBalance.stepDefinitions;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

import com.herBalance.driverFactory.DriverFactory;
import com.herBalance.pageObjects.OnBoardingPageCommon;
import com.herBalance.pageObjects.OnBoardingPagePart2;
import com.herBalance.pageObjects.SubscriptionSlide18Page;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SubscriptionSlide18StepDefinition {
	private static final Logger logger = LoggerFactory.getLogger(SubscriptionSlide18StepDefinition.class);

	private OnBoardingPageCommon onBoardingPageCommon;
	private OnBoardingPagePart2 onBoardingPagePart2;
	private SubscriptionSlide18Page subscriptionSlide18;
	
	public SubscriptionSlide18StepDefinition() {
		onBoardingPageCommon = new OnBoardingPageCommon(DriverFactory.getDriver());
		onBoardingPagePart2 = new OnBoardingPagePart2(DriverFactory.getDriver());
		subscriptionSlide18 = new SubscriptionSlide18Page(DriverFactory.getDriver());
	}

	@Given("User completes onboarding process until step10")
	public void user_completes_onboarding_process_until_step10() {
		
		onBoardingPageCommon.navigatesToStep5();

		onBoardingPagePart2.clickMenstrualCycleAwarenessOptions();
		onBoardingPageCommon.clickContinue();  //step 5

		onBoardingPagePart2.enterlastMenstrualDate(); // Step 6
		onBoardingPageCommon.clickContinue();
		
		onBoardingPagePart2.enterWeight();
		onBoardingPagePart2.enterHeight();
		onBoardingPageCommon.clickContinue(); //step7
		
		subscriptionSlide18.clickDietPreferences();
		onBoardingPageCommon.clickContinue(); //step8
		
		subscriptionSlide18.clickPhysicalActivity();
		onBoardingPageCommon.clickContinue();  //step9
		
		subscriptionSlide18.clickFoodAllergy();
		onBoardingPageCommon.clickContinue();  //step10
		
	}

	@Given("User is on step11 onboarding process")
	public void user_is_on_step11_onboarding_process() {
		subscriptionSlide18.clickMedications();
	}

	@When("User click complete after entering required medication details")
	public void user_click_complete_after_entering_required_medication_details() {
		subscriptionSlide18.clickComplete();
		logger.info("Finished onboarding process");
	}

	@Then("Choose Your Transformation Journey header is visible")
	public void choose_your_transformation_journey_header_is_visible() {
	    Assert.assertTrue(subscriptionSlide18.getSubscriptionHeader().isDisplayed(), "Header not visible");
	}

	@Then("All Plans subtext header is visible to the user")
	public void all_plans_subtext_header_is_visible_to_the_user() {
		Assert.assertTrue(subscriptionSlide18.getsubheaderText().isDisplayed(), "sub header text not visible");
	}

	@Then("User should see three subscription plan tiles")
	public void user_should_see_three_subscription_plan_tiles() {
	    List<WebElement> tiles = subscriptionSlide18.getPlanTiles();
	    Assert.assertTrue(tiles.size() == 3);
	}
	
	@Then("{string} section title is displayed inside free plan tile")
	public void section_title_is_displayed_inside_free_plan_tile(String text) {
	    Assert.assertTrue(subscriptionSlide18.planTitleTextDisplayed(text), text + "title not displayed");
	}
	
	@Then("{string} should be displayed for section title")
	public void text_should_be_displayed_for_section_title(String text) {
		Assert.assertTrue(subscriptionSlide18.planTitleSubTextDisplayed(text), text + "sub text under title not displayed");
	}

	@Then("{string} header text should be displayed inside the plan tile")
	public void header_text_should_be_displayed_inside_the_plan_tile(String text) {
		Assert.assertTrue(subscriptionSlide18.planHeaderTextDisplayed(text), text + "header not visible");
	}
	
	@Then("{string} sub header text should be displayed inside plan tile")
	public void sub_header_text_should_be_displayed_inside_plan_tile(String text) {
		Assert.assertTrue(subscriptionSlide18.planHeaderSubTextDisplayed(text), text + "sub header not visible");
	}
	
	@Then("{string} message should be visible for free plan checklist")
	public void message_should_be_visible_for_free_plan_checklist(String text)  {
		Assert.assertTrue(subscriptionSlide18.freePlanCheckListDisplayed(text), text + "checklist message not displayed");
	}
	
	@Then("{string} message should be visible for monthly plan checklist")
	public void message_should_be_visible_for_monthly_plan_checklist(String text) {
		Assert.assertTrue(subscriptionSlide18.monthlyPlanCheckListDisplayed(text), text + "checklist message not displayed");
	}

	@Then("{string} message should be visible for three month plan checklist")
	public void message_should_be_visible_for_three_month_plan_checklist(String text) {
		Assert.assertTrue(subscriptionSlide18.threeMonthPlanCheckListDisplayed(text), text + "checklist message not displayed");
	}

	@Then("User should be able to see subscribe now button for {string} tile")
	public void user_should_be_able_to_see_subscribe_now_button_for_tile(String text) {
		WebElement element = subscriptionSlide18.getSubscribeNowButton(text);
		Assert.assertTrue(subscriptionSlide18.getSubscribeNowButton(text).isDisplayed());
		Assert.assertEquals(element.getText(), "Subscribe Now", "Subscribe Now button not visible for " + text);
	}

	@Then("subscribe now button for {string} tile should be enabled")
	public void subscribe_now_button_for_tile_should_be_enabled(String text) {
	    Assert.assertTrue(subscriptionSlide18.getSubscribeNowButton(text).isEnabled(), "subscribe now button for "+text+ "not enabled");
	}
}
