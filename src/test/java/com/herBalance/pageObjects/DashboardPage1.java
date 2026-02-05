package com.herBalance.pageObjects;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DashboardPage1 {

	public WebDriver driver;
	WebDriverWait wait;
	private static Logger logger = LogManager.getLogger();

	private By pagetitle = By.xpath("//h1[contains(text(),'Free Plan Dashboard')]");
	private By username = By.xpath("//p[contains(text(),'Welcome back')]");
	private By icon = By.xpath("//div[contains(@class,'rounded-full bg-')])[1]");

	public DashboardPage1(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	}

	public boolean isProfileNameDisplayed() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(pagetitle)).isDisplayed();
	}

	public String getProfileName() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(pagetitle)).getText();
	}

	public boolean isUserNameDisplayed() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(username)).isDisplayed();
	}

	public boolean isProfileIconDisplayed() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(icon)).isDisplayed();
	}
}
