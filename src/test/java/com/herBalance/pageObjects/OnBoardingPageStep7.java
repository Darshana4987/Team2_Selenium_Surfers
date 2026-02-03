package com.herBalance.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OnBoardingPageStep7 {
	
	private WebDriver driver;
	WebDriverWait wait;
	
	public OnBoardingPageStep7(WebDriver driver) {
		this.driver = driver;
	}

	private By inputWeight = By.xpath("//input[@id='weight']");
	private By inputHeight = By.xpath("//input[@id='height']");
	private By dropdownKG = By.xpath("//select[option[@value='kg']]");
	private By dropdownLBS = By.xpath("//select[option[@value='lbs']]");
	private By dropdownCM = By.xpath("//input[@id='height']/following-sibling::span");
	private By BMIcalculatorBar = By.xpath("//div[contains(@class,'bg-gradient-to-r')]");
	private By errorMessageWeight = By.xpath("//label[contains(text(),'weight')]");
	private By errorMessageHeight = By.xpath("//label[contains(text(),'height')]");

	
	
	
	
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

	
	

	
	
	

	
}
