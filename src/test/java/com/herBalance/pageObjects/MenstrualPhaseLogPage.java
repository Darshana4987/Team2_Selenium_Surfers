package com.herBalance.pageObjects;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.herBalance.utils.Helper;


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
	
	//upcoming phases
	private By upcomingPhasesHeader = By.xpath("//h3[text()='Upcoming Phases']");
	private By upcomingPhasesSubText = By.xpath("//p[text()='Plan ahead with your cycle phases']");
	private By upcomingPhasesSections = By.xpath("//div[@class='space-y-4']");
	private By upcomingPhasesSubSectionHeading = By.xpath("./div[1]/div/span");
	private By upcomingPhasesStartDate = By.xpath("./div[2]/span");
	
	//next period
	private By nextPeriodHeading = By.xpath("//h3[text()='Next Period']");
	private By nextPeriodDate = By.xpath("//h3[text()='Next Period']/../../div[2]/div/div[1]");
	private By daysRemaining = By.xpath("//h3[text()='Next Period']/../../div[2]/div/div[2]");
	
	private By currentPhaseHeading(String name) {
		return By.xpath(String.format("//span[text()='%s']/ancestor::div[3]", name));
	}
	
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
	

	public void clickActivityInsights() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.presenceOfElementLocated(activityButton));
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

	public WebElement getUpcomingPhasesHeader() {
		return driver.findElement(upcomingPhasesHeader);
	}
	
	public WebElement getUpcomingPhasesSubText() {
		return driver.findElement(upcomingPhasesSubText);
	}
	
	public List<WebElement> getUpcomingPhasesSections() {
		WebElement parent = driver.findElement(upcomingPhasesSections);
		return parent.findElements(By.xpath("./div"));
	}
	
	public boolean upcomingPhasesSectionHeadingDisplayed(String phase) {
		boolean found = false;
		List<WebElement> sections = getUpcomingPhasesSections();
		for (WebElement section : sections) {
			WebElement sectionHeading = section.findElement(upcomingPhasesSubSectionHeading);
			if (sectionHeading.getText().equals(phase) && sectionHeading.isDisplayed()) {
				found = true;
				break;
			}
		}
		return found;
	}
	
	public String getStartFormat(String phase) throws IOException {
		String current = Helper.calculateMenstrualPhase();
		if (phase.equals(current)) {
			return "Started";
		}
		else {
			return "Starts";
		}
	}
	
	public String GetUpcomingPhasesStartDate(String phase) {
		List<WebElement> sections = getUpcomingPhasesSections();
		for (WebElement section : sections) {
			WebElement sectionHeading = section.findElement(upcomingPhasesSubSectionHeading);
			if (sectionHeading.getText().equals(phase)) {
				String startDate = section.findElement(upcomingPhasesStartDate).getText();
				return startDate;
			}
			
		}
		return null;
	}
	
	public String currentPhaseHighlighted() throws IOException {
		String phase = Helper.calculateMenstrualPhase();
		WebElement current = driver.findElement(currentPhaseHeading(phase));
		return current.getCssValue("background-color");
	}
	
	public WebElement getNextPeriodHeading() {
		return driver.findElement(nextPeriodHeading);
	}
	
	public String getNextPeriodDate() {
		WebElement date = driver.findElement(nextPeriodDate);
		return date.getText();
	}
}
