package com.herBalance.pageObjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SubscriptionSlide26Page {
	
		private By subscriptionOption = By.xpath("//div[@role='menu']//a[@href='/subscription']"); //contains(@class,'items-center') and //div[contains(.,'Subscription'
		private By profileButton = By.xpath("//button[contains(@class,'flex') and contains(@class,'items-center')]" + "[.//span[contains(@class,'font-medium') and contains(@class,'text-[#6A5ACD]')]]");    
		private By gotoDashboardButton1Path = By.xpath("//h3[text()='Subscription Benefits']/ancestor::div[contains(@class,'bg-gray-50')]//button");
		private By gotoDashboardButton2Path = By.xpath("//h3[text()='Subscription History']/ancestor::div[contains(@class,'rounded-lg')]//a[@href='/dashboard']/button");
		private By gotoPlansButtonPath = By.xpath("//div[contains(@class,'rounded-lg')]//a[@href='/plans']/button");
		
		public WebDriver driver;
		WebDriverWait wait;
		
		public SubscriptionSlide26Page(WebDriver driver) {
			this.driver = driver;
			this.wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		}
		
		public void waitForToastsToDisappear() {

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			List<WebElement> closeButtons = driver.findElements(By.xpath("//button[@toast-close]"));
	
			for (WebElement btn : closeButtons) {
			    try {
			        wait.until(ExpectedConditions.elementToBeClickable(btn)).click();
			    } catch (Exception ignored) {}
			}
		}
		
		public boolean isElementPresent(By locator) {
		    return !driver.findElements(locator).isEmpty();
		}

		public void clickProfileButton() {
    			waitForToastsToDisappear();
				wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		    	WebElement userProfileButton = wait.ignoring(StaleElementReferenceException.class).until(ExpectedConditions.elementToBeClickable(profileButton));

		    	Actions actions = new Actions(driver);
		    	actions.moveToElement(userProfileButton).click().perform();

	     	    System.out.println("User menu clicked.");
		}
		
		public void clickSubscriptionOption() {
			wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			WebElement buttonElement = wait.ignoring(StaleElementReferenceException.class).until(ExpectedConditions.elementToBeClickable(subscriptionOption));
			buttonElement.click(); 
		}
		
		public String getTitle() {

			return driver.getTitle();
		}
		
		public String getUrl() {

			return driver.getCurrentUrl();
		}
		
		public boolean seeSubscriptionPageElement(String Subselement, String Subsvalue) {
			
			if (Subselement.equals("Heading1")) {
				return isElementPresent(By.xpath("//h1[text()='" + Subsvalue + "']"));
			}
			else if (Subselement.equals("Heading2")) {
				return isElementPresent(By.xpath("//h3[text()='" + Subsvalue + "']"));
			} 
			else if (Subselement.equals("Paragraph1")) {
				return isElementPresent(By.xpath("//p[text()='" + Subsvalue + "']"));
			}
			else if (Subselement.equals("Heading3")) {
				return isElementPresent(By.xpath("//h3[text()='" + Subsvalue + "']"));
			}
			else if (Subselement.equals("Headerfield1")) {
				return isElementPresent(By.xpath("//div[text()='" + Subsvalue + "']"));
			}
			else if (Subselement.equals("Headerfield2")) {
				return isElementPresent(By.xpath("//div[text()='" + Subsvalue + "']"));
			}
			else if (Subselement.equals("Headerfield3")) {
				return isElementPresent(By.xpath("//div[text()='" + Subsvalue + "']"));
			}
			else if (Subselement.equals("Headerfield4")) {
				return isElementPresent(By.xpath("//div[text()='" + Subsvalue + "']"));
			}
			else if (Subselement.equals("Heading4")) {
				return isElementPresent(By.xpath("//h3[text()='" + Subsvalue + "']"));
			}
			else if (Subselement.equals("Button1Subs")) {
				
				wait = new WebDriverWait(driver, Duration.ofSeconds(10));
				WebElement gotoDashboardButton1Txt = wait.until(ExpectedConditions.elementToBeClickable(gotoDashboardButton1Path));
				return gotoDashboardButton1Txt.isEnabled();
			}
			else if (Subselement.equals("Button2Hist")) {
				WebElement gotoDashboardButton2Txt = wait.until(ExpectedConditions.elementToBeClickable(gotoDashboardButton2Path));
				return gotoDashboardButton2Txt.isEnabled();

			}
			else if (Subselement.equals("ButtonPlans")) {
				WebElement gotoPlansButton = wait.until(ExpectedConditions.elementToBeClickable(gotoPlansButtonPath));
				return gotoPlansButton.isEnabled();
			}
			else if (Subselement.equals("Paragraph2")) {
				return isElementPresent(By.xpath("//p[text()='" + Subsvalue + "']"));
			}
			else if (Subselement.equals("Heading6")) {
				WebElement freePlanHeading = driver.findElement(By.xpath("//h3[text()='Free Plan']"));
				
				return freePlanHeading.isDisplayed();
			}
			else {
				return false;
			}
		}
		
		public boolean gotoDashboardCurrent() {
			WebElement gotoDashboardButton1 = wait.ignoring(StaleElementReferenceException.class).until(ExpectedConditions.elementToBeClickable(gotoDashboardButton1Path));
			gotoDashboardButton1.click();
			return (getUrl().contains("dashboard"));			 
		}
		
		public boolean gotoDashboardHistory() {
			WebElement gotoDashboardButton2 = wait.ignoring(StaleElementReferenceException.class).until(ExpectedConditions.elementToBeClickable(gotoDashboardButton2Path));
			gotoDashboardButton2.click(); 
			return (getUrl().contains("dashboard"));
			 
		}
		
		public boolean viewAllPlans() {
			WebElement gotoPlansButton = wait.until(ExpectedConditions.elementToBeClickable(gotoPlansButtonPath));
			gotoPlansButton.click(); 
			return (getUrl().contains("/plans"));
			 
		}

}

