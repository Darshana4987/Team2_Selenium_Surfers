package com.herBalance.pageObjects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

import com.herBalance.utils.ConfigReader;

public class LoginPageObject {

	public WebDriver driver;
	WebDriverWait wait;
	private static Logger logger = LogManager.getLogger();

	private By usernameInput = By.name("username");
	private By passwordInput = By.name("password");
	private By loginButton = By.xpath("//button[@type='submit' and normalize-space()='LogIn']");
	private By dashboardHeader = By.xpath("//h1[contains(normalize-space(), 'Dashboard')]");
	private By errorMessageLocator = By.xpath("//div[@class='error-message' or contains(text(),'Login Failed') ]");
	private By emptyErrorMsg = By
			.xpath("//p[contains(text(), 'Email is required') or contains(text(), 'Password is required')]");
	private By logoHerBalance = By.xpath("//img[@alt='HerBalance Logo']");
	private By logintabactive = By
			.xpath("//button[@role='tab' and normalize-space()='Login' and @data-state='active']");
	private By showPasswordCheckbox = By.xpath("//button[@id='showPassword' and @role='checkbox']");
	private By passwordfield = By.xpath("//input[@name='password']");
	private By passwordInputField = By.xpath("//input[@type='password' and @name='password']");

	public LoginPageObject(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}

	public void geturll() {

		driver.get(ConfigReader.getUrl());
	}

	public void getusernamePwd() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(usernameInput)).sendKeys(ConfigReader.getUsername());
		wait.until(ExpectedConditions.visibilityOfElementLocated(passwordInput)).sendKeys(ConfigReader.getPassword());

	}

	public void loginbtn() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(loginButton)).click();
		logger.info("Logging in Her balance application");

	}

	public boolean isDashboardLoaded() {

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[contains(text(),'Dashboard')]")));
		return driver.getCurrentUrl().contains("/dashboard");
	}

	private By tabByName(String tabName) {

		return By.xpath("//button[@role='tab' and normalize-space()='" + tabName + "']");
	}

	public boolean isTabVisible(String tabName) {
		try {
			WebElement tab = wait.until(ExpectedConditions.visibilityOfElementLocated(tabByName(tabName)));
			return tab.isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}

	public WebElement verifyLogo() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(logoHerBalance));
	}

	public boolean isShowPasswordOptionVisible() {
		try {
			WebElement showPassword = wait.until(ExpectedConditions.visibilityOfElementLocated(showPasswordCheckbox));
			return showPassword.isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}

	public boolean isPasswordFieldVisibleAndMasked() {
		try {
			WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(passwordInputField));
			return passwordField.isDisplayed() && "password".equals(passwordField.getAttribute("type"))
					&& "••••••••".equals(passwordField.getAttribute("placeholder"));
		} catch (Exception e) {
			return false;
		}
	}

	public boolean isLoginTabActive() {
		try {
			WebElement loginTab = wait.until(ExpectedConditions.visibilityOfElementLocated(logintabactive));
			return loginTab.isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}

	private By emailInputField(String placeholderText) {

		return By.xpath("//input[@type='email' and @placeholder='" + placeholderText + "']");
	}

	public boolean isEmailFieldVisibleWithPlaceholder(String placeholderText) {

		try {

			WebElement emailField = wait
					.until(ExpectedConditions.visibilityOfElementLocated(emailInputField(placeholderText)));
			return emailField.isDisplayed() && placeholderText.equals(emailField.getAttribute("placeholder"));
		} catch (Exception e) {
			return false;
		}
	}
}