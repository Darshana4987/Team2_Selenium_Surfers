package com.herBalance.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class MenstrualPhaseLogPage {
	private WebDriver driver;
	private By activityButton = By.xpath("//button[@id='radix-:r18:']/span");
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
	private By menstrualPhaseLabels = By.xpath(".//div[2]/div[1]/div[3]");
	private By currentPhaseSection = By.xpath(".//div[2]/div[2]");
	private By progressBar = By.xpath("//div[@role='progressbar']/div");
	private By currentPhase = By.xpath(".//div[2]/div[2]/div[1]/div[2]");
	private By lastPeriodStarted = By.xpath(".//div[2]/div[2]/div[2]/div[1]/div[2]");
	private By nextPeriodExpected = By.xpath(".//div[2]/div[2]/div[2]/div[2]/div[2]");
	private By currentPhaseDetailsHeading = By.xpath(".//div[2]/div[3]/div[1]");
	private By currentPhaseDetailsContent = By.xpath(".//div[2]/div[3]/div[2]");
	
	private By currentCycleStatusLabels(String name) {
		return By.xpath(String.format("//div[text()='%s']", name));
	}
	
	
	private By sectionHeading(String heading) {
		return By.xpath(String.format("//h3[text()='%s']", heading));
	}
	
	private By menstrualCycleTrackerTab(String tabText) {
		return By.xpath(String.format("//button[text()='%s')]", tabText));
	}
	
	
	private By menstrualCycleTrackerButton(String buttonText) {
			return By.xpath(String.format("//span[text()='%s']/parent::button", buttonText));
	}
	
	
	public MenstrualPhaseLogPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void clickActivityInsights() {
		driver.findElement(activityButton).click();
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
	
	public List<WebElement> getPhaseLabels() {
		WebElement cycleStatus = driver.findElement(currentCycleStatusSection);
		return cycleStatus.findElements(menstrualPhaseLabels);
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
	
	public WebElement getCurrentPhase() {
		WebElement cycleStatus = driver.findElement(currentCycleStatusSection);
		return cycleStatus.findElement(currentPhase);
	}
	
	public WebElement getLastPeriodStarted() {
		WebElement cycleStatus = driver.findElement(currentCycleStatusSection);
		return cycleStatus.findElement(lastPeriodStarted);
	}
	
	public WebElement getNextPeriodExpected() {
		WebElement cycleStatus = driver.findElement(currentCycleStatusSection);
		return cycleStatus.findElement(nextPeriodExpected);
	}
	
	
}
