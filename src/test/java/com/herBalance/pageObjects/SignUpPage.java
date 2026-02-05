package com.herBalance.pageObjects;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.herBalance.utils.ConfigReader;

public class SignUpPage {

	public WebDriver driver;
	WebDriverWait wait;
	private static Logger logger = LogManager.getLogger();
	private By headerTitle = By.xpath("//h2[text()='Upload Your Recent Blood Work']");
	private By emailfield = By.xpath("//input[@placeholder='you@example.com']");
	private By SignUpButton = By.xpath("//button[contains(text(),'Sign Up')]");
	private By register = By.xpath("//button[contains(text(),'Register')]");
	private By termsCheckbox = By.xpath("//button[@data-testid='input-terms']");
	private By password = By.xpath("//input[@name='password']");
	private By email = By.xpath("//input[@name='username']");
	private By confirmPassword = By.xpath("//input[@name='confirmPassword']");

	public SignUpPage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}

	public void geturll() {

		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.get(ConfigReader.getUrl());
	}

	public String isEmailDisplayed() {

		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		return wait.until(ExpectedConditions.visibilityOfElementLocated(emailfield)).getAttribute("placeholder");
	}

	public boolean isPasswordDisplayed() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		return wait.until(ExpectedConditions.visibilityOfElementLocated(password)).isDisplayed();
	}

	public boolean isConfirmPasswordDisplayed() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		return wait.until(ExpectedConditions.visibilityOfElementLocated(confirmPassword)).isDisplayed();
	}

	public void signUpButtonClick() {

		driver.findElement(SignUpButton).click();
		logger.info("Logging in Her balance application");

	}
	/*
	 * public void getUserEmail() {
	 * 
	 * driver.findElement(email).sendKeys(ConfigReader.getUseremail());
	 * 
	 * driver.findElement(password).sendKeys(ConfigReader.getpassword1());
	 * 
	 * driver.findElement(confirmPassword).sendKeys(ConfigReader.getpassword2());
	 * 
	 * }
	 */

	public void clickTerms() {
		wait.until(ExpectedConditions.elementToBeClickable(termsCheckbox)).click();
		logger.info("Logging in Her balance application");

	}

	public void registerButton() {
		driver.findElement(register).click();
		logger.info("Logging in Her balance application");

	}

	public boolean isOnboardingPage() {

		wait.until(ExpectedConditions.visibilityOfElementLocated(headerTitle));
		return driver.getCurrentUrl().contains("/onboarding");
	}

	public String getUploadYourBloodWorkTitle() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		return wait.until(ExpectedConditions.visibilityOfElementLocated(headerTitle)).getText();
	}

	public void enterUsername(String username) {
		driver.findElement(email).sendKeys(username);
	}

	public void enterPassword(String password1) {
		driver.findElement(password).sendKeys(password1);
	}

	public void enterConfirmPassword(String confirmPassword1) {
		driver.findElement(confirmPassword).sendKeys(confirmPassword1);
	}

	public void clickRegister() {

		wait.until(ExpectedConditions.elementToBeClickable(register)).click();

	}

	public void registerUser(String username, String password, String confirmPassword) {
		enterUsername(username);
		enterPassword(password);
		enterConfirmPassword(confirmPassword);
		clickTerms();
		clickRegister();
	}
}
