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

public class SubscriptionSlide26Page {
	
	//div[@role='menuitem']/a[@href='/subscription']
	private By subscriptionOption = By.xpath("//div[@role='menu']//a[@href='/subscription']"); //contains(@class,'items-center') and //div[contains(.,'Subscription'
	private By profileButton = By.xpath("//button[contains(@class,'flex') and contains(@class,'items-center')]" +
    	                            "[.//span[contains(@class,'font-medium') and contains(@class,'text-[#6A5ACD]')]]"
    	);
	
	
	private static Logger logger = LogManager.getLogger();
	public WebDriver driver;
	WebDriverWait wait;
	
	public SubscriptionSlide26Page(WebDriver driver) {
		this.driver = driver;
	}
	
	public boolean isElementPresent(By locator) {
	    return !driver.findElements(locator).isEmpty();
	    //returns true if xpath is not empty, element is present
	}
	//Login
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
	
	public void clickProfileButton() {
	    wait = new WebDriverWait(driver, Duration.ofSeconds(15));

	    	WebElement userProfileButton = wait.until(ExpectedConditions.elementToBeClickable(profileButton));

	    	Actions buttonAction = new Actions(driver);
	    	buttonAction.moveToElement(userProfileButton).click().perform();

     	    System.out.println("User menu clicked.");
	}
	
	public void clickSubscriptionOption() {
		//wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement buttonElement = wait.until(
		        ExpectedConditions.elementToBeClickable(subscriptionOption)
		);
		buttonElement.click();
	//	driver.findElement(subscriptionOption).click();
		 
	}
	
	public String getTitle() {

		return driver.getTitle();
	}
	
	public String getUrl() {

		return driver.getCurrentUrl();
	}
	
	public void seeSubscriptionPageElement(String Subselement, String Subsvalue) {
		
		if (Subselement.equals("Heading1")) {
			assertTrue(isElementPresent(By.xpath("//h1[text()='" + Subsvalue + "']")),Subsvalue+" "+Subselement+" Present ");
		}
		else if (Subselement.equals("Heading2")) {
			assertTrue(isElementPresent(By.xpath("//h3[text()='" + Subsvalue + "']")),Subsvalue+" "+Subsvalue+" Present ");
		} 
	}
	
}
