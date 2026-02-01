package com.herBalance.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class MenstrualPhaseLogPage {
	private WebDriver driver;
	private By activityButton = By.xpath("//button[@id='radix-:r18:']/span");
	private By menustrualPhaseLogButton = By.xpath("//div[@role='menuitem']/a[@href='/track/menstrual-cycle']");
	private By currentCycleStatusSection = By.xpath("//h3[contains(text(), 'Current Cycle Status')]/../..");
	private By upcomingPhasesSection = By.xpath("//h3[contains(text(), 'Upcoming Phases')]/../..");
	private By recommendedActivitesSection = By.xpath("//h3[contains(text(), 'Recommended Activities')]/../..");
	private By nutritionTipsSection = By.xpath("//h3[contains(text(), 'Nutrition Tips')]/../..");
	
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
}
