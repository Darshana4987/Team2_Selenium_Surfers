package com.herBalance.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.herBalance.utils.ConfigReader;

public class LaunchPage {
	
	public WebDriver driver;
	WebDriverWait wait;
	
	private By Empowertext = By.xpath("//div[@id='root']/div/section/div/div/p[contains(text(),'Hormonal')]");
	private By Images = By.xpath("//div[@id='root']/div/section/div/div/div/div/img");
	private By StartJourneyBtn = By.xpath("//button[contains(text(),'Start Your')]");
	private By GetStartedBtn = By.xpath("//button[contains(text(),'Get Started')]");
	private By LoginBtn = By.xpath("//button[contains(text(),'Log')]");
	private By SignupBtn = By.xpath("//button[contains(text(),'Sign')]");
	private By CycleTrackAppsection = By.xpath("//div[@class='bg-white rounded-xl shadow-lg p-6']");
	private By CyclePhases = By.xpath("//div[@class='grid grid-cols-1 md:grid-cols-4 gap-6 mb-12']");
	private By Signuppage = By.xpath("//button[contains(text(),'Sign')]");
	private By LoginPage = By.xpath("//button[contains(text(),'Login')]");
	private By Backgroundcolor = By.xpath("//section[contains(@class,'from-[#E6E6FA]')]");
	
	
	public LaunchPage(WebDriver driver) {
		this.driver = driver;
	}

	public void getUrl() {

		// driver = DriverFactory.getDriver(); // your driver setup
				//wait = new WebDriverWait(driver, Duration.ofSeconds(10));
				driver.get(ConfigReader.getLaunchUrl());
				
	}
		
	   public void clickLoginBtn()
	    {
	        driver.findElement(LoginBtn).click();
	    }
	   
	   public void clickSignupBtn()
	   {
		   driver.findElement(SignupBtn).click();
	   }
	   public void StartYourJourneyBtn()
	   {
		   driver.findElement(StartJourneyBtn).click();
	   }
	   public void GetStartedBtn()
	   {
		   driver.findElement(GetStartedBtn).click();
	   }
	   	
	   public String Empowertitledisplayed() 
	   {
		   return driver.findElement(Empowertext).getText();
	   }
	   
	   public String Imagedisplayed()
	   {
		   return driver.findElement(Images).getText();
	   }
	   
	   public String CycleTrackApp()
	   {
		   return driver.findElement(CycleTrackAppsection).getText();
	   }
	   
	   public String CyclePhases()
	   {
		   return driver.findElement(CyclePhases).getText();
	   }
	   public String Siguppagedisplayed()
	   {
		   return driver.findElement(Signuppage).getText();
	   }
	   public String Loginpagedisplayed() {
		   return driver.findElement(LoginPage).getText();
	   }
	   
	   public String displayLoginBtn()
	    {
	        return driver.findElement(LoginBtn).getText();
	    }
	   
	   public String displaySignupBtn()
	   {
		   return driver.findElement(SignupBtn).getText();
	   }
	   public String displayStartYourJourneyBtn()
	   {
		   return driver.findElement(StartJourneyBtn).getText();
	   }
	   public String displayGetStartedBtn()
	   {
		   return driver.findElement(GetStartedBtn).getText();
	   }
	   
	   public boolean backgroundcolorandtext() {
	        WebElement section = driver.findElement(Backgroundcolor);
	        String bgImage = section.getCssValue("background-image");
	        return bgImage.contains("230, 230, 250"); 
	    }

	  
	    public boolean ReadableText() {
	        WebElement section = driver.findElement(Backgroundcolor);
	        WebElement text =
	                section.findElement(By.xpath(".//h1 | .//h2 | .//p"));
	        return text.isDisplayed();
	    }
	   
}
