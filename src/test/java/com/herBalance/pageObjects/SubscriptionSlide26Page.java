package com.herBalance.pageObjects;

import static org.testng.Assert.assertTrue;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SubscriptionSlide26Page {
	
	//div[@role='menuitem']/a[@href='/subscription']  (//a[@href='/dashboard'])[2]
	//div[@role='menuitem']/a[@href='/subscription']
		private By subscriptionOption = By.xpath("//div[@role='menu']//a[@href='/subscription']"); //contains(@class,'items-center') and //div[contains(.,'Subscription'
		private By profileButton = By.xpath("//button[contains(@class,'flex') and contains(@class,'items-center')]" + "[.//span[contains(@class,'font-medium') and contains(@class,'text-[#6A5ACD]')]]");    
		private By gotoDashboardButton1Path = By.xpath("(//button[text()='Go to Dashboard'])[1]");
		//h3[text()='Subscription Benefits']/ancestor::div[contains(@class,'rounded-lg')]//a[@href='/dashboard']/button
			    //"//div[contains(@class,'bg-gray-50') and contains(@class,'rounded-lg')]//a[@href='/dashboard']/button"
			
		private By gotoDashboardButton2Path = By.xpath("//h3[text()='Subscription History']/ancestor::div[contains(@class,'rounded-lg')]//a[@href='/dashboard']/button");
		private By gotoPlansButtonPath = By.xpath("//div[contains(@class,'rounded-lg')]//a[@href='/plans']/button");
	//	private By headingSubsManagement = By.xpath("//h1[@class='text-2xl font-bold text-gray-800 mb-6']");
		
		public WebDriver driver;
		WebDriverWait wait;
		
		public SubscriptionSlide26Page(WebDriver driver) {
			this.driver = driver;
			this.wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		}
		
		public boolean isElementPresent(By locator) {
		    return !driver.findElements(locator).isEmpty();
		    //returns true if xpath is not empty, element is present
		}

		public void clickProfileButton() {
				wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		    	WebElement userProfileButton = wait.until(ExpectedConditions.elementToBeClickable(profileButton));

		    	Actions actions = new Actions(driver);
		    	actions.moveToElement(userProfileButton).click().perform();

	     	    System.out.println("User menu clicked.");
		}
		
		public void clickSubscriptionOption() {
			wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			WebElement buttonElement = wait.until(ExpectedConditions.elementToBeClickable(subscriptionOption));
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
			else if (Subselement.equals("Paragraph1")) {
				assertTrue(isElementPresent(By.xpath("//p[text()='" + Subsvalue + "']")),Subsvalue+" "+Subsvalue+" Present ");
			}
			//h3[text()='Subscription Information']
			else if (Subselement.equals("Heading3")) {
				assertTrue(isElementPresent(By.xpath("//h3[text()='" + Subsvalue + "']")),Subsvalue+" "+Subsvalue+" Present ");
			}
			else if (Subselement.equals("Headerfield1")) {
				assertTrue(isElementPresent(By.xpath("//div[text()='" + Subsvalue + "']")),Subsvalue+" "+Subsvalue+" Present ");
				//div[text()='Status:
			}
			else if (Subselement.equals("Headerfield2")) {
				assertTrue(isElementPresent(By.xpath("//div[text()='" + Subsvalue + "']")),Subsvalue+" "+Subsvalue+" Present ");
			}
			else if (Subselement.equals("Headerfield3")) {
				assertTrue(isElementPresent(By.xpath("//div[text()='" + Subsvalue + "']")),Subsvalue+" "+Subsvalue+" Present ");
			}
			else if (Subselement.equals("Headerfield4")) {
				assertTrue(isElementPresent(By.xpath("//div[text()='" + Subsvalue + "']")),Subsvalue+" "+Subsvalue+" Present ");
			}
			else if (Subselement.equals("Heading4")) {
				assertTrue(isElementPresent(By.xpath("//h3[text()='" + Subsvalue + "']")),Subsvalue+" "+Subsvalue+" Present ");
			}
			else if (Subselement.equals("Button1Subs")) {
			/*	// Proceed with the click
				    By toastLocator = By.cssSelector("li[role='status']");
				// Wait until any active toast messages are gone
				    wait.until(ExpectedConditions.invisibilityOfElementLocated(toastLocator));*/
					
				wait = new WebDriverWait(driver, Duration.ofSeconds(10));
				WebElement gotoDashboardButton1 = wait.until(ExpectedConditions.elementToBeClickable(gotoDashboardButton1Path));

				gotoDashboardButton1.click();
				assertTrue(getUrl().contains("dashboard"), "URL should contain dashboard !");

			}
			else if (Subselement.equals("Button2Hist")) {
				WebElement gotoDashboardButton2 = wait.until(ExpectedConditions.elementToBeClickable(gotoDashboardButton2Path));

				gotoDashboardButton2.click();
				assertTrue(getUrl().contains("dashboard"), "URL should contain dashboard !");

			}
			else if (Subselement.equals("ButtonPlans")) {
				WebElement gotoPlansButton = wait.until(ExpectedConditions.elementToBeClickable(gotoPlansButtonPath));
	
				gotoPlansButton.click();
				assertTrue(getUrl().contains("plans"), "URL should contain plans !");
			}
		}

}
/*	//Login
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
}//Login Ends */
