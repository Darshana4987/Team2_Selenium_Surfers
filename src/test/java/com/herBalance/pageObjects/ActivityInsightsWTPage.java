package com.herBalance.pageObjects;

import static org.testng.Assert.assertTrue;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.herBalance.utils.Helper;

public class ActivityInsightsWTPage {
	
	private static Logger logger = LogManager.getLogger();
	private WebDriver driver;
	WebDriverWait wait;
	
	//private By activityInsightsButton = By.xpath("//span[text()='Activity Insights']/parent::button");
	private By trackWeightPath = By.xpath("//div[@role='menu']//a[@href='/track/weight']");
	//private By logWeightMessage = By.xpath("//div[contains(@class,'text-lg') and contains(@class,'font-bold')]");
	
	
	public ActivityInsightsWTPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public boolean isElementPresent(By locator) {
	    return !driver.findElements(locator).isEmpty();
	    //returns true if xpath is not empty, element is present
	}
	
	public String getUrl() {

		return driver.getCurrentUrl();
	}
	
	public void loginPage() {

		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.get("https://herbalance.numpyninja.com");
		
		WebElement emailInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username")));
		emailInput.sendKeys("test123456@gmail.com");

		WebElement passwordInput = driver.findElement(By.name("password"));
		passwordInput.sendKeys("test123456");
		
		WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit' and text()='LogIn']"));
		loginButton.click();
        logger.info("Logging in Her balance application");
    }//Login Ends
	
	public void clickActivityInsights() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    	WebElement activityInsightButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[.//span[normalize-space()='Activity Insights']]")));
    	Actions actionsActivity = new Actions(driver);
    	actionsActivity.moveToElement(activityInsightButton).click().perform();
 	    System.out.println("User menu clicked.");
	}
	
	public void clickTrackWeight() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement trackWeightButton = wait.until(ExpectedConditions.elementToBeClickable(trackWeightPath));
		//trackWeightButton.click();
		Actions actionsTrackWeight = new Actions(driver);
		actionsTrackWeight.moveToElement(trackWeightButton).click().perform();
		Assert.assertTrue(getUrl().contains("track/weight"), "URL should contain dashboard !");
 
}
public boolean seeTrackWeightPageElement(String element, String value) {
		
		if (element.equals("Header1")) {
			return isElementPresent(By.xpath("//h1[text()='" + value + "']"));
		}
		else if (element.equals("Paragraph1")) {
			//assertTrue(isElementPresent(By.xpath("//h3[text()='" + Subsvalue + "']")),Subsvalue+" "+Subsvalue+" Present ");
			WebElement loginButtoparaText = driver.findElement(By.xpath("//p[contains(@class,'text-sm') and contains(@class,'text-gray-600') and contains(@class,'capitalize')]"));
			 System.out.println("Paragraph:."+loginButtoparaText.getText());
			 return true;
		} 
		/*
		else if (Subselement.equals("Button1Subs")) {
			//assertTrue(isElementPresent(By.xpath("//h3[text()='" + Subsvalue + "']")),Subsvalue+" "+Subsvalue+" Present ");
			//div[contains(@class,'bg-gray-50') and contains(@class,'rounded-lg')]//a[@href='/dashboard']/button
			WebElement goToDashboardButton1 = wait.until(
			        ExpectedConditions.elementToBeClickable(goToDashboardButton1Path)
			        );

			goToDashboardButton1.click();
			Assert.assertTrue(getUrl().contains("dashboard"), "URL should contain dashboard !");

		}
		else if (Subselement.equals("Button2Hist")) {
			WebElement goToDashboardButton2 = wait.until(
			        ExpectedConditions.elementToBeClickable(goToDashboardButton2Path)
			        );

			goToDashboardButton2.click();
			Assert.assertTrue(getUrl().contains("dashboard"), "URL should contain dashboard !");

		}
		else if (Subselement.equals("ButtonPlans")) {
			WebElement goToPlansButton = wait.until(
			        ExpectedConditions.elementToBeClickable(goToPlansButtonPath)
			        );

			goToPlansButton.click();
			Assert.assertTrue(getUrl().contains("plans"), "URL should contain plans !");
		}
		*/
		else
		{
			return false;
		}
	}

public boolean logWeightPageElement(String weight, String logMessage) {
	System.out.println("Weight Logged :."+String.valueOf(weight));
	wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	WebElement weightInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("weight")));
	weightInput.sendKeys(String.valueOf(weight));

	WebElement logWeightButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Log Weight']")));
	logWeightButton.click();
	
    logger.info("Logging in Her balance application");
    System.out.println("Weight Logged :."+weight);
    return true;
    
    /*
	if (element.equals("Header1")) {
		return isElementPresent(By.xpath("//h1[text()='" + value + "']"));
	}
	else if (element.equals("Paragraph1")) {
		//assertTrue(isElementPresent(By.xpath("//h3[text()='" + Subsvalue + "']")),Subsvalue+" "+Subsvalue+" Present ");
		WebElement loginButtoparaText = driver.findElement(By.xpath("//p[contains(@class,'text-sm') and contains(@class,'text-gray-600') and contains(@class,'capitalize')]"));
		 System.out.println("Paragraph:."+loginButtoparaText.getText());
		 return true;
	} 
	else
	{
		return false;
	}*/
}
	
}
