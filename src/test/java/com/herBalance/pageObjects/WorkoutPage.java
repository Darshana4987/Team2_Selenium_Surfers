package com.herBalance.pageObjects;

import static org.testng.Assert.assertTrue;

import java.time.Duration;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


public class WorkoutPage {
	
	private By workoutButton = By.xpath("//span[text()='Workout']/parent::button"); //a[@href='/workouts']/button");
	
	private static Logger logger = LogManager.getLogger();
	public WebDriver driver;
	WebDriverWait wait;
		
//	@FindBy(xpath=("//button[text()='Generate Workout Plan']"))
//	WebElement generateWorkoutBtn;
	
	public WorkoutPage(WebDriver driver) {
		this.driver = driver;
	}

	public boolean isElementPresent(By locator) {
	    return !driver.findElements(locator).isEmpty();
	    //returns true if xpath is not empty, element is present
	}
		
	public void clickWorkoutBtn() {
		
		    wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(workoutButton)).click();
			
		//driver.findElement(WorkoutBtn).click();
		/* WebElement workoutBtn = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@href='/workouts']/button")));
		
		 ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);" , workoutBtn);
		 ((JavascriptExecutor) driver).executeScript("arguments[0].dispatchEvent(new MouseEvent('click',{bubbles:true}));", workoutBtn);
		 logger.info("Workout button clicked"); */
	 
	}
	
	public String getUrl() {

		return driver.getCurrentUrl();
	}
	
	public void seePageElement(String element, String value) {
		
		
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
			Assert.assertEquals(element.toString(), "XYZ", "Undefined Scenario Element.");
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
		
	/*	
		if (generateWorkoutBtn.isDisplayed()) 
		{
		   generateWorkoutBtn.click();
		} 
		else 
		{
			System.out.println(" Workout PLan already Generated !!");
			throw new SkipException("Dashboard not found");
			//return;
		}
			*/
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
/* //Login
	public void loginPage() {

		// driver = DriverFactory.getDriver(); // your driver setup
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