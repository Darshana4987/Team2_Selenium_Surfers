package com.herBalance.stepDefinitions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;

import com.herBalance.driverFactory.DriverFactory;
import com.herBalance.pageObjects.OnBoardingPagePart1;
import com.herBalance.pageObjects.OnBoardingPageCommon;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class OnBoardingStepDefinitionsPart1 {
	private OnBoardingPagePart1 onBoardingPage;
	private OnBoardingPageCommon onBoardingPageCommon;
	private Logger logger = LogManager.getLogger();

	public OnBoardingStepDefinitionsPart1() {
		onBoardingPage = new OnBoardingPagePart1(DriverFactory.getDriver());
		onBoardingPageCommon = new OnBoardingPageCommon(DriverFactory.getDriver());
	}

	@Given("User is on sign up page")
	public void userIsOnSignUpPage() {
		onBoardingPageCommon.navigateToSignInPage();
		logger.info("User navigated to sign-up page");
	}

	@When("User clicks register button after entering valid details")
	public void userClicksRegisterButtonAfterEnteringValidDetails() {
		onBoardingPageCommon.clickRegister();
		logger.info("User clicked Register button");
	}

	@Then("Title of the page should be {string}")
	public void titleOfThePageShouldBeWork(String expectedTitle) {
		Assert.assertEquals(onBoardingPage.getUploadYourBloodWorkTitle(), expectedTitle);
	}

	@Then("Step1 should have supporting text")
	public void step1ShouldHaveSupportingText() {
		Assert.assertTrue(onBoardingPage.isSupportingTextForUploadBloodWorkVisible());
	}

	@Then("Onboarding progress bar is displayed")
	public void onboardingProgressBarIsDisplayed() {
		Assert.assertTrue(onBoardingPageCommon.isOnBoardingProcessBarVisible());
		logger.info("Onboarding progress bar is displayed");
	}

	@Then("Progress bar shows the current step as {string}")
	public void progressBarShowsTheCurrentStepAs(String expectedStepNumber) {
		Assert.assertEquals(onBoardingPageCommon.getProcessBarStepNumber(), expectedStepNumber);
		logger.info("Progress bar shows the current step as " + expectedStepNumber);
	}

	@Then("Upload PDF button is displayed")
	public void uploadPDFbuttonIsDisplayed() {
		String expectedButtonText = "Upload PDF";
		Assert.assertTrue(onBoardingPage.isUploadPDFButtonAndButtonTextVisible(expectedButtonText));
		logger.info("Upload PDF button is displayed");
	}

	@Then("Upload PDF button should be enabled")
	public void uploadPDFbuttonShouldBeEnabled() {
		Assert.assertTrue(onBoardingPage.isUploadPDFButtonEnabled());
	}

	@Then("PDF files only Max 10MB message is visible")
	public void PDFFilesOnlyMax10MBMessageIsVisible() {
		String expectedButtonText = "PDF files only (Max 10MB)";
		Assert.assertTrue(onBoardingPage.isPDFFilesOnlyMaxSizeButtonAndButtonTextVisible(expectedButtonText));
	}

	@Then("Skip for Now card is visible")
	public void skipForNowCardIsVisible() {
		String expectedButtonText = "Skip for Now";
		Assert.assertTrue(onBoardingPage.isSkipForNowCardAndCardTextVisible(expectedButtonText));
	}

	@Then("Explanation text about continuing without lab results is displayed")
	public void explanationTextAboutContinuingWithoutLabResultsIsDisplayed() {
		Assert.assertTrue(onBoardingPage.isExplanationTextWithoutReportVisible());
	}

	@Then("Continue Without Report button is displayed")
	public void continueWithoutReportButtonIsDisplayed() {
		String expectedButtonText = "Continue Without Report";
		Assert.assertTrue(onBoardingPageCommon.isContinueWithoutReportButtonAndButtontextVisible(expectedButtonText));
	}

	@Then("Continue without button is enabled")
	public void continueWithoutButtonIsEnabled() {
		Assert.assertTrue(onBoardingPageCommon.isContinueWithoutReportButtonEnabled());
	}

	@Then("Note about secure processing and no sharing with third parties is displayed")
	public void noteAboutSecureProcessingAndNoSharingWithThirdPartiesIsDisplayed() {
		Assert.assertTrue(onBoardingPage.isNoteAboutSecureProcessingVisible());
	}

	@When("User clicks continue without report button")
	public void userClicksContinueWithoutReportButton() {
		onBoardingPageCommon.clickContunueWithOutReportButton();
		logger.info("User clicked continue without report button");
	}

	// OnBoarding Step 1 Blood Report Upload Functionality
	@Given("User is in upload blood report page")
	public void user_is_in_upload_blood_report_page() {
		onBoardingPageCommon.navigatesToStep2();
		logger.info("User is in upload blood report page");
	}

	@When("User clicks on Upload PDF button by selecting invalid file upload")
	public void user_clicks_on_upload_pdf_button_by_selecting_invalid_file_upload() {
		logger.info("User selecting invalid file upload");
		onBoardingPage.selectInvalidFile();
	}

	@Then("User should see Only PDF files are supported error")
	public void user_should_see_only_pdf_files_are_supported_error() {
		Assert.assertEquals(onBoardingPage.getOnlyPdfFileErrorMessage(), "Please upload a PDF file only.");
	}

	@When("User clicks on Upload PDF button by selecting file over 10MB")
	public void user_clicks_on_upload_pdf_button_by_selecting_file_over_10mb() {
		logger.info("User selecting file over 10MB");
		onBoardingPage.selectFileExceeding10MB();
	}

	@Then("User should see File exceeds 10MB error")
	public void user_should_see_file_exceeds_10mb_error() {
		Assert.assertEquals(onBoardingPage.getFileExceedErrorMessage(),
				"File is too large. Please upload a file smaller than 10MB.");
	}

	@When("User clicks on Upload PDF button by selecting valid file")
	public void user_clicks_on_upload_pdf_button_by_selecting_valid_file() {
		onBoardingPage.selectValidFile();
		onBoardingPage.clickAnalyseReportButton();
	}

	@Then("Upload should see processing percentage bar")
	public void upload_should_see_processing_percentage_bar() {
		Assert.assertTrue(onBoardingPage.isProcessingBarVisible());
	}

	@Then("User should see Report analysis")
	public void user_should_see_report_analysis() {
		Assert.assertTrue(onBoardingPage.isAnalysingYourBloodWorkVisible());
	}

	@Then("User should see Analyzing your blood work report")
	public void user_should_see_analyzing_your_blood_work_report() {
		Assert.assertTrue(onBoardingPage.isAnalysingYourBloodWorkVisible());
	}

	// Step2
	@When("User clicks continue button")
	public void user_clicks_continue_button() {
		onBoardingPageCommon.clickContinue();
		logger.info("User clicked continue button");
	}

	// step3
	@When("User clicks continue without report")
	public void user_clicks_continue_without_report() {
		onBoardingPageCommon.clickContunueWithOutReportButton();
		logger.info("User clicks continue without report");
	}

	@Then("OnBoarding progress bar is displayed")
	public void on_boarding_progress_bar_is_displayed() {
		Assert.assertTrue(onBoardingPageCommon.isOnBoardingProcessBarVisible());
		logger.info("OnBoarding progress bar is displayed");
	}

	@Then("Back button is displayed")
	public void back_button_is_displayed() {
		Assert.assertTrue(onBoardingPageCommon.isBackButtonVisible());
		logger.info("Back button is displayed");
	}

	@Then("Back button should be enabled")
	public void back_button_should_be_enabled() {
		Assert.assertTrue(onBoardingPageCommon.isBackButtonEnabled());
	}

	@Then("Continue button should be visible")
	public void continue_button_should_be_visible() {
		Assert.assertTrue(onBoardingPageCommon.isContinueButtonVisible());
		logger.info("Continue button should be visible");
	}

	@Then("Continue button should be enabled")
	public void continue_button_should_be_enabled() {
		Assert.assertTrue(onBoardingPageCommon.isContinueButtonEnabled());
	}

	@Then("Header should be {string}")
	public void header_should_be(String expectedHeader) {
		Assert.assertEquals(onBoardingPageCommon.getTitleForAllSteps(), expectedHeader);
	}

	@Then("{string} header title should be displayed")
	public void header_title_should_be_displayed(String expectedTitle) {
		Assert.assertEquals(onBoardingPage.getWantToManuallyQuestionTitle(), expectedTitle);
	}

	@Then("{int} radio buttons should be visible")
	public void radio_buttons_should_be_visible(Integer expectedRadioButtonCount) {
		Assert.assertEquals(onBoardingPage.getradioButtonsCount(), expectedRadioButtonCount);
	}

	@Then("Following radio button {string} should be visible")
	public void following_radio_button_should_be_visible(String radioButtonOption) {
		Assert.assertTrue(onBoardingPage.isRadioButtonLabelVisible(radioButtonOption));
	}

	@Then("Note text should be displayed")
	public void note_text_should_be_displayed() {
		Assert.assertTrue(onBoardingPage.isNoteTextVisible());
	}

	// Step3 functionality
	@Given("User is in step3 of onboarding")
	public void user_is_in_step3_of_onboarding() {
		onBoardingPageCommon.navigatesToStep3();
	}

	@When("User clicks continue by selecting one or more health conditions")
	public void user_clicks_continue_by_selecting_one_or_more_health_conditions() {
		onBoardingPage.clickToSelectHealthCondition();
		onBoardingPageCommon.clickContinue();
		logger.info("User clicked continue by selecting one or more health conditions");
	}

	@Then("Should see the title {string}")
	public void should_see_the_title(String expectedTitle) {
		Assert.assertEquals(onBoardingPageCommon.getTitleForAllSteps(), expectedTitle);
	}

	@Then("Description text {string} should be displayed")
	public void description_text_should_be_displayed(String expectedDescription) {
		Assert.assertEquals(onBoardingPageCommon.getDescriptionTextForSteps(), expectedDescription);
	}

	@Then("{int} input boxes are visible")
	public void input_boxes_are_visible(Integer expectedInputBoxCount) {
		Assert.assertEquals(onBoardingPage.getInputBoxCount(), expectedInputBoxCount);
	}

	@Then("Input {string} labels should be visible")
	public void input_labels_should_be_visible(String expectedInputBoxLabel) {
		Assert.assertTrue(onBoardingPage.isInputLabelVisible(expectedInputBoxLabel));
	}

	@Then("Under each field following {string} should be displayed")
	public void under_each_field_following_should_be_displayed(String expectedHelperText) {
		Assert.assertTrue(onBoardingPage.isHelperTextVisible(expectedHelperText));
	}

	@Then("{int} radio button should be visible on step4")
	public void radio_button_should_be_visible_on_step4(Integer expectedCount) {
		Assert.assertEquals(onBoardingPage.getRadioButtonCountForStep4(), expectedCount);
	}

	@Then("Radio button {string} for blood pressure should be displayed")
	public void radio_button_for_blood_pressure_should_be_displayed(String expectedLabel) {
		Assert.assertTrue(onBoardingPage.isBloodPressureOptionsLabelVisible(expectedLabel));
	}

	// step4
	@Given("User is in step4 of onboarding")
	public void user_is_in_step4_of_onboarding() {
		onBoardingPageCommon.navigatesToStep4();
		logger.info("User is in step4 of onboarding");
	}

	@When("User clicks continue button after entering {string} in first name")
	public void user_clicks_continue_button_after_entering_in_first_name(String firstName) {
		onBoardingPage.enterInvalidValuesIntoPersonalDetails(firstName);
		onBoardingPageCommon.clickContinue();
	}

	@Then("Error message {string} should be displayed in Step4")
	public void error_message_should_be_displayed_in_step4(String errorMessage) {
		Assert.assertTrue(onBoardingPage.getErrorMsgForInvalidValues(errorMessage));
	}

	@When("User clicks continue button after entering {string} in age")
	public void user_clicks_continue_button_after_entering_in_age(String age) {
		onBoardingPageCommon.enterInvalidAge(age);
		onBoardingPageCommon.clickContinue();
	}

	@When("User clicks continue button without selecting blood pressure status")
	public void user_clicks_continue_button_without_selecting_blood_pressure_status() {
		onBoardingPageCommon.clickContinue();
	}

	@When("User clicks back button in step4")
	public void user_clicks_back_button_in_step4() {
		onBoardingPageCommon.clickBackButton();
	}

	@When("User clicks continue after entering all required details")
	public void user_clicks_continue_after_entering_all_required_details() {
		onBoardingPageCommon.enterValidPersonalDetails();
		onBoardingPageCommon.clickContinue();
	}

	@Then("Continue button should be enabled after selecting currently tracking option")
	public void continue_button_should_be_enabled_after_selecting_currently_tracking_option() {
		Assert.assertTrue(onBoardingPageCommon.isContinueButtonEnabledForStep5());
	}

	@Then("Description text {string}")
	public void description_text(String descriptionText) {
		Assert.assertEquals(onBoardingPageCommon.getDescriptionTextForSteps(), descriptionText);
	}

	@Then("Question {string} should be visible")
	public void question_should_be_visible(String expectedQuestion) {
		Assert.assertEquals(onBoardingPage.getQuestionAboutMestruation(), expectedQuestion);
	}

	@Then("{int} radio button should be visible on step5")
	public void radio_button_should_be_visible_on_step5(Integer expectedRadioButtonCount) {
		Assert.assertEquals(onBoardingPage.getRadioButtonCountForStep5(), expectedRadioButtonCount);
	}

	@Then("Radio {string} for  menstrual cycle awareness should be displayed")
	public void radio_for_menstrual_cycle_awareness_should_be_displayed(String expectedOption) {
		Assert.assertTrue(onBoardingPage.getMenstrualCycleAwarenessOptions(expectedOption));
	}

	// step5
	@Given("User is in step5 of onboarding")
	public void user_is_in_step5_of_onboarding() {
		onBoardingPageCommon.navigatesToStep5();
		logger.info("User is in step5 of onboarding");
	}

	@When("User clicks continue button without selecting menstrual cycle")
	public void user_clicks_continue_button_without_selecting_menstrual_cycle() {
		onBoardingPageCommon.clickContinue();
	}

	@Then("Error message {string} should be displayed")
	public void error_message_should_be_displayed(String errorMessage) {
		Assert.assertTrue(onBoardingPage.isErrorMessageDisplayed());
	}

	@When("User clicks back button in step5")
	public void user_clicks_back_button_in_step5() {
		onBoardingPageCommon.clickBackButton();
	}

	@Then("Redirected to Step {int}")
	public void redirected_to_step(Integer expectedStepNumber) {
		String actualStepNumber = onBoardingPageCommon.getProcessBarStepNumber();
		Assert.assertTrue(actualStepNumber.contains(expectedStepNumber.toString()));
	}

	@When("User clicks continue after selecting menstrual cycle info")
	public void user_clicks_continue_after_selecting_menstrual_cycle_info() {
		onBoardingPageCommon.selectMenstralCycleInfo();
		onBoardingPageCommon.clickContinue();
	}

	@Then("Calendar icon should be visible inside the date input field")
	public void calendar_icon_should_be_visible_inside_the_date_input_field() {
		Assert.assertTrue(onBoardingPage.isCalendarIconVisible());
	}

	@Then("Date input field with placeholder mm\\/dd\\/yyyy should be displayed")
	public void date_input_field_with_placeholder_mm_dd_yyyy_should_be_displayed() {
		Assert.assertTrue(onBoardingPage.getDateInputField());
	}

	@Then("Label {string} should be visible")
	public void label_should_be_visible(String expectedLabel) {
		Assert.assertEquals(onBoardingPage.getLabelUnderDateField(), expectedLabel);
	}

	@Then("Slider control for cycle length should be displayed")
	public void slider_control_for_cycle_length_should_be_displayed() {
		Assert.assertTrue(onBoardingPage.isSliderControlVisible());
	}

	@Then("Default cycle length value e.g., {string} should be shown beside the slider")
	public void default_cycle_length_value_e_g_should_be_shown_beside_the_slider(String expectedValue) {
		Assert.assertEquals(onBoardingPage.getCycleLengthValue(), expectedValue);
	}

	@Then("Information text {string} should be visible")
	public void information_text_should_be_visible(String expectedText) {
		Assert.assertEquals(onBoardingPage.getInformationText(), expectedText);
	}

}