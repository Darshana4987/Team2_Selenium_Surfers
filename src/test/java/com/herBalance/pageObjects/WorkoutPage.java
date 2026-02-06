package com.herBalance.pageObjects;

import java.time.Duration;
import java.util.List;

import static org.testng.Assert.assertTrue;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class WorkoutPage {
	private static Logger logger = LogManager.getLogger();
	public WebDriver driver;
	WebDriverWait wait;
	
	//private By cycleDayNumberTab = By.xpath("//div[@role='tabpanel' and @data-state='active']//span[starts-with(text(),'Cycle Day')]");
	private By cycleDayNumberTabPath = By.xpath("//div[@role='tablist']//button[@role='tab']");
	private By completeButtonPath = By.xpath("//div[@role='tabpanel' and @data-state='active']//button[.//text()[normalize-space()='Complete'] or .//text()[normalize-space()='Completed']]");
	private By generateWorkoutButtonPath = By.xpath("//button[@data-testid='button-generate-next-workout']");
	private By workoutCompleteXpath = By.xpath("//li[@role='status' and @data-state='open']//div[text()='Workout completed!']");
	private By generateNextWorkoutStatusXpath = By.xpath("//li[@role='status' and @data-state='open']//div[contains(@class,'text-lg')]");
    private By toolTipPath = By.xpath("//li[@data-state='open']//button[@toast-close]");
	
//	@FindBy(xpath=("//button[text()='Generate Workout Plan']"))
//	WebElement generateWorkoutBtn;
	
	public WorkoutPage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
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

	public void loginPage() {

				wait = new WebDriverWait(driver, Duration.ofSeconds(10));
				driver.get("https://herbalance.numpyninja.com");
				
				WebElement emailInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username")));
				emailInput.sendKeys("xyz1234@gmail.com");

				WebElement passwordInput = driver.findElement(By.name("password"));
				passwordInput.sendKeys("xyz1234");
				
				WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit' and text()='LogIn']"));
				loginButton.click();
		        logger.info("Logging in Her balance application");
		        waitForToastsToDisappear();
	}
	
	public boolean clickWorkoutBtn() {
		
		try {
		 WebElement workoutButtton = wait.ignoring(StaleElementReferenceException.class).until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='/workouts']/button")));
		
		 Actions actionsWorkButton = new Actions(driver);
		 actionsWorkButton.moveToElement(workoutButtton).click().perform();		 
		 logger.info("Workout button clicked"); 
		 return true;
		}
		catch (StaleElementReferenceException e) {
		    System.out.println("StaleElementRefrence — handling exception");
		    WebElement workoutButtton = wait.ignoring(StaleElementReferenceException.class).until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='/workouts']/button")));
			
		    Actions actionsWorkButton = new Actions(driver);
			actionsWorkButton.moveToElement(workoutButtton).click().perform();
		    return true;
		} 
	}
	
	public boolean isElementPresent(By locator) {
	    return !driver.findElements(locator).isEmpty();
	}
	
	public String getUrl() {

		return driver.getCurrentUrl();
	}
	
	public boolean checkUrl(String url) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		return wait.until(ExpectedConditions.urlContains(url));
	}
	
	public boolean seepageElement(String element, String value) {
		
		if (element.equals("Header1")) {
			return isElementPresent(By.xpath("//h1[text()='" + value + "']"));
		}
		else if (element.equals("Link")) {
			return isElementPresent(By.xpath("//span[@class='text-sm' and text()='" + value + "']"));
		} 
		
		else if (element.equals("Header2")) {
			return isElementPresent(By.xpath("//h2[text()='" + value + "']"));
		}
		
		else if (element.equals("Paragraph")) {
			return isElementPresent(By.xpath("//h2[text()='Daily Workout Plan']/parent::div/p"));			
		}
		
		else if (element.equals("Header3")) {
			return isElementPresent(By.xpath("//h3[text()='No workout plan found']"));
		}
		else if (element.equals("Button")) {
			return isElementPresent(By.xpath("//button[text()='Generate Workout Plan']"));
		}
		else {
			return false;
		}
	}

	public boolean generateWorkoutPlanBtn() {
		
		//wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		WebElement generateWorkoutButton = wait.ignoring(StaleElementReferenceException.class).until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Generate Workout Plan']")));
		generateWorkoutButton.click();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("loading-spinner")));
		return true;
	}
	
	public boolean verifyCycleDayTabs() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        boolean completeFlag = false;
		List<WebElement> cycleTabs = wait.until(
		    ExpectedConditions.presenceOfAllElementsLocatedBy(cycleDayNumberTabPath));

		for (WebElement tab : cycleTabs) {
		    wait.until(ExpectedConditions.elementToBeClickable(tab)).click();
		    System.out.println(" Tab Name:"+tab.getText());
		    WebElement completeButton = wait.until(ExpectedConditions.presenceOfElementLocated(completeButtonPath));

		   	boolean isEnabled = completeButton.isEnabled();
		   	System.out.println("Complete button enabled: " + isEnabled);
		   	if (isEnabled)
		   	{
		   		completeButton.click(); 
		   		completeFlag=isElementPresent(workoutCompleteXpath);;
		   	}
		}
		
		return completeFlag;

	}
	
	public boolean generateNextWorkout() {

		 wait.until(ExpectedConditions.visibilityOfElementLocated(generateWorkoutButtonPath));
		 WebElement generateNextWorkoutButton = wait.ignoring(StaleElementReferenceException.class).until(ExpectedConditions.elementToBeClickable(generateWorkoutButtonPath));
		 generateNextWorkoutButton.click();
		 WebElement generateNextWorkoutStatus = wait.until(ExpectedConditions.presenceOfElementLocated(generateNextWorkoutStatusXpath));
		 System.out.println("Generate Next Workout Status :" + generateNextWorkoutStatus.getText());
 		 return true;

	}
	
	public boolean verifyGenerateNextWorkout() {
		 WebElement generateNextWorkoutStatus = wait.until(ExpectedConditions.presenceOfElementLocated(generateNextWorkoutStatusXpath));
		 System.out.println("Generate Next Workout Status :" + generateNextWorkoutStatus.getText());
		 return generateNextWorkoutStatus.getText().contains("Success");

	}
	
	public boolean seeSection(String elementTitle, String values) {
		
		if (elementTitle.equals("Header2")) {
			return isElementPresent(By.xpath("//h2[text()='Daily Workout Plan']"));			
		}
		else if (elementTitle.equals("CycleTabs")) {
			List<WebElement> cycleTabs = wait.until(
				    ExpectedConditions.presenceOfAllElementsLocatedBy(cycleDayNumberTabPath));
			
			return (!cycleTabs.isEmpty());
		} 
		else if (elementTitle.equals("Button2")) {
			return isElementPresent(By.xpath("//button[contains(text(),'Complete')]"));
		}
		else if (elementTitle.equals("Button3")) {
			return isElementPresent(By.xpath("//button[contains(text(),'View All Exercises')]"));
		}
		else if (elementTitle.equals("Button4")) {
			return isElementPresent(By.xpath("//button[contains(text(),'Generate Next Work Out')]"));
		}	
		else if (elementTitle.equals("Header4")) {
			return isElementPresent(By.xpath("//h3[text()='About Daily Workouts']"));
		}
		else if (elementTitle.equals("Workput Plan Phase")) {
			return isElementPresent(By.xpath("//span[text()='Phase:']/following-sibling::span"));
		}
		else if (elementTitle.equals("Workput Plan Energy")) {
			return isElementPresent(By.xpath("//span[text()='Energy:']/following-sibling::span"));
		}
		else if (elementTitle.equals("Workput Plan Focus")) {
			return isElementPresent(By.xpath("//span[text()='Focus:']/following-sibling::span"));
		}
		else
		{
			return false;
		}
	
		
	}

}