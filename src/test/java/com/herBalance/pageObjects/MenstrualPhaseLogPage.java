package com.herBalance.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class MenstrualPhaseLogPage {
	private WebDriver driver;
	private By activityButton = By.xpath("//button[@id='radix-:r18:']/span");
	private By menustrualPhaseLogButton = By.xpath("//div[@role='menuitem']/a[@href='/track/menstrual-cycle']");
	private By currentCycleStatusSection = By.xpath("//h3[text()='Current Cycle Status']/ancestor::div[2]");
	private By upcomingPhasesSection = By.xpath("//h3[text()='Upcoming Phases']/ancestor::div[2]");
	private By recommendedActivitesSection = By.xpath("//h3[text()='Recommended Activities']/ancestor::div[2]");
	private By nutritionTipsSection = By.xpath("//h3[text()='Nutrition Tips']/ancestor::div[2]");
	private By nextPeriodSection = By.xpath("//h3[text()='Next Period']/ancestor::div[2]");
	private By backToDashboard = By.xpath("//span[text()='Back to Dashboard']/parent::a");
	private By cycleProgress = By.xpath(".//div[2]/div[1]/div[1]");
	private By menstrualPhaseLabels = By.xpath(".//div[2]/div[1]/div[3]");
	private By progressBar = By.xpath("//div[@role='progressbar']/div");
	
	
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
}
