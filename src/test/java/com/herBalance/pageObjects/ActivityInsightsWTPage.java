package com.herBalance.pageObjects;

import java.time.Duration;
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
	//span[text()='Activity Insights']/parent::button
	private By activityInsightsButton = By.xpath("//button[.//span[text()='Activity Insights']]");
	private By currentWeightPath = By.xpath("//p[contains(@class,'text-sm') and contains(@class,'text-gray-600')][text()='Current Weight']/following-sibling::p[contains(@class,'font-bold')]");
	private By trackWeightPath = By.xpath("//div[@role='menuitem']//a[@href='/track/weight']");
	private By logWeightMessage = By.xpath("//div[contains(@class,'text-lg') and contains(@class,'font-bold')]");
	private By successMessagePath = By.xpath("//li[@role='status' and @data-state='open']//div[text()='Weight Logged Successfully']");
	private By errorMessagePath = By.xpath("//li[@role='status' and @data-state='open']//div[text()='Error']");
	private By backToDashboardButton = By.xpath("//button[contains(@class,'text-violet-600')]");
	
	public ActivityInsightsWTPage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}

	public boolean isElementPresent(By locator) {
		return !driver.findElements(locator).isEmpty();
		//returns true if xpath is not empty, element is present
	}

	public String getUrl() {

		return driver.getCurrentUrl();
	}

	public boolean clickActivityInsights() {
			
		//wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement activityInsightButton = wait.ignoring(StaleElementReferenceException.class).until(ExpectedConditions.elementToBeClickable(activityInsightsButton));
		Actions actionsActivity = new Actions(driver);
		actionsActivity.moveToElement(activityInsightButton).click().perform(); 
		return isElementPresent(activityInsightsButton); 
	}

	public boolean clickTrackWeight() {
	
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement trackWeightButton = wait.ignoring(StaleElementReferenceException.class).until(ExpectedConditions.elementToBeClickable(trackWeightPath));
		Actions actionsTrackWeight = new Actions(driver);
		actionsTrackWeight.moveToElement(trackWeightButton).click().perform();
		return getUrl().contains("track/weight");
		//Assert.assertTrue(getUrl().contains("track/weight"), "URL should contain dashboard !");

	}
	
	public boolean seeTrackWeightPageElement(String element, String value) {

		if (element.equals("Header1")) {
			return isElementPresent(By.xpath("//h1[text()='" + value + "']"));
		}
		else if (element.equals("Paragraph1")) {
			WebElement paraText = driver.findElement(By.xpath("//p[contains(@class,'text-sm') and contains(@class,'text-gray-600') and contains(@class,'capitalize')]"));
			System.out.println("Paragraph:."+paraText.getText());
			return true;
		} 
		else if (element.equals("Card1")) {
			WebElement cardText = driver.findElement(By.xpath("//p[text()='Starting Weight']"));
			System.out.println("Card1:."+cardText.getText());
			return true;
		}
		else if (element.equals("Card2")) {
			WebElement currentWeightText = driver.findElement(By.xpath("//p[text()='Current Weight']"));
			System.out.println("Card2:."+currentWeightText.getText());
			return true;
		}
		else if (element.equals("Card3")) {
			WebElement goalWeightText = driver.findElement(By.xpath("//p[text()='Goal Weight']"));
			System.out.println("Card2:."+goalWeightText.getText());
			return true;
		}
		else if (element.equals("Heading1")) {
			WebElement overwiewText = driver.findElement(By.xpath("//h3[text()='Progress Overview']"));
			System.out.println("Heading1:."+overwiewText.getText());
			return true;
		}
		
		else if (element.equals("Paragraph2")) {
			WebElement progressText = driver.findElement(By.xpath("//h3[text()='Weight Loss Progress']"));
			System.out.println("Paragraph2:."+progressText.getText());
			return true;
		}
		else if (element.equals("Paragraph3")) {
			WebElement wLostText = driver.findElement(By.xpath("//p[text()='Weight Lost']"));
			System.out.println("Paragraph3:."+wLostText.getText());
			return true;
		}
		else if (element.equals("Paragraph4")) {
			WebElement paraText = driver.findElement(By.xpath("//p[text()='Remaining']"));
			System.out.println("Paragraph4:."+paraText.getText());
			return true;
		}
		else if (element.equals("Heading2")) {
			WebElement headingText = driver.findElement(By.xpath("//h3[text()='Weight Progression Over Time']"));
			System.out.println("Heading2:."+headingText.getText());
			return true;
		}
	/*	else if (element.equals("Heading3")) {
			WebElement headingText = driver.findElement(By.xpath(""));
			System.out.println("Heading3:."+headingText.getText());
			return true;
		} */
		
		{
			return false;
		}
	}

	public boolean logWeightPageElement(String weight, String logMessage) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement weightInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("weight")));
		weightInput.clear();
		weightInput.sendKeys(String.valueOf(weight));

		WebElement logWeightButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Log Weight']")));
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
			// return true;
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

	public boolean verifyCurrentWeightGraph() {

		Actions actions = new Actions(driver);
		WebElement point = driver.findElement(By.xpath("//*[local-name()='g' and contains(@class,'recharts-line-dots')]//*[local-name()='circle']"));
		actions.moveToElement(point).perform();
		WebElement tooltip = driver.findElement(By.xpath("//div[contains(@class,'recharts-tooltip-wrapper')]"));
		System.out.println("ToolTip:"+tooltip.getText());
		return true;
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
