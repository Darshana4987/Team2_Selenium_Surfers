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
	private By txaSupportingText = By.xpath("//p[contains(., 'Welcome to HerBalance!')]");
	private By btnUploadPDF = By.xpath("//button[text()='Upload PDF']");
	private By txtPDfFileSize = By.xpath("//p[text()='PDF files only (Max 10MB)']");
	private By headerSkipForNow = By.xpath("//h3[text()='Skip for Now']");
	private By txtWithoutReportExplanation = By.xpath("//p[contains(., 'You can continue without uploading')]");
	private By txtSecureProcessingNote = By.xpath("//p[contains(., 'Your data is securely processed')]");
	private By headerTitle = By.xpath("//h2[text()='Upload Your Recent Blood Work']");

	// step1 Functionality
	private By msgOnlyPDFFilesError = By.xpath("//p[text()='Please upload a PDF file only.']");
	private By msgFileExceedError = By.xpath("//p[contains(text(),'File is too large')]");
	private By processingPercentageBar = By.xpath("//div[contains(@class,'h-full bg-gradient-to-r')]");
	private By btnAnalyseReport = By.xpath("//button[text()='Analyze Report']");
	private By txtAnalysingReport = By.xpath("//p[text()='Analyzing your blood work report']");

	// Step3
	private By txtManuallyEnterQuestion = By.xpath("//p[contains(.,'Want to manually enter')]");
	private By rdoTotalRadioButtons = By.xpath("//div[contains(@class,'grid')]//input[@type='checkbox']");
	private By lblOptionsTextForHealthCondition = By.xpath("//div[contains(@class,'flex ')]//label");
	private By txaNoteText = By.xpath("//p[contains(.,'Conditions like')]");

	// Step4
	private By txtInputBox = By.xpath("//input[contains(@class,'w-full')]");
	private By lblInputFields = By.xpath("//label[contains(@class,'block text-sm ')]");
	private By txtHelperTextForLabels = By.xpath("//p[contains(@class,'text-xs')]");
	private By rdoTotalRdButtonsStep4 = By.xpath("//div[contains(@class, 'h-5')]");
	private By lblOptionsForBlooodPressure = By.xpath("//div[contains(@class, 'space-y-3')]//div//span");

	// step5
	private By txtInputPersonalDetails = By.xpath("//input[contains(@class,'w-full')]");
	private By msgInvalidValueError = By.xpath("//p[contains(@class,'text-xs text-red')]");
	private By txtQuestionsAboutMenstruation = By.xpath("//h3[contains(@class,'text-lg')]");
	private By rdoTotalRdButtonsStep5 = By.xpath("//input[@type='radio']");
	private By lblOptionsForMenstrualCycleAwareness = By.xpath("//label[contains(@class,'block text')]");

	// Step6 UI
	private By imgCalendar = By.xpath("//input[@type='date']");
	private By textDateInputField = By.xpath("(//input[@type='date'])[1]");
	private By lblCycleLength = By.xpath("//label[contains(@class,'block text')]");
	private By sliderBar = By.xpath("//input[@id='cycle-length']");
	private By txtCycleLengthValue = By.xpath("//span[contains(@class,'ml-3')]");
	private By txtInformationText = By.xpath("//p[contains(text(),'Average cycle length')]");

	private WebDriverWait wait;

	public OnBoardingPagePart1(WebDriver driver) {
		this.driver = driver;
	}

	// Step1
	public boolean isSupportingTextForUploadBloodWorkVisible() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		return wait.until(ExpectedConditions.visibilityOfElementLocated(txaSupportingText)).isDisplayed();
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

	public boolean isNoteAboutSecureProcessingVisible() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		return wait.until(ExpectedConditions.visibilityOfElementLocated(txtSecureProcessingNote)).isDisplayed();
	}

	public String getUploadYourBloodWorkTitle() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		return wait.until(ExpectedConditions.visibilityOfElementLocated(headerTitle)).getText();
	}

	// step1 Functionality
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
	public String getWantToManuallyQuestionTitle() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		return wait.until(ExpectedConditions.visibilityOfElementLocated(txtManuallyEnterQuestion)).getText();
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

	// Step4
	public void clickToSelectHealthCondition() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		List<WebElement> healthCondition = wait
				.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(lblOptionsTextForHealthCondition));

		for (WebElement hcWebElement : healthCondition) {
			if (hcWebElement.getText().equals("PCOS"))
				hcWebElement.click();
		}
	}

	public int getInputBoxCount() {
		return driver.findElements(txtInputBox).size();
	}

	public boolean isInputLabelVisible(String inputLabel) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		List<WebElement> inputBoxLabel = wait
				.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(lblInputFields));

		for (WebElement inputBox : inputBoxLabel) {
			if (inputBox.getText().equals(inputLabel))
				return true;
		}
		return false;
	}

	public boolean isHelperTextVisible(String helperText) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		List<WebElement> helperTextLabel = wait
				.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(txtHelperTextForLabels));

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
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		List<WebElement> bloodPressureLabel = wait
				.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(lblOptionsForBlooodPressure));

		for (WebElement b : bloodPressureLabel) {
			if (b.getText().equals(bloodPressureOptionLabel))
				return true;
		}
		return false;
	}

	// step5

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
