package com.herBalance.stepDefinitions;

import org.testng.Assert;

import com.herBalance.driverFactory.DriverFactory;
import com.herBalance.pageObjects.OnBoardingPagePart1;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class OnBoardingStepDefinitionsPart1 {
	private OnBoardingPagePart1 onBoardingPage;

	public OnBoardingStepDefinitionsPart1() {
		onBoardingPage = new OnBoardingPagePart1(DriverFactory.getDriver());
	}

	@Given("User is on sign up page")
	public void userIsOnSignUpPage() {
		onBoardingPage.gotoSignPage();
	}

	@When("User clicks register button after entering valid details")
	public void userClicksRegisterButtonAfterEnteringValidDetails() {
		onBoardingPage.clickRgister();
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
		Assert.assertTrue(onBoardingPage.isOnBoardingProcessBarVisible());
	}

	@Then("Progress bar shows the current step as {string}")
	public void progressBarShowsTheCurrentStepAs(String expectedStepNumber) {
		Assert.assertEquals(onBoardingPage.getProcessBarStepNumber(), expectedStepNumber);
	}

	@Then("Upload PDF button is displayed")
	public void uploadPDFbuttonIsDisplayed() {
		String expectedButtonText = "Upload PDF";
		Assert.assertTrue(onBoardingPage.isUploadPDFButtonAndButtonTextVisible(expectedButtonText));
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
		Assert.assertTrue(onBoardingPage.isContinueWithoutReportButtonAndButtontextVisible(expectedButtonText));
	}

	@Then("Continue without button is enabled")
	public void continueWithoutButtonIsEnabled() {
		Assert.assertTrue(onBoardingPage.isContinueWithoutReportButtonEnabled());
	}

	@Then("Note about secure processing and no sharing with third parties is displayed")
	public void noteAboutSecureProcessingAndNoSharingWithThirdPartiesIsDisplayed() {
		Assert.assertTrue(onBoardingPage.isNoteAboutSecureProcessingVisible());
	}

	@When("User clicks continue without report button")
	public void userClicksContinueWithoutReportButton() {
		onBoardingPage.clickContunueWithOutReportButton();
	}

	@Then("Should be redirected to step3")
	public void shouldBeRedirectedToStep3() {
		String actualStepNumber = onBoardingPage.getProcessBarStepNumber();
		Assert.assertTrue(actualStepNumber.contains("3"));
	}

	// OnBoarding Step 1 Blood Report Upload Functionality

	@Given("User is in upload blood report page")
	public void user_is_in_upload_blood_report_page() {
		onBoardingPage.gotoSignPage();
		onBoardingPage.clickRgister();
	}

	@When("User clicks on Upload PDF button by selecting invalid file upload")
	public void user_clicks_on_upload_pdf_button_by_selecting_invalid_file_upload() {
		onBoardingPage.selectInvalidFile();
	}

	@Then("User should see Only PDF files are supported error")
	public void user_should_see_only_pdf_files_are_supported_error() {
		Assert.assertEquals(onBoardingPage.getOnlyPdfFileErrorMessage(), "Please upload a PDF file only.");
	}

	@When("User clicks on Upload PDF button by selecting file over 10MB")
	public void user_clicks_on_upload_pdf_button_by_selecting_file_over_10mb() {
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
		Assert.assertTrue(true);
	}

}
