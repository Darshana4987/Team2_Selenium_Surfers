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
		return driver.findElement(btnBack).isDisplayed();
	}

	public boolean isBackButtonEnabled() {
		return driver.findElement(btnBack).isEnabled();
	}

	public boolean isContinueButtonVisible() {
		return driver.findElement(btnContinue).isDisplayed();
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
		List<WebElement> radiobuttonlabel = driver.findElements(lblOptionsTextForHealthCondition);

		for (WebElement r : radiobuttonlabel) {
			if (r.getText().equals(radioButtonOption))
				return true;
		}
		return false;
	}

	public boolean isNoteTextVisible() {
		return driver.findElement(txaNoteText).isDisplayed();
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

}
