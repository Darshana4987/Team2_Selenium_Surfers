package com.herBalance.pageObjects;

import java.time.Duration;

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

	private WebDriverWait wait;

	public OnBoardingPagePart1(WebDriver driver) {
		this.driver = driver;
	}

//	public void gotoSignPage() {
//		By btnSignUp = By.xpath("//button[text()='Sign Up']");
//		driver.findElement(btnSignUp).click();
//	}
//
//	public void clickRgister() {
//		By txtUserName = By.xpath("//input[@name='username']");
//		By txtPwd = By.xpath("//input[@name='password']");
//		By txtConfirmPwd = By.xpath("//input[@name='confirmPassword']");
//		By rdoAgree = By.xpath("//button[@id=':r8:-form-item']");
//		By btnRegister = By.xpath("//button[text()='Register']");
//		String userName = "abcdfg" + System.currentTimeMillis() + "@gmail.com";
//		String password = "123456";
//		driver.findElement(txtUserName).sendKeys(userName);
//		driver.findElement(txtPwd).sendKeys(password);
//		driver.findElement(txtConfirmPwd).sendKeys(password);
//		driver.findElement(rdoAgree).click();
//		driver.findElement(btnRegister).click();
//	}

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
		WebElement uploadPdfButton = wait.until(ExpectedConditions.visibilityOfElementLocated(txtPDfFileSize));
		return uploadPdfButton.isDisplayed() && uploadPdfButton.getText().equalsIgnoreCase(buttonText);
	}

	public boolean isSkipForNowCardAndCardTextVisible(String buttonText) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		WebElement uploadPdfButton = wait.until(ExpectedConditions.visibilityOfElementLocated(headerSkipForNow));
		return uploadPdfButton.isDisplayed() && uploadPdfButton.getText().equalsIgnoreCase(buttonText);
	}

	public boolean isExplanationTextWithoutReportVisible() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		return wait.until(ExpectedConditions.visibilityOfElementLocated(txtWithoutReportExplanation)).isDisplayed();
	}

	public boolean isContinueWithoutReportButtonAndButtontextVisible(String buttonText) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		WebElement uploadPdfButton = wait
				.until(ExpectedConditions.visibilityOfElementLocated(btnContinueWithoutReport));
		return uploadPdfButton.isDisplayed() && uploadPdfButton.getText().equalsIgnoreCase(buttonText);
	}

	public boolean isContinueWithoutReportButtonEnabled() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		return wait.until(ExpectedConditions.visibilityOfElementLocated(btnContinueWithoutReport)).isEnabled();
	}

	public boolean isNoteAboutSecureProcessingVisible() {

		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		return wait.until(ExpectedConditions.visibilityOfElementLocated(txtSecureProcessingNote)).isDisplayed();
	}

	public void clickContunueWithOutReportButton() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(btnContinueWithoutReport)).click();
	}
}
