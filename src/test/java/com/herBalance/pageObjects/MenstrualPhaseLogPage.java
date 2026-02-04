package com.herBalance.pageObjects;

import java.time.Duration;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class MenstrualPhaseLogPage {
	private static Logger logger = LogManager.getLogger();
	private WebDriver driver;
	WebDriverWait wait;
	
	private By activityButton = By.xpath("//span[text()='Activity Insights']/parent::button");
	private By menustrualPhaseLogButton = By.xpath("//div[@role='menuitem']/a[@href='/track/menstrual-cycle']");
	private By backToDashboard = By.xpath("//span[text()='Back to Dashboard']/parent::a");
	
	//sections
	private By currentCycleStatusSection = By.xpath("//h3[text()='Current Cycle Status']/ancestor::div[2]");
	private By upcomingPhasesSection = By.xpath("//h3[text()='Upcoming Phases']/ancestor::div[2]");
	private By recommendedActivitesSection = By.xpath("//h3[text()='Recommended Activities']/ancestor::div[2]");
	private By nutritionTipsSection = By.xpath("//h3[text()='Nutrition Tips']/ancestor::div[2]");
	private By nextPeriodSection = By.xpath("//h3[text()='Next Period']/ancestor::div[2]");
	
	//current cycle
	private By cycleProgress = By.xpath(".//div[2]/div[1]/div[1]");
	private By currentPhaseSection = By.xpath(".//div[2]/div[2]");
	private By progressBar = By.xpath("//div[@role='progressbar']/div");
	private By currentPhase = By.xpath("//div[text()='Current Phase']/parent::div/div[2]");
	private By lastPeriodStarted = By.xpath("//div[text()='Last period started']/parent::div/div[2]");
	private By nextPeriodExpected = By.xpath("//div[text()='Next period expected']/parent::div/div[2]");
	private By currentPhaseDetailsHeading = By.xpath(".//div[2]/div[3]/div[1]");
	private By currentPhaseDetailsContent = By.xpath(".//div[2]/div[3]/div[2]");
	
	private By currentCycleStatusLabels(String name) {
		return By.xpath(String.format("//div[text()='%s']", name));
	}
	
	private By menstrualPhaseLabels(String name) {
		return By.xpath(String.format("//div[text()='%s']", name));
	}
	
	private By sectionHeading(String heading) {
		return By.xpath(String.format("//h3[text()='%s']", heading));
	}
	
	private By menstrualCycleTrackerTab(String tabText) {
		return By.xpath(String.format("//button[text()='%s']", tabText));
	}
	
	
	private By menstrualCycleTrackerButton(String buttonText) {
			return By.xpath(String.format("//span[text()='%s']/parent::button", buttonText));
	}
	
	
	public MenstrualPhaseLogPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void loginPage() {

		// driver = DriverFactory.getDriver(); // your driver setup
				wait = new WebDriverWait(driver, Duration.ofSeconds(10));
				driver.get("https://herbalance.numpyninja.com");
				
				WebElement emailInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username")));
				emailInput.sendKeys("test123456@gmail.com");

				WebElement passwordInput = driver.findElement(By.name("password"));
				passwordInput.sendKeys("test123456");
				
				WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit' and text()='LogIn']"));
				loginButton.click();
		        logger.info("Logging in Her balance application");
		       
	}
	
	public void clickActivityInsights() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
					wait.until(
							ExpectedConditions.elementToBeClickable(activityButton)).click();
	}
	
	public void clickMenstrualPhaseLogs() {
		driver.findElement(menustrualPhaseLogButton).click();
	}
	
	public WebElement getCurrentCycleStatus() {
		return driver.findElement(currentCycleStatusSection);
	}
	
	public WebElement getUpcomingPhasesSection() {
		return driver.findElement(upcomingPhasesSection);
	}
	
	public WebElement getRecommendedActivitiesSection() {
		return driver.findElement(recommendedActivitesSection);
	}
	
	public WebElement getNutritionTipsSection() {
		return driver.findElement(nutritionTipsSection);
	}
	
	public WebElement getNextPeriodSection() {
		return driver.findElement(nextPeriodSection);
	}
	
	public WebElement getMenstrualCycleTrackerButton(String text) {
		return driver.findElement(menstrualCycleTrackerButton(text));
	}
	
	public WebElement getBackToDashboard() {
		return driver.findElement(backToDashboard);
	}
	
	public WebElement getMenstrualCycleTrackerTab(String text) {
		return driver.findElement(menstrualCycleTrackerTab(text));
	}
	
	public WebElement getSectionHeading(String heading) {
		return driver.findElement(sectionHeading(heading));
	}
	
	public String getCurrentCycleProgress() {
		WebElement cycleStatus = driver.findElement(currentCycleStatusSection);
		return cycleStatus.findElement(cycleProgress).getText();
	}
	
	public WebElement getPhaseLabels(String labelName) {
		return driver.findElement(menstrualPhaseLabels(labelName));
	}
	
	public WebElement getMenstrualProgressBar() {
		return driver.findElement(progressBar);
	}
	
	//have to check if this is needed
	public List<WebElement> getCurrentPhaseElements() {
		WebElement cycleStatus = driver.findElement(currentCycleStatusSection);
		return cycleStatus.findElements(currentPhaseSection);
	}
	
	public WebElement getCycleStatusLabels(String name) {
		WebElement cycleStatus = driver.findElement(currentCycleStatusSection);
		return cycleStatus.findElement(currentCycleStatusLabels(name));
	}
	
	public String getCurrentPhase() {
		return driver.findElement(currentPhase).getText();
	}
	
	public String getLastPeriodStarted() {
		return driver.findElement(lastPeriodStarted).getText();
	}
	
	public String getNextPeriodExpected() {
		return driver.findElement(nextPeriodExpected).getText();
	}
	
	public String getCurrentPhaseDetailsHeading() {
		return driver.findElement(currentPhaseDetailsHeading).getText();
	}
	
	public String getCurrentPhaseDetailsContent() {
		return driver.findElement(currentPhaseDetailsContent).getText();
	}

}
