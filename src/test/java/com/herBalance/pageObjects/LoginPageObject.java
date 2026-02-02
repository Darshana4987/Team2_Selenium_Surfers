package com.herBalance.pageObjects;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

import com.herBalance.utils.ConfigReader;

public class LoginPageObject {
	
	public WebDriver driver;
	WebDriverWait wait;
	private static Logger logger = LogManager.getLogger();

	public LoginPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void geturll() {

		// driver = DriverFactory.getDriver(); // your driver setup
				wait = new WebDriverWait(driver, Duration.ofSeconds(10));
				driver.get(ConfigReader.getUrl());
				
	}
	
	public void getusernamePwd()
	{
	WebElement emailInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username")));
	emailInput.sendKeys(ConfigReader.getUsername());
	WebElement passwordInput = driver.findElement(By.name("password"));
	passwordInput.sendKeys(ConfigReader.getPassword());
	}
	
	public void loginbtn()
	{
		WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit' and text()='LogIn']"));
		loginButton.click();
	    logger.info("Logging in Her balance application");
	    
	}

	public boolean isDashboardLoaded() {
	    wait.until(ExpectedConditions.visibilityOfElementLocated(
	        By.xpath("//h1[contains(text(),'Dashboard')]")
	    ));
	    return driver.getCurrentUrl().contains("/dashboard");
	}
}