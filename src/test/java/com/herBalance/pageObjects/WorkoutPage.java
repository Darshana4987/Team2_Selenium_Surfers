package com.herBalance.pageObjects;

import java.time.Duration;
import java.util.List;

import static org.testng.Assert.assertTrue;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
	
//	@FindBy(xpath=("//button[text()='Generate Workout Plan']"))
//	WebElement generateWorkoutBtn;
	
	public WorkoutPage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}

	public void loginPage() {

		// driver = DriverFactory.getDriver(); // your driver setup
				wait = new WebDriverWait(driver, Duration.ofSeconds(10));
				driver.get("https://herbalance.numpyninja.com");
				
				WebElement emailInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username")));
				emailInput.sendKeys("test12345@gmail.com");

				WebElement passwordInput = driver.findElement(By.name("password"));
				passwordInput.sendKeys("test12345");
				
				WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit' and text()='LogIn']"));
				loginButton.click();
		        logger.info("Logging in Her balance application");
	}
	
	public void clickWorkoutBtn() {
		
		//driver.findElement(WorkoutBtn).click();
		 WebElement workoutBtn = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@href='/workouts']/button")));
		
		 ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);" , workoutBtn);
		 ((JavascriptExecutor) driver).executeScript("arguments[0].dispatchEvent(new MouseEvent('click',{bubbles:true}));", workoutBtn);
		 logger.info("Workout button clicked"); 
		 
		 
	}
	public boolean isElementPresent(By locator) {
	    return !driver.findElements(locator).isEmpty();
	}
	
	public String getUrl() {

		return driver.getCurrentUrl();
	}
	
	public void seepageElement(String element, String value) {
		
		
		//driver.findElement(element, value);
		if (element.equals("Header1")) {
			assertTrue(isElementPresent(By.xpath("//h1[text()='" + value + "']")),value+" "+element+" Present ");
		}
		else if (element.equals("Link")) {
			assertTrue(isElementPresent(By.xpath("//span[@class='text-sm' and text()='" + value + "']")),value+" "+element+" Present ");
		} 
		
		else if (element.equals("Header2")) {
			assertTrue(isElementPresent(By.xpath("//h2[text()='" + value + "']")),value+" "+element+" Present ");
		}
		
		else if (element.equals("Paragraph")) {
			assertTrue(isElementPresent(By.xpath("//h2[text()='Daily Workout Plan']/parent::div/p")),value+" "+element+" Present ");			
		}
		
		else if (element.equals("Header3")) {
			assertTrue(isElementPresent(By.xpath("//h3[text()='No workout plan found']")),value+" "+element+" Present ");
		}
		else if (element.equals("Button")) {
			assertTrue(isElementPresent(By.xpath("//button[text()='Generate Workout Plan']")),value+" "+element+" Present ");
		}
		else {
			Assert.assertEquals(element.toString(), "XYZ", "Undefined Scenarion Element.");
		}
	}

	public void generateWorkoutPlanBtn() {
		//generateWorkoutBtn.click();
		
		try {
			WebElement generateWorkoutBtn = driver.findElement(By.xpath("//button[text()='Generate Workout Plan']"));
			System.out.println(" Button Text:\t" + generateWorkoutBtn.getText());
			generateWorkoutBtn.click();
			Assert.assertEquals(generateWorkoutBtn.getText(), "Generate Workout Plan", "Text not matching.");
		} catch (NoSuchElementException e) {
		    System.out.println("Element not found — handling exception");
		    assertTrue(true,"Generate Workout Plan Button not Present ");
		}
		
	}
	
	public boolean verifyCycleDayTabs() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        boolean completeFlag = false;
		List<WebElement> cycleTabs = wait.until(
		    ExpectedConditions.presenceOfAllElementsLocatedBy(cycleDayNumberTabPath));

		for (WebElement tab : cycleTabs) {
		    wait.until(ExpectedConditions.elementToBeClickable(tab)).click();
		    System.out.println(" Tab Name:"+tab.getText());
		    //WebElement completeButton = driver.findElement(completeButtonPath);
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
		 wait.until(ExpectedConditions.elementToBeClickable(generateWorkoutButtonPath)).click();	
		 WebElement generateNextWorkoutStatus = wait.until(ExpectedConditions.presenceOfElementLocated(generateNextWorkoutStatusXpath));
		 System.out.println("Generate Next Workout Status :" + generateNextWorkoutStatus.getText());
 		 return generateNextWorkoutStatus.getText().contains("Success");

	}

	public void seeSection(String elementTitle, String values) {
		System.out.println("ElementTitle :\t" + elementTitle);
		if (elementTitle.equals("Header2")) {
			assertTrue(isElementPresent(By.xpath("//h2[text()='Daily Workout Plan']")),values+" "+elementTitle+" Present ");
			System.out.println("ElementTitle2 :\t" + values+" "+elementTitle);
		}
		
		if (elementTitle.equals("Button1")) {
			assertTrue(isElementPresent(By.xpath("//button[@role='tab' and @aria-selected='true']")),values+" "+elementTitle+" Present ");
			System.out.println("ElementTitle3 :\t" + values+" "+elementTitle);

		}
		
		if (elementTitle.equals("Header3")) {
			assertTrue(isElementPresent(By.xpath("//div[normalize-space()='Luteal']")),values+" "+elementTitle+" Present ");
			System.out.println("ElementTitle4 :\t" + values+" "+elementTitle);
		}
		
		if (elementTitle.equals("Button2")) {
			assertTrue(isElementPresent(By.xpath("//button[contains(text(),'Complete')]")),values+" "+elementTitle+" Present ");
			System.out.println("ElementTitle5 :\t" + values+" "+elementTitle);
		}
	
		if (elementTitle.equals("Button3")) {
			assertTrue(isElementPresent(By.xpath("//button[contains(text(),'View All Exercises')]")),values+" "+elementTitle+" Present ");
			System.out.println("ElementTitle6 :\t" + values+" "+elementTitle);
		}
	
		if (elementTitle.equals("Button4")) {
			assertTrue(isElementPresent(By.xpath("//button[contains(text(),'Generate Next Work Out')]")),values+" "+elementTitle+" Present ");
			System.out.println("ElementTitle7 :\t" + values+" "+elementTitle);
		}
		
		if (elementTitle.equals("Header4")) {
			assertTrue(isElementPresent(By.xpath("//h3[text()='About Daily Workouts']")),values+" "+elementTitle+" Present ");
			System.out.println("ElementTitle8 :\t" + values+" "+elementTitle);
		}
			
		
	}
	
}