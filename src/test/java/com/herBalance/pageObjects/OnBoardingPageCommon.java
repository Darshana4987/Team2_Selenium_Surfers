package com.herBalance.pageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class OnBoardingPageCommon {
	private WebDriver driver;

	private By btnSignUp = By.xpath("//button[text()='Sign Up']");
	private By txtUserName = By.xpath("//input[@name='username']");
	private By txtPwd = By.xpath("//input[@name='password']");
	private By txtConfirmPwd = By.xpath("//input[@name='confirmPassword']");
	private By rdoAgree = By.xpath("//button[@id=':r8:-form-item']");
	private By btnRegister = By.xpath("//button[text()='Register']");

	private By btnContinueWithoutReport = By.xpath("//button[text()='Continue Without Report']");
	private By btnContinue = By.xpath("//button[text()='Continue']");
	private By txtFirstName = By.xpath("//input[@id='name']");
	private By txtAge = By.xpath("//input[@id='age']");
	private By rdoNeverDiagnosed = By.xpath("//span[text()='I have never been diagnosed']");

	private By headerAllTitles = By.xpath("//h2[contains(@class,'text-2xl')]");
	private By onBoardingProcessBar = By.xpath("//div[contains(@class, 'w-full')]");
	private By txtProcessBarStepNumber = By.xpath("//div[contains(@class,'flex justify-between')]//span[2]");
	private By txtDescriptionText = By.xpath("//p[@class='text-black mb-6']");
	private By btnBack = By.xpath("//button[text()='Back']");
	private By rdYesOptionForTrackCycle = By.xpath("//label[text()='Yes']");
	private By popup = By.xpath("//button[@type='button']");
	private Logger logger = LogManager.getLogger();

	private WebDriverWait wait;

	public OnBoardingPageCommon(WebDriver driver) {
		this.driver = driver;
	}

	public void navigateToSignInPage() {
		driver.findElement(btnSignUp).click();
	}

	public void enterValidCredentialsForSignUp() {
		String userName = "abcdfg" + System.currentTimeMillis() + "@gmail.com";
		String password = "123456";
		driver.findElement(txtUserName).sendKeys(userName);
		driver.findElement(txtPwd).sendKeys(password);
		driver.findElement(txtConfirmPwd).sendKeys(password);
	}

	public void clickRegister() {
		enterValidCredentialsForSignUp();
		driver.findElement(rdoAgree).click();
		driver.findElement(btnRegister).click();
	}

	public void navigatesToStep2() {
		navigateToSignInPage();
		clickRegister();
	}

	public void navigatesToStep3() {
		navigatesToStep2();
		clickContunueWithOutReportButton();
		clearSucessfulRegistationPopUp();
	}

	public void navigatesToStep4() {
		navigatesToStep3();
		clickContinue();
	}

	public void navigatesToStep5() {
		navigatesToStep4();
		enterValidPersonalDetails();
		clickContinue();
	}

	// Step 6 to Step 11

	public void navigatesToStep6() {
		navigatesToStep5();
		selectMenstralCycleInfo();
		clickContinue();
	}

	public void navigatesToStep7() {
		navigatesToStep6();
	}

	public void navigatesToStep8() {
		navigatesToStep7();
	}

	public void navigatesToStep9() {
		navigatesToStep8();
	}

	public void navigatesToStep10() {
		navigatesToStep9();
	}

	public void navigatesToStep11() {
		navigatesToStep10();
	}

	public void clickContunueWithOutReportButton() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(btnContinueWithoutReport)).click();
	}

	public void clickContinue() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(btnContinue)).click();
	}

	public void clearSucessfulRegistationPopUp() {
		try {
			wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(popup)).click();
		} catch (Exception e) {
			logger.error("Unable to clear sucessful registation pop-up and click continue button. {}", e.getMessage());
		}
	}

	public void enterValidPersonalDetails() {
		driver.findElement(txtFirstName).sendKeys("smitha");
		driver.findElement(txtAge).sendKeys("25");
		driver.findElement(rdoNeverDiagnosed).click();
	}

	public String getTitleForAllSteps() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		return wait.until(ExpectedConditions.visibilityOfElementLocated(headerAllTitles)).getText();
	}

	public boolean isOnBoardingProcessBarVisible() {
		return driver.findElement(onBoardingProcessBar).isDisplayed();
	}

	public String getProcessBarStepNumber() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		return wait.until(ExpectedConditions.visibilityOfElementLocated(txtProcessBarStepNumber)).getText();
	}

	public String getDescriptionTextForSteps() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		return wait.until(ExpectedConditions.visibilityOfElementLocated(txtDescriptionText)).getText();
	}

	public void clickBackButton() {
		driver.findElement(btnBack).click();
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

	public boolean isBackButtonVisible() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		return wait.until(ExpectedConditions.visibilityOfElementLocated(btnBack)).isDisplayed();
	}

	public boolean isBackButtonEnabled() {
		return driver.findElement(btnBack).isEnabled();
	}

	public boolean isContinueButtonEnabledForStep5() {
		driver.findElement(rdYesOptionForTrackCycle).click();
		return driver.findElement(btnContinue).isEnabled();
	}

	public void selectMenstralCycleInfo() {
		driver.findElement(rdYesOptionForTrackCycle).click();
	}

	public boolean isContinueButtonVisible() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		return wait.until(ExpectedConditions.visibilityOfElementLocated(btnContinue)).isDisplayed();
	}

	public boolean isContinueButtonEnabled() {
		return driver.findElement(btnContinue).isEnabled();
	}

	public void enterInvalidAge(String invalidAge) {
		driver.findElement(txtAge).sendKeys(invalidAge);
	}

	public void clickImNotSure() {
		driver.findElement(rdoNeverDiagnosed).click();
	}
}
