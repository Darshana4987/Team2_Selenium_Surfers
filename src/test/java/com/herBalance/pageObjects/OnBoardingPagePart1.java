package com.herBalance.pageObjects;

import java.io.File;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OnBoardingPagePart1 {

	private WebDriver driver;

	// Step1
	private By headerTitle = By.xpath("//h2[text()='Upload Your Recent Blood Work']");
	private By txaSupportingText = By.xpath("//p[contains(., 'Welcome to HerBalance!')]");
	private By onBoardingProcessBar = By.xpath("//div[contains(@class, 'w-full')]");
	private By txtProcessBarStepNumber = By.xpath("//div[contains(@class,'flex justify-between')]//span[2]");
	private By btnUploadPDF = By.xpath("//button[text()='Upload PDF']");
	private By txtPDfFileSize = By.xpath("//p[text()='PDF files only (Max 10MB)']");
	private By headerSkipForNow = By.xpath("//h3[text()='Skip for Now']");
	private By txtWithoutReportExplanation = By.xpath("//p[contains(., 'You can continue without uploading')]");
	private By btnContinueWithoutReport = By.xpath("//button[text()='Continue Without Report']");
	private By txtSecureProcessingNote = By.xpath("//p[contains(., 'Your data is securely processed')]");

	// step1 Functionality
	private By msgOnlyPDFFilesError = By.xpath("//p[text()='Please upload a PDF file only.']");
	private By msgFileExceedError = By.xpath("//p[contains(text(),'File is too large')]");
	private By processingPercentageBar = By.xpath("//div[contains(@class,'h-full bg-gradient-to-r')]");
	private By btnAnalyseReport = By.xpath("//button[text()='Analyze Report']");
	private By txtAnalysingReport = By.xpath("//p[text()='Analyzing your blood work report']");
	private By txtMedicalConditions = By.xpath("//p[contains(@class,'text-sm font-medium')]");
	private By msgFileSelected = By.xpath("//h3[text()='File Selected']");
	private By headerTitleForAll = By.xpath("//h2[contains(@class,'text-2xl')]");

	// Step3
	private By btnBack = By.xpath("//button[text()='Back']");
	private By btnContinue = By.xpath("//button[text()='Continue']");
	private By headerHealthConditions = By.xpath("//h2[text()='Health Conditions']");
	private By txtManuallyEnterQuestion = By.xpath("//p[contains(.,'Want to manually enter')]");
	private By rdoTotalRadioButtons = By.xpath("//div[contains(@class,'grid')]//input[@type='checkbox']");
	private By lblOptionsTextForHealthCondition = By.xpath("//div[contains(@class,'flex ')]//label");
	private By txaNoteText = By.xpath("//p[contains(.,'Conditions like')]");

	// Step4
	private By headerPersonalDetails = By.xpath("//h2[text()='Personal Details']");
	private By txtDescriptionText = By.xpath("//p[@class='text-black mb-6']");
	private By txtInputBox = By.xpath("//input[contains(@class,'w-full')]");
	private By lblInputFields = By.xpath("//label[contains(@class,'block text-sm ')]");
	private By txtHelperTextForLabels = By.xpath("//p[contains(@class,'text-xs')]");
	private By rdoTotalRdButtonsStep4 = By.xpath("//div[contains(@class, 'h-5')]");
	private By lblOptionsForBlooodPressure = By.xpath("//div[contains(@class, 'space-y-3')]//div//span");

	// step5
	// private By msgInvalidFirstName=By.xpath("//p[text()='Name is required']");
	// private By msgEmptyAge=By.xpath("//p[text()='Age is required']");
	// private By msgInvalidAge=By.xpath("//p[text()='Age must be between 18 and
	// 100']");
	// private By msgBloodPressureStatusError=By.xpath("//p[text()='Please select
	// your blood pressure status']");
	private By txtInputPersonalDetails = By.xpath("//input[contains(@class,'w-full')]");
	private By msgInvalidValueError = By.xpath("//p[contains(@class,'text-xs text-red')]");
	private By headerMenstrualCycleAwareness = By.xpath("//h2[contains(text(),'Menstrual Cycle Awareness')]");
	private By txaUnderstandingYourCycle = By.xpath("//p[contains(text(),'Understanding your cycle helps')]");
	// private By txaDoYouCurrentlyTrack = By.xpath("//h3[contains(text(),'Do you
	// currently track')]");
	private By txtQuestionsAboutMenstruation = By.xpath("//h3[contains(@class,'text-lg')]");
	private By rdoTotalRdButtonsStep5 = By.xpath("//input[@type='radio']");
	private By lblOptionsForMenstrualCycleAwareness = By.xpath("//label[contains(@class,'block text')]");
	private By txtFirstName = By.xpath("//input[@id='name']");
	private By txtAge = By.xpath("//input[@id='age']");
	private By rdoNeverDiagnosed = By.xpath("//span[text()='I have never been diagnosed']");
	private By rdYesOptionForTrackCycle = By.xpath("//label[text()='Yes']");

	// Step6 UI
	private By imgCalendar = By.xpath("//input[@type='date']");
	private By textDateInputField = By.xpath("(//input[@type='date'])[1]");
	// private By textDateInputField=By.xpath("//input[contains(@class,'w-full
	// p-3')]");
	private By lblCycleLength = By.xpath("//label[contains(@class,'block text')]");
	private By sliderBar = By.xpath("//input[@id='cycle-length']");
	private By txtCycleLengthValue = By.xpath("//span[contains(@class,'ml-3')]");
	private By txtInformationText = By.xpath("//p[contains(text(),'Average cycle length')]");

	private WebDriverWait wait;

	public OnBoardingPagePart1(WebDriver driver) {
		this.driver = driver;
	}

	public void gotoSignPage() {
		By btnSignUp = By.xpath("//button[text()='Sign Up']");
		driver.findElement(btnSignUp).click();
	}

	public void clickRgister() {
		By txtUserName = By.xpath("//input[@name='username']");
		By txtPwd = By.xpath("//input[@name='password']");
		By txtConfirmPwd = By.xpath("//input[@name='confirmPassword']");
		By rdoAgree = By.xpath("//button[@id=':r8:-form-item']");
		By btnRegister = By.xpath("//button[text()='Register']");
		String userName = "abcdfg" + System.currentTimeMillis() + "@gmail.com";
		String password = "123456";
		driver.findElement(txtUserName).sendKeys(userName);
		driver.findElement(txtPwd).sendKeys(password);
		driver.findElement(txtConfirmPwd).sendKeys(password);
		driver.findElement(rdoAgree).click();
		driver.findElement(btnRegister).click();
	}

	// Step1
	public String getUploadYourBloodWorkTitle() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		return wait.until(ExpectedConditions.visibilityOfElementLocated(headerTitle)).getText();
	}

	public boolean isSupportingTextForUploadBloodWorkVisible() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		return wait.until(ExpectedConditions.visibilityOfElementLocated(txaSupportingText)).isDisplayed();
	}

	public boolean isOnBoardingProcessBarVisible() {
		return driver.findElement(onBoardingProcessBar).isDisplayed();
	}

	public String getProcessBarStepNumber() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		return wait.until(ExpectedConditions.visibilityOfElementLocated(txtProcessBarStepNumber)).getText();
	}

	public boolean isUploadPDFButtonAndButtonTextVisible(String buttonText) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		WebElement uploadPdfButton = wait.until(ExpectedConditions.visibilityOfElementLocated(btnUploadPDF));
		return uploadPdfButton.isDisplayed() && uploadPdfButton.getText().equalsIgnoreCase(buttonText);
	}

	public boolean isUploadPDFButtonEnabled() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		return wait.until(ExpectedConditions.visibilityOfElementLocated(btnUploadPDF)).isDisplayed();
	}

	public boolean isPDFFilesOnlyMaxSizeButtonAndButtonTextVisible(String buttonText) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		WebElement pdfFilesOnlyButton = wait.until(ExpectedConditions.visibilityOfElementLocated(txtPDfFileSize));
		return pdfFilesOnlyButton.isDisplayed() && pdfFilesOnlyButton.getText().equalsIgnoreCase(buttonText);
	}

	public boolean isSkipForNowCardAndCardTextVisible(String buttonText) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		WebElement skipForNowCard = wait.until(ExpectedConditions.visibilityOfElementLocated(headerSkipForNow));
		return skipForNowCard.isDisplayed() && skipForNowCard.getText().equalsIgnoreCase(buttonText);
	}

	public boolean isExplanationTextWithoutReportVisible() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		return wait.until(ExpectedConditions.visibilityOfElementLocated(txtWithoutReportExplanation)).isDisplayed();
	}

	public boolean isContinueWithoutReportButtonAndButtontextVisible(String buttonText) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		WebElement continueWithoutReport = wait
				.until(ExpectedConditions.visibilityOfElementLocated(btnContinueWithoutReport));
		return continueWithoutReport.isDisplayed() && continueWithoutReport.getText().equalsIgnoreCase(buttonText);
	}

	public boolean isContinueWithoutReportButtonEnabled() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		return wait.until(ExpectedConditions.visibilityOfElementLocated(btnContinueWithoutReport)).isEnabled();
	}

	public boolean isNoteAboutSecureProcessingVisible() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		return wait.until(ExpectedConditions.visibilityOfElementLocated(txtSecureProcessingNote)).isDisplayed();
	}

	// step1 Functionality
	public void clickContunueWithOutReportButton() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(btnContinueWithoutReport)).click();
	}

	public void selectInvalidFile() {
		String relativePath = "/testData/" + "sample1.txt";
		File file = new File("src/test/resources" + relativePath);
		driver.findElement(By.xpath("//input[@type='file']")).sendKeys(file.getAbsolutePath());
	}

	public String getOnlyPdfFileErrorMessage() {
		return driver.findElement(msgOnlyPDFFilesError).getText();
	}

	public void selectFileExceeding10MB() {
		String relativePath = "/testData/" + "FileExceeding10MB.pdf";
		File file = new File("src/test/resources" + relativePath);
		driver.findElement(By.xpath("//input[@type='file']")).sendKeys(file.getAbsolutePath());
	}

	public String getFileExceedErrorMessage() {
		return driver.findElement(msgFileExceedError).getText();
	}

	public void selectValidFile() {
		String relativePath = "/testData/" + "ValidFileForUpload.pdf";
		File file = new File("src/test/resources" + relativePath);
		driver.findElement(By.xpath("//input[@type='file']")).sendKeys(file.getAbsolutePath());
	}

	public boolean isProcessingBarVisible() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		return wait.until(ExpectedConditions.visibilityOfElementLocated(processingPercentageBar)).isDisplayed();
	}

	public boolean isReportAnalysisButtonVisible() {
		return driver.findElement(btnAnalyseReport).isDisplayed();
	}

	public void clickAnalyseReportButton() {
		driver.findElement(btnAnalyseReport).click();
	}

	public boolean isAnalysingYourBloodWorkVisible() {
		return driver.findElement(txtAnalysingReport).isDisplayed();
	}

	// Step3
	public boolean isBackButtonVisible() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		return wait.until(ExpectedConditions.visibilityOfElementLocated(btnBack)).isDisplayed();
	}

	public boolean isBackButtonEnabled() {
		return driver.findElement(btnBack).isEnabled();
	}

	public boolean isContinueButtonVisible() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		return wait.until(ExpectedConditions.visibilityOfElementLocated(btnContinue)).isDisplayed();
	}

	public boolean isContinueButtonEnabled() {
		return driver.findElement(btnContinue).isEnabled();
	}

	public String getHealthConditionHeader() {
		return driver.findElement(headerHealthConditions).getText();
	}

	public String getWantToManuallyQuestionTitle() {
		return driver.findElement(txtManuallyEnterQuestion).getText();
	}

	public int getradioButtonsCount() {
		return driver.findElements(rdoTotalRadioButtons).size();
	}

	public boolean isRadioButtonLabelVisible(String radioButtonOption) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		List<WebElement> radiobuttonlabel = wait
				.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(lblOptionsTextForHealthCondition));

		for (WebElement r : radiobuttonlabel) {
			if (r.getText().equals(radioButtonOption))
				return true;
		}
		return false;
	}

	public boolean isNoteTextVisible() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		return wait.until(ExpectedConditions.visibilityOfElementLocated(txaNoteText)).isDisplayed();
	}

	public void clickContinue() {
		driver.findElement(btnContinue).click();
	}

	// Step4
	public void clickToSelectHealthCondition() {
		List<WebElement> healthCondition = driver.findElements(lblOptionsTextForHealthCondition);
		for (WebElement hcWebElement : healthCondition) {
			if (hcWebElement.getText().equals("PCOS"))
				hcWebElement.click();
		}
	}

	public String getTitleForStep4() {
		return driver.findElement(headerPersonalDetails).getText();
	}

	public String getDescriptionTextForStep4() {
		return driver.findElement(txtDescriptionText).getText();
	}

	public int getInputBoxCount() {
		return driver.findElements(txtInputBox).size();
	}

	public boolean isInputLabelVisible(String inputLabel) {
		List<WebElement> inputBoxLabel = driver.findElements(lblInputFields);

		for (WebElement inputBox : inputBoxLabel) {
			if (inputBox.getText().equals(inputLabel))
				return true;
		}
		return false;
	}

	public boolean isHelperTextVisible(String helperText) {
		List<WebElement> helperTextLabel = driver.findElements(txtHelperTextForLabels);

		for (WebElement h : helperTextLabel) {
			if (h.getText().equals(helperText))
				return true;
		}
		return false;
	}

	public int getRadioButtonCountForStep4() {
		return driver.findElements(rdoTotalRdButtonsStep4).size();
	}

	public boolean isBloodPressureOptionsLabelVisible(String bloodPressureOptionLabel) {
		List<WebElement> bloodPressureLabel = driver.findElements(lblOptionsForBlooodPressure);

		for (WebElement b : bloodPressureLabel) {
			if (b.getText().equals(bloodPressureOptionLabel))
				return true;
		}
		return false;
	}

	// step5

	public String getTitleForAllSteps() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		return wait.until(ExpectedConditions.visibilityOfElementLocated(headerTitleForAll)).getText();
	}

	public boolean isContinueButtonEnabledForStep5() {
		driver.findElement(rdYesOptionForTrackCycle).click();
		return driver.findElement(btnContinue).isEnabled();
	}

	public String getDescriptionTextForSteps() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		return wait.until(ExpectedConditions.visibilityOfElementLocated(txtDescriptionText)).getText();
	}

	public void enterInvalidAge(String invalidAge) {
		driver.findElement(txtAge).sendKeys(invalidAge);
	}

	public void enterInvalidValuesIntoPersonalDetails(String invalidInput) {
		driver.findElement(txtInputPersonalDetails).sendKeys(invalidInput);
	}

	public boolean getErrorMsgForInvalidValues(String errorMessage) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		List<WebElement> errors = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(msgInvalidValueError));

		for (WebElement e : errors) {
			if (e.getText().contains(errorMessage))
				return true;
		}
		return false;
	}

	public void clickBackButton() {
		driver.findElement(btnBack).click();
	}

	public void giveValidPersonalDetails() {
		driver.findElement(txtFirstName).sendKeys("smitha");
		driver.findElement(txtAge).sendKeys("25");
		driver.findElement(rdoNeverDiagnosed).click();
	}

	public void clickImNotSure() {
		driver.findElement(rdoNeverDiagnosed).click();
	}

	public String getQuestionAboutMestruation() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		return wait.until(ExpectedConditions.visibilityOfElementLocated(txtQuestionsAboutMenstruation)).getText();
	}

	public int getRadioButtonCountForStep5() {
		return driver.findElements(rdoTotalRdButtonsStep5).size();
	}

	public boolean getMenstrualCycleAwarenessOptions(String options) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		List<WebElement> menstrualOptions = wait
				.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(lblOptionsForMenstrualCycleAwareness));

		for (WebElement op : menstrualOptions) {
			if (op.getText().equals(options))
				return true;
		}
		return false;
	}

	// step5 functionality and step6UI
	public void selectMenstralCycleInfo() {
		driver.findElement(rdYesOptionForTrackCycle).click();
	}

	public boolean isErrorMessageDisplayed() {
		return false;
	}

	public boolean isCalendarIconVisible() {
		return driver.findElement(imgCalendar).isDisplayed();
	}

	public boolean getDateInputField() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		return wait.until(ExpectedConditions.visibilityOfElementLocated(textDateInputField)).isDisplayed();
	}

	public String getLabelUnderDateField() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		return wait.until(ExpectedConditions.visibilityOfElementLocated(lblCycleLength)).getText();
	}

	public boolean isSliderControlVisible() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		return wait.until(ExpectedConditions.visibilityOfElementLocated(sliderBar)).isDisplayed();
	}

	public String getCycleLengthValue() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		return wait.until(ExpectedConditions.visibilityOfElementLocated(txtCycleLengthValue)).getText();
	}

	public String getInformationText() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		return wait.until(ExpectedConditions.visibilityOfElementLocated(txtInformationText)).getText();
	}

}
