package com.herBalance.pageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OnBoardingPageStep7 {
	
	private WebDriver driver;
	WebDriverWait wait;
	
	public OnBoardingPageStep7(WebDriver driver) {
		this.driver = driver;
	}

	private By inputWeight = By.xpath("//input[@id='weight']");
	private By inputHeight = By.xpath("//input[@id='height']");
	private By dropdownKG = By.xpath("//option[@value='kg']");
	private By dropdownLBS = By.xpath("//option[@value='lbs']");
	private By weightUnitDropdown = By.xpath("//select[option[@value='kg'] and option[@value='lbs']]");
	private By dropdownCM = By.xpath("//input[@id='height']/following-sibling::span");
	private By BMIcalculatorBar = By.xpath("//div[contains(@class,'bg-gradient-to-r')]");
	private By errorMessageWeight = By.xpath("//p[contains(text(),'Weight')]");
	private By errorMessageHeight = By.xpath("//p[contains(text(),'Height')]");
	private By errorMessage_InvalidWeight = By.xpath("//p[contains(text(),'valid weight')]");
	private By errorMessage_InvalidHeight = By.xpath("//p[contains(text(),'valid height')]");

	public void enterEmptyWeight() {
		
		Actions actions = new Actions(driver);
		actions.moveToElement(driver.findElement(inputWeight)).click().sendKeys("").build().perform();
	}
	public void enterEmptyHeight() {
		
		Actions actions = new Actions(driver);
		actions.moveToElement(driver.findElement(inputHeight)).click().sendKeys("").build().perform();
	}
	
	public void enterWeight() {
		
		Actions actions = new Actions(driver);
		actions.moveToElement(driver.findElement(inputWeight)).click().sendKeys("60").build().perform();
	}
	public void enterHeight() {
		
		Actions actions = new Actions(driver);
		actions.moveToElement(driver.findElement(inputHeight)).click().sendKeys("154").build().perform();
	}
	
	
	public void enterInvalidWeight() {
		
		Actions actions = new Actions(driver);
		actions.moveToElement(driver.findElement(inputWeight)).click().sendKeys("6088888888").build().perform();
	}
	public void enterInvalidHeight() {
		
		Actions actions = new Actions(driver);
		actions.moveToElement(driver.findElement(inputHeight)).click().sendKeys("154888888888").build().perform();
	}
	
	
	public String getErrorText_EmptyWeight() {
		
		return driver.findElement(errorMessageWeight).getText();
	}
	public String getErrorText_EmptyHeight() {
		
		return driver.findElement(errorMessageHeight).getText();
	}
	
	
	public String getErrorText_InvalidWeight() {
		
		return driver.findElement(errorMessage_InvalidWeight).getText();
	}
	public String getErrorText_InvalidHeight() {
		
		return driver.findElement(errorMessage_InvalidHeight).getText();
	}
	
	
	
	public boolean isKGUnit_Visible() {
		
		return driver.findElement(dropdownKG).isDisplayed();
		
	}
	public boolean isLBSUnit_Visible() {
		
		return driver.findElement(dropdownLBS).isDisplayed();
		
	}
	
	public String getText_KGUnit() {
		
		return driver.findElement(dropdownKG).getText();
	}
	public String getText_LBSUnit() {
		
		return driver.findElement(dropdownLBS).getText();
	}

	
	public boolean isCMunit_Visible() {
		
		return driver.findElement(dropdownCM).isDisplayed();
		
	}
	public String getText_CMunit() {
		
		return driver.findElement(dropdownCM).getText();
	}
	
	public boolean isBMI_BarVisible() {
		
		return driver.findElement(BMIcalculatorBar).isDisplayed();
		
	}

	public int RedirectToNextStep() {
		
		String text = wait.until(
			    ExpectedConditions.visibilityOfElementLocated(
			        By.xpath("//span[contains(text(),'of 10')]"))).getText();

			 int currentStep = Integer.parseInt(text.split(" ")[0]);
			 
			 return currentStep;

		
		
	}
	
	
	

	
	
	

	
}
