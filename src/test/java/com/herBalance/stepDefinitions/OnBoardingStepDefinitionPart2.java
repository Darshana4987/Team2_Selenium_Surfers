package com.herBalance.stepDefinitions;

import org.testng.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.herBalance.driverFactory.DriverFactory;
import com.herBalance.pageObjects.OnBoardingPagePart1;
import com.herBalance.pageObjects.OnBoardingPagePart2;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class OnBoardingStepDefinitionPart2 {
	
	private static final Logger logger = LoggerFactory.getLogger(OnBoardingStepDefinitionPart2.class);
	
	private OnBoardingPagePart2 obj_OnboardStep6 ;
	private OnBoardingPagePart1 onBoardingPage;

	public OnBoardingStepDefinitionPart2() {
		
		obj_OnboardStep6 = new OnBoardingPagePart2(DriverFactory.getDriver());
	//	onBoardingPage = new OnBoardingPagePart1(DriverFactory.getDriver());
	}
	
	@Given("User is in step six of onboarding")
	public void user_is_in_step_six_of_onboarding() {

		onBoardingPage.gotoSignPage(); // Onboard Step 2
		onBoardingPage.clickRgister();	
		onBoardingPage.clickContunueWithOutReportButton();
		 
		
	//	obj_OnboardStep6.clickHealthCondition();
		obj_OnboardStep6.clickContinueBtn(); // Step 3
		
		obj_OnboardStep6.enterPersonalDetails();
		obj_OnboardStep6.clickBloodPressureStatus();
		obj_OnboardStep6.clickContinueBtn();          // step4
		
		obj_OnboardStep6.clickMenstrualCycleAwarenessOptions();
		obj_OnboardStep6.clickContinueBtn();        // Step 5
	
		
		logger.info("You are on Onboard Process step 6");
	}

	@When("User clicks continue button without selecting last menstrual date")
	public void user_clicks_continue_button_without_selecting_last_menstrual_date() {
		
		obj_OnboardStep6.clickContinueBtn();
	}

	@Then("Error message {string} should be displayed for Step6")
	public void error_message_should_be_displayed_for_step6(String errormessage ) {
		
		Assert.assertEquals(obj_OnboardStep6.getErrorText_InvalidDate(), errormessage);
		logger.info("Please select your last period start date");
	}

	
	@When("User selects last menstrual date")
	public void user_selects_last_menstrual_date() {
		
		obj_OnboardStep6.enterlastMenstrualDate();
	}

	@When("User clicks continue after selecting last menstrual date")
	public void user_clicks_continue_after_selecting_last_menstrual_date() {
		
		obj_OnboardStep6.enterlastMenstrualDate();
		obj_OnboardStep6.clickContinueBtn();
	}

	@Then("Progress bar shows the current step {string}")
	public void progress_bar_shows_the_current_step(String progressBarCurrentStep) {
	    
		Assert.assertEquals(obj_OnboardStep6.getprogressBarCurrentStep(), progressBarCurrentStep);
		logger.info("Current progress bar shows 6 of 10");
	}

	@When("User clicks back button in step {int}")
	public void user_clicks_back_button_in_step(Integer int1) {
	  
		obj_OnboardStep6.clickBackBtn();
		// call here swori's method that user is on step 5
	}

	@Then("User redirected to back Step {int}")
	public void user_redirected_to_back_step(Integer int1) {
		// call here swori's method that user is on step 5
	}

	@Then("User redirected to next Step7")
	public void user_redirected_to_next_step7() {
	    
	}

	@When("User clicks continue button after entering invalid value in date")
	public void user_clicks_continue_button_after_entering_invalid_value_in_date() {
		
		obj_OnboardStep6.enterInvalid_lastMenstrualDate();
	   
	}
	@Then("Error message {string} should be displayed invalid value in date")
	public void error_message_should_be_displayed_invalid_value_in_date(String InvalidDateErrorMsg) {
	  
		Assert.assertEquals(obj_OnboardStep6.getErrorText_InvalidDate(), InvalidDateErrorMsg);
		logger.info("Please select your last period start date");
	}
	
	// Step 7 
	
	@Given("User is in step seven of onboarding")
	public void user_is_in_step_seven_of_onboarding() {

		onBoardingPage.gotoSignPage();
		onBoardingPage.clickRgister();
		onBoardingPage.clickContunueWithOutReportButton(); // Onboard Step 2

		obj_OnboardStep6.clickHealthCondition();
		obj_OnboardStep6.clickContinueBtn(); // Step 3

		obj_OnboardStep6.enterPersonalDetails();
		obj_OnboardStep6.clickBloodPressureStatus();
		obj_OnboardStep6.clickContinueBtn(); // step4

		obj_OnboardStep6.clickMenstrualCycleAwarenessOptions();	
		obj_OnboardStep6.clickContinueBtn(); // Step 5

		obj_OnboardStep6.enterlastMenstrualDate(); // Step 6
		obj_OnboardStep6.clickContinueBtn();

	}

	@When("User clicks continue button without entering current weight")
	public void user_clicks_continue_button_without_entering_current_weight() {

		obj_OnboardStep6.enterEmptyWeight();
		obj_OnboardStep6.clickContinueBtn();
	}

	@Then("Error message {string} should be displayed for empty weight")
	public void error_message_should_be_displayed_for_empty_weight(String errorMessage) {

		Assert.assertEquals(obj_OnboardStep6.getErrorText_EmptyWeight(), errorMessage);
		logger.info("Please enter weight");
	}

	@When("User clicks continue button after entering invalid weight")
	public void user_clicks_continue_button_after_entering_invalid_weight() {

		obj_OnboardStep6.enterInvalidWeight();
		obj_OnboardStep6.clickContinueBtn();
	}

	@Then("Error message {string} shouldbe displayed for invalid weight")
	public void error_message_shouldbe_displayed_for_invalid_weight(String errorMessage) {

		Assert.assertEquals(obj_OnboardStep6.getErrorText_InvalidWeight(), errorMessage);
		logger.info("Please enter weight");
	}

	@When("User clicks continue button without entering height")
	public void user_clicks_continue_button_without_entering_height() {

		obj_OnboardStep6.enterEmptyHeight();
		obj_OnboardStep6.clickContinueBtn();
	}

	@Then("Error message {string} should be displayed for empty height")
	public void error_message_should_be_displayed_for_empty_height(String errorMessage) {

		Assert.assertEquals(obj_OnboardStep6.getErrorText_EmptyHeight(), errorMessage);
		logger.info("Please enter height");
	}

	@When("User clicks continue button after entering invalid height")
	public void user_clicks_continue_button_after_entering_invalid_height() {

		obj_OnboardStep6.enterInvalidHeight();
		obj_OnboardStep6.clickContinueBtn();
	}

	@Then("Error message {string} should be displayed for invalid height")
	public void error_message_should_be_displayed_for_invalid_height(String errorMessage) {

		Assert.assertEquals(obj_OnboardStep6.getErrorText_InvalidHeight(), errorMessage);
		logger.info("Please enter wheight");
	}

	@When("User clicks weight\\(kg) dropdown")
	public void user_clicks_weight_kg_dropdown() {

		obj_OnboardStep6.isKGUnit_Visible();
		obj_OnboardStep6.isLBSUnit_Visible();
	}

	@Then("weight Options {string} and {string} should be displayed")
	public void weight_options_and_should_be_displayed(String kg, String lbs) {

		Assert.assertEquals(obj_OnboardStep6.getText_KGUnit(),kg);
		Assert.assertEquals(obj_OnboardStep6.getText_LBSUnit(),lbs);
	}

	@When("User clicks height\\(cm) dropdown")
	public void user_clicks_height_cm_dropdown() {

		obj_OnboardStep6.isCMunit_Visible();
	}

	@Then("height Options {string} and {string} should be displayed")
	public void height_options_and_should_be_displayed(String string, String string2) {

		Assert.assertEquals(obj_OnboardStep6.getText_CMunit(), string);
		Assert.assertEquals(obj_OnboardStep6.getText_CMunit(), string2);
	}

	@When("User enters valid height and weight")
	public void user_enters_valid_height_and_weight() {

		obj_OnboardStep6.enterWeight();
		obj_OnboardStep6.enterHeight();
	}

	@Then("BMI bar should be displayed")
	public void bmi_bar_should_be_displayed() {
		
		Assert.assertTrue(obj_OnboardStep6.isBMI_BarVisible());
	}

	@Then("Redirected to Step8")
	public void redirected_to_step8() {

		String actualStepNumber = onBoardingPage.getProcessBarStepNumber();
		Assert.assertTrue(actualStepNumber.contains("8"));

	}

	
	// Step 8
	
	@Given("User is in step eight of onboarding")
	public void user_is_in_step_eight_of_onboarding() {
		
		onBoardingPage.gotoSignPage();
		onBoardingPage.clickRgister();
		onBoardingPage.clickContunueWithOutReportButton(); // Onboard Step 2

		obj_OnboardStep6.clickHealthCondition();
		obj_OnboardStep6.clickContinueBtn(); // Step 3

		obj_OnboardStep6.enterPersonalDetails();
		obj_OnboardStep6.clickBloodPressureStatus();
		obj_OnboardStep6.clickContinueBtn(); // step4

		obj_OnboardStep6.clickMenstrualCycleAwarenessOptions();
		obj_OnboardStep6.clickContinueBtn(); // Step 5

		obj_OnboardStep6.enterlastMenstrualDate(); // Step 6
		obj_OnboardStep6.clickContinueBtn();
		
		obj_OnboardStep6.enterWeight();  //step7
		obj_OnboardStep6.enterHeight(); 
		obj_OnboardStep6.clickContinueBtn(); 
	
	}
	@When("User clicks any of the dietary options")
	public void user_clicks_any_of_the_dietary_options() {
	   
		obj_OnboardStep6.selectPescatarianRedioBtn();
		obj_OnboardStep6.clickContinueBtn(); 
	}

	@Then("Selected diet should be highlighted")
	public void selected_diet_should_be_highlighted() {
	   
		//Assert.assertTrue();
	}

	@When("User clicks continue after selecting any dietary options")
	public void user_clicks_continue_after_selecting_any_dietary_options() {
	 
		obj_OnboardStep6.clickContinueBtn();
	}

	@Then("Radio {string} for Dietary Preferences should be visible")
	public void radio_for_dietary_preferences_should_be_visible(String option) {
	
//		Assert.assertTrue("Dietary option not visible: " + option,
//				 obj_OnboardStep8.isDietaryOptionVisible(option));
//		
//		Assert.assertTrue(obj_OnboardStep8.isDietaryOptionVisible());
	}

	@Then("Radio button should be displayed in all the sections")
	public void radio_button_should_be_displayed_in_all_the_sections() {
	  
	}

	@Then("Redirected to Step9")
	public void redirected_to_step9() {
		
		String actualStepNumber = onBoardingPage.getProcessBarStepNumber();
		Assert.assertTrue(actualStepNumber.contains("9"));
	}
	
	@When("User clicks back button in step8")
	public void user_clicks_back_button_in_step8() {
	    
		obj_OnboardStep6.clickBackBtn();
	}

	@Then("Redirected to Step7")
	public void redirected_to_step7() {
	   
		String actualStepNumber = onBoardingPage.getProcessBarStepNumber();
		Assert.assertTrue(actualStepNumber.contains("7"));
		
	}
	@Given("User is in step nine of onboarding")
	public void user_is_in_step_nine_of_onboarding() {
	   
		onBoardingPage.gotoSignPage(); // Onboard Step 2
		onBoardingPage.clickRgister();	
		obj_OnboardStep6.clickContunueWithOutReportButton();   

		obj_OnboardStep6.clickHealthCondition();   // Step 3
		onBoardingPage.clickContinue();

		obj_OnboardStep6.enterPersonalDetails();    // step4
		obj_OnboardStep6.clickBloodPressureStatus();   
		onBoardingPage.clickContinue();

		obj_OnboardStep6.clickMenstrualCycleAwarenessOptions();    // Step 5
		onBoardingPage.clickContinue();

		obj_OnboardStep6.enterlastMenstrualDate(); // Step 6
		onBoardingPage.clickContinue();
		
		obj_OnboardStep6.enterWeight();  //step7
		obj_OnboardStep6.enterHeight(); 
		onBoardingPage.clickContinue();
		
		obj_OnboardStep6.selectPescatarianRedioBtn();   //step8
		onBoardingPage.clickContinue();
	}

	@When("User clicks any of the activity level")
	public void user_clicks_any_of_the_activity_level() {
	   
		obj_OnboardStep6.selectSedentaryRedioBtn();
		onBoardingPage.isContinueButtonEnabled();     
		
	}

	@When("User clicks continue after selecting any activity level")
	public void user_clicks_continue_after_selecting_any_activity_level() {
		
		obj_OnboardStep6.selectSedentaryRedioBtn();
		obj_OnboardStep6.clickContinueBtn();  
	}
	
//	@Then("{int} activity level options should be visible")
//	public void activity_level_options_should_be_visible(Integer expectedRadioBtnCount) {
//		
//		Assert.assertEquals(obj_OnBoardStep9.getRadioBtnCountForStep9(), expectedRadioBtnCount);
//	}

	@Then("Redirected to Step10")
	public void redirected_to_step10() {
	   
		String actualStepNumber = onBoardingPage.getProcessBarStepNumber();
		Assert.assertTrue(actualStepNumber.contains("10"));
	}
	
	
	@Then("Radio {string} activity level should be visible")
	public void radio_activity_level_should_be_visible(String expectedOption) {
	    
		Assert.assertTrue(obj_OnboardStep6.getPhysicalActivityLevelOptions(expectedOption));
	}




}
