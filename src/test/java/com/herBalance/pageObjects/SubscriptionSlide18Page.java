package com.herBalance.pageObjects;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeoutException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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
	private By planTiles = By.xpath("//div[contains(@class,'grid')]");
	private By planTitleText = By.xpath("./div/div/h2");
	private By planTitleSubText = By.xpath("./div/div/p");
	private By planHeaderText = By.xpath("//p[contains(@class, 'font-semibold')]");
	private By planSubHeaderText = By.xpath("//p[contains(@class, 'text-xs')]");
	private By freePlanChecklist = By.xpath("//p[text()='Free']/../../ul");
	private By monthlyPlanChecklist = By.xpath("//p[text()='$39.99']/../../ul");
	private By threeMonthPlanChecklist = By.xpath("//p[text()='$99.99']/../../ul");
	private By onboardingCompletePopUp = By.xpath("//li[@role='status']/button");
	
	private By subscribeNowButton(String text) {
		return By.xpath(String.format("//h2[contains(text(),'%s')]/../../div[3]/button", text));
	}
	
	
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
		logger.info("Onboarding complete. Closing popup");
		closeOnboardingCompletePopup();
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
	
	public boolean planTitleTextDisplayed(String planText) {
		List<WebElement> tiles = getPlanTiles();
		Boolean displayed = false;
		for (WebElement tile : tiles) {
			String text = tile.findElement(planTitleText).getText();
			if (text.contains(planText)) {
				logger.info(planText + "title text visible in the page");
				displayed = true;
				break;
			}
		}
		return displayed;
	}
	
	public boolean planTitleSubTextDisplayed(String subText) {
		List<WebElement> tiles = getPlanTiles();
		Boolean displayed = false;
		for (WebElement tile : tiles) {
			String text = tile.findElement(planTitleSubText).getText();
			System.out.println(text);
			if (text.contains(subText)) {
				logger.info(subText + "title sub text visible in the page");
				displayed = true;
				break;
			}
		}
		return displayed;
	}
	
	public boolean planHeaderTextDisplayed(String headerText) {
		List<WebElement> headers = driver.findElements(planHeaderText);
		Boolean displayed = false;
		for (WebElement header  : headers) {
			if (header.getText().contains(headerText)) {
				logger.info(headerText + "visible in the page");
				displayed = true;
				break;
			}
		}
		return displayed;
	}
	
	public boolean planHeaderSubTextDisplayed(String subHeaderText) {
		List<WebElement> subHeaders = driver.findElements(planSubHeaderText);
		Boolean displayed = false;
		for (WebElement subHeader  : subHeaders) {
			if (subHeader.getText().contains(subHeaderText)) {
				logger.info(subHeaderText + "visible in the page");
				displayed = true;
				break;
			}
		}
		return displayed;
	}
	
	public boolean freePlanCheckListDisplayed(String text) {
		boolean displayed = false;
		WebElement checklistParent = driver.findElement(freePlanChecklist);
		List<WebElement> checklist = checklistParent.findElements(By.xpath("./li"));
		for (WebElement element : checklist) {
			if (element.getText().contains(text)) {
				logger.info("free plan checklist "+ text + "visible in the page");
				displayed = true;
			}
		}
		return displayed;
	}
	
	public boolean monthlyPlanCheckListDisplayed(String text) {
		boolean displayed = false;
		WebElement checklistParent = driver.findElement(monthlyPlanChecklist);
		List<WebElement> checklist = checklistParent.findElements(By.xpath("./li"));
		for (WebElement element : checklist) {
			if (element.getText().contains(text)) {
				logger.info("monthly plan checklist "+ text + "visible in the page");
				displayed = true;
			}
		}
		return displayed;
	}
	
	public boolean threeMonthPlanCheckListDisplayed(String text) {
		boolean displayed = false;
		WebElement checklistParent = driver.findElement(threeMonthPlanChecklist);
		List<WebElement> checklist = checklistParent.findElements(By.xpath("./li"));
		for (WebElement element : checklist) {
			if (element.getText().contains(text)) {
				logger.info("3 month plan checklist "+ text + "visible in the page");
				displayed = true;
			}
		}
		return displayed;
	}
	
	public WebElement getSubscribeNowButton(String text) {
		return driver.findElement(subscribeNowButton(text));
	}
	
	public void closeOnboardingCompletePopup() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
			wait.until(ExpectedConditions.elementToBeClickable(onboardingCompletePopUp));
			driver.findElement(onboardingCompletePopUp).click();
		} catch(Exception e) {
			//popup not appear
		}
	}
}
