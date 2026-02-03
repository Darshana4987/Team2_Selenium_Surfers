package com.herBalance.pageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.herBalance.driverFactory.DriverFactory;

public class OnBoardingPageStep6 {
	
	private WebDriver driver;
	WebDriverWait wait;
	
	public OnBoardingPageStep6(WebDriver driver) {
		this.driver = driver;
	}

	
	//delete
	private By healthCondition = By.xpath("//label[normalize-space(.)='Hypothyroidism']"); 
	private By name = By.xpath("//input[@id='name']");
	private By age = By.xpath("//input[@id='age']");
	private By bloodPressureStatus = By.xpath("//div[normalize-space(.)=\"I'm not sure\"]");
	private By menstrualCycleAwarenessOptions = By.xpath("//input[@id='yes']");
	private By btnContinueWithoutReport = By.xpath("//button[text()='Continue Without Report']");

	
	
	
	private By continueBtn = By.xpath("//button[contains(text(),'Continue')]");
	private By backBtn = By.xpath("//button[contains(text(),'Back')]");
	
	private By progressBarCurrentStep = By.xpath("//span[text()='6 of 10']");
	private By errormsg = By.xpath("//p[contains(text(),'Please select your last period start date')]");
	private By inputCalenderControl = By.xpath("//input[@type='date']");
	private By slider = By.xpath("//input[@id='cycle-length']");


	//WebElement slider = driver.findElement(By.xpath(""));
	//slider.sendKeys(Keys.ARROW_RIGHT);
	
//	((JavascriptExecutor)driver)
//	  .executeScript("arguments[0].value='30'; arguments[0].dispatchEvent(new Event('input'));", slider);

	public void clickContunueWithOutReportButton() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(btnContinueWithoutReport))).click();
	}
	public void gotoSignPage() {
		By btnSignUp = By.xpath("//button[text()='Sign Up']");
		driver.findElement(btnSignUp).click();
		System.out.println("/n Sign up Clicked /n ");
	}

	public void clickRgister() {
		By txtUserName = By.xpath("//input[@name='username']");
		By txtPwd = By.xpath("//input[@name='password']");
		By txtConfirmPwd = By.xpath("//input[@name='confirmPassword']");
		By rdoAgree = By.xpath("//button[@id=':r8:-form-item']");
		By btnRegister = By.xpath("//button[text()='Register']");
		String userName = "popopo" + System.currentTimeMillis() + "@gmail.com";
		String password = "popo123";
		driver.findElement(txtUserName).sendKeys(userName);
		driver.findElement(txtPwd).sendKeys(password);
		driver.findElement(txtConfirmPwd).sendKeys(password);
		driver.findElement(rdoAgree).click();
		driver.findElement(btnRegister).click();
		System.out.println("/n registered successfully /n ");
	}
	
	public void clickMenstrualCycleAwarenessOptions() { // delete this method
		
		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(menstrualCycleAwarenessOptions))).click();

	}

	public void clickHealthCondition() { // delete this method
		
		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(healthCondition))).click();

	}
	public void clickBloodPressureStatus() { // delete this method
		
		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(bloodPressureStatus))).click();

	}
	public void enterPersonalDetails() { // delete this method
	
		Actions actions = new Actions(driver);
		actions.moveToElement(driver.findElement(name)).click().sendKeys("abcd").build().perform();
		Actions actions1 = new Actions(driver);
		actions1.moveToElement(driver.findElement(age)).click().sendKeys("35").build().perform();
	}
	
	
	public void clickContinueBtn() {
		
		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(continueBtn))).click();

	}
	public void clickBackBtn() {
		
		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(backBtn))).click();

	}
	public void inputlastMenstrualDate() { 
		
		Actions actions = new Actions(driver);
		actions.moveToElement(driver.findElement(inputCalenderControl)).click().sendKeys("25/01/2026").build().perform();
	}
	
	public void inputInvalid_lastMenstrualDate() { 
		
		Actions actions = new Actions(driver);
		actions.moveToElement(driver.findElement(inputCalenderControl)).click().sendKeys("25/01/2027").build().perform();
	}

	public void moveCycleLengthBar() {
		
		String valueBefore = driver.findElement(slider).getAttribute("value");
		String valueAfter = driver.findElement(slider).getAttribute("value");
		boolean movable = isSliderMovable(driver.findElement(slider));

		if(movable){
		    System.out.println("Slider can be moved!");
		} else {
		    System.out.println("Slider cannot be moved.");
		}
		
		
	}
	public boolean isSliderMovable(WebElement slider) {
	    if (!slider.isEnabled()) {
	        return false; // Slider is disabled
	    }

	    try {
	        Actions action = new Actions(driver);
	        // Move slider by offset (e.g., 10 pixels to the right)
	        action.clickAndHold(slider).moveByOffset(10, 0).release().perform();
	        return true; // Moved successfully
	    } catch (Exception e) {
	        return false; // Could not move
	    }
	}
	
	

	public String getErrorText() {
		
		return driver.findElement(errormsg).getText();
	}
	
	public String getprogressBarCurrentStep() {
		
		return driver.findElement(progressBarCurrentStep).getText();
	}

}
