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
		//onBoardingPage.gotoSignPage();
	}

	@When("User clicks register button after entering valid details")
	public void userClicksRegisterButtonAfterEnteringValidDetails() {
		//onBoardingPage.clickRgister();
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

	@Then("Should be redirected to step {int}")
	public void shouldBeRedirectedToStep(int expectedStepNumber) {
		String actualStepNumber = onBoardingPage.getProcessBarStepNumber();
		Assert.assertTrue(actualStepNumber.contains("3"));
	}
}
