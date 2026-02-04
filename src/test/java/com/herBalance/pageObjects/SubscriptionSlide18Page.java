package com.herBalance.pageObjects;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SubscriptionSlide18Page {
	private static Logger logger = LogManager.getLogger();
	private WebDriver driver;
	
	
	private By diet = By.xpath("//input[@id='vegetarian']");
	private By activity = By.xpath("//input[@id='lightly_active']");
	private By allergy = By.xpath("(//button[@role='radio'])[3]");
	private By medications = By.xpath("(//button[@role='radio'])[4]");
	private By complete = By.xpath("//button[text()='Complete']");
	
	private By header = By.xpath("//h1[contains(text(), 'Transformation Journey')]");
	private By subtext = By.xpath("//p[contains(text(), 'All plans') and contains(text(), 'optimal results')]");
	private By planTiles = By.xpath("//h2[contains(text(), '7 Days Trial')]/ancestor::div[4]");
	
	
	public SubscriptionSlide18Page(WebDriver driver) {
		this.driver = driver;
	}
	
	public void clickDietPreferences() {
		driver.findElement(diet).click();
	}
	
	public void clickPhysicalActivity() {
		driver.findElement(activity).click();
	}
	
	public void clickFoodAllergy() {
		driver.findElement(allergy).click();
	}
	
	public void clickMedications() {
		driver.findElement(medications).click();
	}
	
	public void clickComplete() {
		driver.findElement(complete).click();
	}
	
	public WebElement getSubscriptionHeader() {
		return driver.findElement(header);
	}
	
	public WebElement getsubheaderText() {
		return driver.findElement(subtext);
	}
	
	public List<WebElement> getPlanTiles() {
		WebElement parent = driver.findElement(planTiles);
		return parent.findElements(By.xpath("./div"));
	}
}
