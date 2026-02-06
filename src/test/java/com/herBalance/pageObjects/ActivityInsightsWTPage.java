package com.herBalance.pageObjects;

import java.time.Duration;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ActivityInsightsWTPage {

	private static Logger logger = LogManager.getLogger();
	private WebDriver driver;
	WebDriverWait wait;
	
	private By activityInsightsButton = By.xpath("//button[.//span[text()='Activity Insights']]");
	private By currentWeightPath = By.xpath("//p[contains(@class,'text-sm') and contains(@class,'text-gray-600')][text()='Current Weight']/following-sibling::p[contains(@class,'font-bold')]");
	private By trackWeightPath = By.xpath("//div[@role='menuitem']//a[@href='/track/weight']");
	private By successMessagePath = By.xpath("//li[@role='status' and @data-state='open']//div[text()='Weight Logged Successfully']");
	private By errorMessagePath = By.xpath("//li[@role='status' and @data-state='open']//div[text()='Error']");
	private By backToDashboardButton = By.xpath("//button[contains(@class,'text-violet-600')]");
	private By header1Path = By.xpath("//h1[text()='Weight Tracking']");
	private By paragraph1Path = By.xpath("//p[contains(@class,'text-sm') and contains(@class,'text-gray-600') and contains(@class,'capitalize')]");
	private By card1Path = By.xpath("//p[text()='Starting Weight']");
	private By card2Path =  By.xpath("//p[text()='Current Weight']");
	private By card3Path =  By.xpath("//p[text()='Goal Weight']");
	private By heading1Path = By.xpath("//h3[text()='Progress Overview']");
	private By paragraph2Path = By.xpath("//span[text()='Weight Loss Progress']");
	private By paragraph3Path = By.xpath("//p[text()='Weight Lost']");
	private By paragraph4Path = By.xpath("//p[text()='Remaining']");
	private By heading2Path = By.xpath("//h3[text()='Weight Progression Over Time']");
	private By heading3Path = By.xpath("//h3[contains(.,'Log Today')]");
	private By logWeightButtonPath = By.xpath("//button[text()='Log Weight']");
	
	public ActivityInsightsWTPage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}

	public boolean isElementPresent(By locator) {
		return !driver.findElements(locator).isEmpty();
	}
	
	public void waitForToastsToDisappear() {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		List<WebElement> closeButtons = driver.findElements(
		    By.xpath("//button[@toast-close]")
		);
		for (WebElement btn : closeButtons) {
		    try {
		        wait.until(ExpectedConditions.elementToBeClickable(btn)).click();
		    } catch (Exception ignored) {}
		}
	}

	public String getUrl() {

		return driver.getCurrentUrl();
	}

	public boolean clickActivityInsights() {
		waitForToastsToDisappear();	
		WebElement activityInsightButton = wait.ignoring(StaleElementReferenceException.class).until(ExpectedConditions.elementToBeClickable(activityInsightsButton));
		Actions actionsActivity = new Actions(driver);
		actionsActivity.moveToElement(activityInsightButton).click().perform(); 
		WebElement trackWeightButton = wait.ignoring(StaleElementReferenceException.class).until(ExpectedConditions.elementToBeClickable(trackWeightPath));
		return trackWeightButton.isDisplayed(); 
	}

	public boolean clickTrackWeight() {
	
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement trackWeightButton = wait.ignoring(StaleElementReferenceException.class).until(ExpectedConditions.elementToBeClickable(trackWeightPath));
		Actions actionsTrackWeight = new Actions(driver);
		actionsTrackWeight.moveToElement(trackWeightButton).click().perform();
		return getUrl().contains("track/weight");
	}
	
	public boolean seeTrackWeightPageElement(String element, String value) {

		if (element.equals("Header1")) {
			waitForToastsToDisappear();
			return isElementPresent(header1Path);
		}
		else if (element.equals("Paragraph1")) {
			return isElementPresent(paragraph1Path);
		} 
		else if (element.equals("Button")) {			
			waitForToastsToDisappear();
			return isElementPresent(backToDashboardButton);
		}
		else if (element.equals("Card1")) {
			return isElementPresent(card1Path);
		}
		else if (element.equals("Card2")) {
			return isElementPresent(card2Path);
		}
		else if (element.equals("Card3")) {
			return isElementPresent(card3Path);
		}
		else if (element.equals("Heading1")) {
			return isElementPresent(heading1Path);
		}
		
		else if (element.equals("Paragraph2")) {
			return isElementPresent(paragraph2Path);
		}
		else if (element.equals("Paragraph3")) {
			return isElementPresent(paragraph3Path);
		}
		else if (element.equals("Paragraph4")) {
			return isElementPresent(paragraph4Path);
		}
		else if (element.equals("Heading2")) {
			return isElementPresent(heading2Path);
		}
		else if (element.equals("Heading3")) {
			return isElementPresent(heading3Path);
		} 
		else
		{
			return false;
		}
	}

	public boolean logWeightPageElement(String weight, String logMessage) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement weightInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("weight")));
		weightInput.clear();
		weightInput.sendKeys(String.valueOf(weight));

		WebElement logWeightButton = wait.until(ExpectedConditions.elementToBeClickable(logWeightButtonPath));
		logWeightButton.click();

		logger.info("Logging in Her balance application");
		if (logMessage.equals("Success"))
		{
			wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.visibilityOfElementLocated(successMessagePath));	 

			System.out.println("Logged Weight : "+weight);
			return isElementPresent(successMessagePath);
		
		}
		else if (logMessage.equals("Error"))
		{
			wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.visibilityOfElementLocated(errorMessagePath));
			return isElementPresent(errorMessagePath);
		}
		else
		{
			return false;
		}
	}

	public boolean verifyCurrentWeightElement(String weight) {

		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement currentWeight =wait.until(ExpectedConditions.visibilityOfElementLocated(currentWeightPath));
		System.out.println("Current Weight : "+currentWeight.getText());
		return (currentWeight.getText().contains(weight));
	}

	public boolean backToDashboard() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement goToDashboardButton = wait.until(ExpectedConditions.elementToBeClickable(backToDashboardButton));
		goToDashboardButton.click();
		return true;
	}
		
	public String getTitle() {

		return driver.getTitle();
	}

}
