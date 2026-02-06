package com.herBalance.stepDefinitions;

import org.testng.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.herBalance.driverFactory.DriverFactory;
import com.herBalance.pageObjects.OnBoardingPageCommon;
import com.herBalance.pageObjects.OnBoardingPagePart2;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class OnBoardingStepDefinitionPart2 {

	private static final Logger logger = LoggerFactory.getLogger(OnBoardingStepDefinitionPart2.class);

	private OnBoardingPagePart2 obj_OnboardStepPart2;
	private OnBoardingPageCommon obj_OnBoardingPageCommon;

	public OnBoardingStepDefinitionPart2() {

		obj_OnboardStepPart2 = new OnBoardingPagePart2(DriverFactory.getDriver());
		obj_OnBoardingPageCommon = new OnBoardingPageCommon(DriverFactory.getDriver());
	}

	// Step 6

	@Given("User is in step six of onboarding")
	public void user_is_in_step_six_of_onboarding() {

		obj_OnBoardingPageCommon.navigatesToStep6();

		logger.info("You are on the Onboard Process Step 6");
	}

	@When("User clicks continue button without selecting last menstrual date")
	public void user_clicks_continue_button_without_selecting_last_menstrual_date() {

		obj_OnBoardingPageCommon.clickContinue();
	}

	@Then("Error message {string} should be displayed for Step6")
	public void error_message_should_be_displayed_for_step6(String errormessage) {

		Assert.assertEquals(obj_OnboardStepPart2.getErrorText_InvalidDate(), errormessage);
		logger.info("Please select your last period start date");
	}

	@When("User selects last menstrual date")
	public void user_selects_last_menstrual_date() {

		obj_OnboardStepPart2.enterlastMenstrualDate();
	}

	@When("User clicks continue after selecting last menstrual date")
	public void user_clicks_continue_after_selecting_last_menstrual_date() {

		obj_OnboardStepPart2.enterlastMenstrualDate();
		obj_OnBoardingPageCommon.clickContinue();
	}

	@Then("Progress bar shows the current step {string}")
	public void progress_bar_shows_the_current_step(String progressBarCurrentStep) {

		Assert.assertEquals(obj_OnBoardingPageCommon.getProcessBarStepNumber(), progressBarCurrentStep);
		logger.info("Current progress bar shows 6 of 10");
	}

	@When("User clicks back button in step {int}")
	public void user_clicks_back_button_in_step(Integer int1) {

		obj_OnBoardingPageCommon.clickBackButton();
	

	}
	@Then("Description for current phase should be displayed {string}")
	public void description_for_current_phase_should_be_displayed(String expectedDescription) {
	   
		Assert.assertEquals(obj_OnboardStepPart2.getDescriptionForStep6(), expectedDescription);
		
	}
	@When("User selecting last menstrual date")
	public void user_selecting_last_menstrual_date() {
		
		obj_OnboardStepPart2.enterlastMenstrualDate();  
	}

	@Then("User redirected to back Step {int}")
	public void user_redirected_to_back_step(Integer int1) {
		obj_OnBoardingPageCommon.clickContinue();
	}

	@Then("User redirected to next Step7")
	public void user_redirected_to_next_step7() {
		String actualStepNumber = obj_OnBoardingPageCommon.getProcessBarStepNumber();
		Assert.assertTrue(actualStepNumber.contains("7"));

	}

	@When("User clicks continue button after entering invalid value in date")
	public void user_clicks_continue_button_after_entering_invalid_value_in_date() {

		obj_OnboardStepPart2.enterInvalid_lastMenstrualDate();
		obj_OnBoardingPageCommon.clickContinue();

	}

	@Then("Error message {string} should be displayed invalid value in date")
	public void error_message_should_be_displayed_invalid_value_in_date(String InvalidDateErrorMsg) {

		Assert.assertEquals(obj_OnboardStepPart2.getErrorText_InvalidDate(), InvalidDateErrorMsg);
		logger.info("Please select your last period start date");
	}

	@Then("Redirected to Step7")
	public void redirected_to_step7() {

		String actualStepNumber = obj_OnBoardingPageCommon.getProcessBarStepNumber();
		Assert.assertTrue(actualStepNumber.contains("7"));

	}
	@Then("{string} title should be displayed for step7")
	public void title_should_be_displayed_for_step7(String expectedTitle_Step7) {
	   
		Assert.assertEquals(obj_OnboardStepPart2.getTitleForStep6(), expectedTitle_Step7);

	}

	// Step 7

	@Given("User is in step seven of onboarding")
	public void user_is_in_step_seven_of_onboarding() {

		obj_OnBoardingPageCommon.navigatesToStep7();
		obj_OnboardStepPart2.enterlastMenstrualDate();
		obj_OnBoardingPageCommon.clickContinue();

		logger.info("You are on the Onboard Process Step 7");
	}

	@When("User clicks continue button without entering current weight")
	public void user_clicks_continue_button_without_entering_current_weight() {

		obj_OnboardStepPart2.enterEmptyWeight();
		obj_OnBoardingPageCommon.clickContinue();
	}

	@Then("Error message {string} should be displayed for empty weight")
	public void error_message_should_be_displayed_for_empty_weight(String errorMessage) {

		Assert.assertEquals(obj_OnboardStepPart2.getErrorText_EmptyWeight(), errorMessage);
		logger.info("Please enter weight");
	}

	@When("User clicks continue button after entering invalid weight")
	public void user_clicks_continue_button_after_entering_invalid_weight() {

		obj_OnboardStepPart2.enterInvalidWeight();
		obj_OnBoardingPageCommon.clickContinue();
	}

	@Then("Error message {string} shouldbe displayed for invalid weight")
	public void error_message_shouldbe_displayed_for_invalid_weight(String errorMessage) {

		Assert.assertEquals(obj_OnboardStepPart2.getErrorText_InvalidWeight(), errorMessage);
		logger.info("Please enter weight");
	}

	@When("User clicks continue button without entering height")
	public void user_clicks_continue_button_without_entering_height() {

		obj_OnboardStepPart2.enterEmptyHeight();
		obj_OnBoardingPageCommon.clickContinue();
	}

	@Then("Error message {string} should be displayed for empty height")
	public void error_message_should_be_displayed_for_empty_height(String errorMessage) {

		Assert.assertEquals(obj_OnboardStepPart2.getErrorText_EmptyHeight(), errorMessage);
		logger.info("Please enter height");
	}

	@When("User clicks continue button after entering invalid height")
	public void user_clicks_continue_button_after_entering_invalid_height() {

		obj_OnboardStepPart2.enterInvalidHeight();
		obj_OnBoardingPageCommon.clickContinue();
	}

	@Then("Error message {string} should be displayed for invalid height")
	public void error_message_should_be_displayed_for_invalid_height(String errorMessage) {

		Assert.assertEquals(obj_OnboardStepPart2.getErrorText_InvalidHeight(), errorMessage);
		logger.info("Please enter wheight");
	}

	@When("User clicks weight\\(kg) dropdown")
	public void user_clicks_weight_kg_dropdown() {

		obj_OnboardStepPart2.isKGUnit_Visible();
		obj_OnboardStepPart2.isLBSUnit_Visible();
	}

	@Then("weight Options {string} and {string} should be displayed")
	public void weight_options_and_should_be_displayed(String kg, String lbs) {

		Assert.assertEquals(obj_OnboardStepPart2.getText_KGUnit(), kg);
		Assert.assertEquals(obj_OnboardStepPart2.getText_LBSUnit(), lbs);
	}

	@When("User clicks height\\(cm) dropdown")
	public void user_clicks_height_cm_dropdown() {

		obj_OnboardStepPart2.isCMunit_Visible();
	}

	@Then("height Options {string} and {string} should be displayed")
	public void height_options_and_should_be_displayed(String string, String string2) {

		Assert.assertEquals(obj_OnboardStepPart2.getText_CMunit(), string);
		Assert.assertEquals(obj_OnboardStepPart2.getText_CMunit(), string2);
	}

	@When("User enters valid height and weight")
	public void user_enters_valid_height_and_weight() {

		obj_OnboardStepPart2.enterWeight();
		obj_OnboardStepPart2.enterHeight();
		obj_OnBoardingPageCommon.clickContinue();
	}

	@Then("BMI bar should be displayed")
	public void bmi_bar_should_be_displayed() {

		Assert.assertTrue(obj_OnboardStepPart2.isBMI_BarVisible());
	}

	@Then("Redirected to Step8")
	public void redirected_to_step8() {

		String actualStepNumber = obj_OnBoardingPageCommon.getProcessBarStepNumber();
		Assert.assertTrue(actualStepNumber.contains("8"));

	}

	// Step 8

	@Given("User is in step eight of onboarding")
	public void user_is_in_step_eight_of_onboarding() {

		obj_OnBoardingPageCommon.navigatesToStep8();
		obj_OnboardStepPart2.enterlastMenstrualDate();
		obj_OnBoardingPageCommon.clickContinue();
		obj_OnboardStepPart2.enterWeight();
		obj_OnboardStepPart2.enterHeight();
		obj_OnBoardingPageCommon.clickContinue();

		logger.info("You are on the Onboard Process Step 8");

	}

	@When("User clicks continue after selecting any dietary options")
	public void user_clicks_continue_after_selecting_any_dietary_options() {

		obj_OnboardStepPart2.selectPescatarianRedioBtn();
		obj_OnBoardingPageCommon.clickContinue();
	}

	@Then("{int} Radio options for Dietary Preferences should be visible")
	public void radio_options_for_dietary_preferences_should_be_visible(Integer int1) {

		Assert.assertEquals(obj_OnboardStepPart2.getRadioBtnCountForStep8(), int1);
		logger.info("4 options is visible");

	}

	@Then("Redirected to Step9")
	public void redirected_to_step9() {

		String actualStepNumber = obj_OnBoardingPageCommon.getProcessBarStepNumber();
		Assert.assertTrue(actualStepNumber.contains("9"));
	}

	@When("User clicks back button in step7")
	public void user_clicks_back_button_in_step7() {

		obj_OnBoardingPageCommon.clickBackButton();
	}
	
	@Then("{string} should be displayed for step9")
	public void should_be_displayed_for_step9(String title) {
		
		Assert.assertEquals(obj_OnboardStepPart2.geTitleStep9(),title);
	}
	
	@Then("{string} for step9")
	public void for_step9(String descriptionForStep9) {
	    
		Assert.assertEquals(obj_OnboardStepPart2.getDescriptionForStep9(),descriptionForStep9);
	}
	
	@Then("{string} Info should be displayed for step9")
	public void info_should_be_displayed_for_step9(String infoForStep9) {
	   
		Assert.assertEquals(obj_OnboardStepPart2.geInfoForStep9(),infoForStep9);

	}
	
	// Step 9

	@Given("User is in step nine of onboarding")
	public void user_is_in_step_nine_of_onboarding() {

		obj_OnBoardingPageCommon.navigatesToStep9();
		obj_OnboardStepPart2.enterlastMenstrualDate();
		obj_OnBoardingPageCommon.clickContinue();
		
		obj_OnboardStepPart2.enterWeight();
		obj_OnboardStepPart2.enterHeight();
		obj_OnBoardingPageCommon.clickContinue();
		
		obj_OnboardStepPart2.selectPescatarianRedioBtn();
		obj_OnBoardingPageCommon.clickContinue();
		
		logger.info("You are on the Onboard Process Step 9");
	}

	@When("User clicks any of the activity level")
	public void user_clicks_any_of_the_activity_level() {

		obj_OnboardStepPart2.selectSedentaryRedioBtn();
	}
	
	@Then("{int} Radio options activity level should be visible")
	public void radio_options_activity_level_should_be_visible(Integer expectedRadioButtonCount) {
	   
		Assert.assertEquals(obj_OnboardStepPart2.getRadioBtnCountForStep9(), expectedRadioButtonCount);
		logger.info("4 options is visible");
		
	}

	@When("User clicks continue after selecting any activity level")
	public void user_clicks_continue_after_selecting_any_activity_level() {

		obj_OnboardStepPart2.selectSedentaryRedioBtn();
		obj_OnBoardingPageCommon.clickContinue();
	}

	@Then("Redirected to Step10")
	public void redirected_to_step10() {

		String actualStepNumber = obj_OnBoardingPageCommon.getProcessBarStepNumber();
		Assert.assertTrue(actualStepNumber.contains("10"));
	}

	@Then("Radio {string} activity level should be visible")
	public void radio_activity_level_should_be_visible(String expectedOption) {

		Assert.assertTrue(obj_OnboardStepPart2.getPhysicalActivityLevelOptions(expectedOption));
	}
	
	@Then("Progress bar shows the current step as  {string}")
	public void progress_bar_shows_the_current_step_as(String progressBarCurrentStep) {
	
	Assert.assertEquals(obj_OnBoardingPageCommon.getProcessBarStepNumber(), progressBarCurrentStep);
	logger.info("Current progress bar shows 10 of 11");
  
	}

	@Then("{string} should be displayed")
	public void should_be_displayed(String expectedTitle_ForStep10) {
		
		Assert.assertEquals(obj_OnboardStepPart2.geTitleStep10(),expectedTitle_ForStep10);
	}
	
	@Then("{string} description for step10")
	public void description_for_step10(String expectedDescription_ForStep10) {
	   
		Assert.assertEquals(obj_OnboardStepPart2.getDescriptionForStep10(),expectedDescription_ForStep10);
	}
	
	// Step10
	
	@Given("User is in step ten of onboarding")
	public void user_is_in_step_ten_of_onboarding() {
	   
		obj_OnBoardingPageCommon.navigatesToStep9();
		obj_OnboardStepPart2.enterlastMenstrualDate();
		obj_OnBoardingPageCommon.clickContinue();
		
		obj_OnboardStepPart2.enterWeight();
		obj_OnboardStepPart2.enterHeight();
		obj_OnBoardingPageCommon.clickContinue();
		
		obj_OnboardStepPart2.selectPescatarianRedioBtn();
		obj_OnBoardingPageCommon.clickContinue();
		
		obj_OnboardStepPart2.selectSedentaryRedioBtn();
		obj_OnBoardingPageCommon.clickContinue();
		
		logger.info("You are on the Onboard Process Step 10");
	}

	@When("User clicks continue after selecting any options under Food Allergies & Sensitivities")
	public void user_clicks_continue_after_selecting_any_options_under_food_allergies_sensitivities() {
		
		obj_OnboardStepPart2.selectYES_RedioBtn();
		obj_OnboardStepPart2.selectFoodAllergy();
		obj_OnBoardingPageCommon.clickContinue();
	}

	@Then("Redirected to Step11")
	public void redirected_to_step11() {
		
		String actualStepNumber = obj_OnBoardingPageCommon.getProcessBarStepNumber();
		Assert.assertTrue(actualStepNumber.contains("11"));
	}
	
	@Then("Following radio button {string} should be visible for step11")
	public void following_radio_button_should_be_visible_for_step11(String expectedOptions) {
	   
		Assert.assertTrue(obj_OnboardStepPart2.isFoodAllergyOptionsLabelVisible(expectedOptions));

	}
	
	@Then("{string} title should be displayed for step11")
	public void title_should_be_displayed_for_step11(String expectedTitle_ForStep11) {
	   
		Assert.assertEquals(obj_OnboardStepPart2.geTitleStep11(),expectedTitle_ForStep11);

	}
	
	@Then("{string} description for step11 should be displayed.")
	public void description_for_step11_should_be_displayed(String expectedDescription_ForStep11) {
	   
		Assert.assertEquals(obj_OnboardStepPart2.getDescriptionForStep11(),expectedDescription_ForStep11);

	}
	
	
	// Step11
	
	@Given("User is in step eleven of onboarding")
	public void user_is_in_step_eleven_of_onboarding() {
	   
		obj_OnBoardingPageCommon.navigatesToStep9();
		obj_OnboardStepPart2.enterlastMenstrualDate();
		obj_OnBoardingPageCommon.clickContinue();
		
		obj_OnboardStepPart2.enterWeight();
		obj_OnboardStepPart2.enterHeight();
		obj_OnBoardingPageCommon.clickContinue();
		
		obj_OnboardStepPart2.selectPescatarianRedioBtn();
		obj_OnBoardingPageCommon.clickContinue();
		
		obj_OnboardStepPart2.selectSedentaryRedioBtn();
		obj_OnBoardingPageCommon.clickContinue();
		
		obj_OnboardStepPart2.selectYES_RedioBtn();
		obj_OnboardStepPart2.selectFoodAllergy();
		obj_OnBoardingPageCommon.clickContinue();
		
		logger.info("You are on the Onboard Process Step 10");
		
	}
	
	@When("User clicks complete button after entering any options under Medications & Supplements")
	public void user_clicks_complete_button_after_entering_any_options_under_medications_supplements() {
		
		obj_OnboardStepPart2.selectRedioBtnForMedication();
		obj_OnboardStepPart2.selectRedioBtnForSuppliments();
		obj_OnboardStepPart2.btnCompleteClicked();
	}
	@Then("Should be navigated to subscription page {string}")
	public void should_be_navigated_to_subscription_page(String expectedTitle_ForSubcriptionPage) {
	   
		Assert.assertEquals(obj_OnboardStepPart2.geTitleSubcriptionPage(),expectedTitle_ForSubcriptionPage);
	}
	
	@When("User clicks continue button without selecting any option")
	public void user_clicks_continue_button_without_selecting_any_option() {
	   
		obj_OnboardStepPart2.btnCompleteClicked();
	}
	
	@Then("{string} error message should be displayed for step11")
	public void error_message_should_be_displayed_for_step11(String expectedErrorMessage) {
	   
		Assert.assertEquals(obj_OnboardStepPart2.getErrorMessgaeForStep11(),expectedErrorMessage);
	}
	
	@When("User clicks any options under Medications & Supplements")
	public void user_clicks_any_options_under_medications_supplements() {
	   
		obj_OnboardStepPart2.selectRedioBtnForMedication();
	}

	@Then("Radio button in the selected section forn step11 for should be marked as selected")
	public void radio_button_in_the_selected_section_forn_step11_for_should_be_marked_as_selected() {
	  
	}
}
