package com.herBalance.stepDefinition;

import io.cucumber.java.en.*;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

import static org.testng.Assert.assertTrue;

import java.time.Duration;

//import static org.junit.Assert.assertTrue;
import org.testng.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.herBalance.driverFactory.DriverFactory;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class WorkoutStepDefinition {
	
	 // WebDriver driver;
	  WebDriverWait wait;
	  
	  WebDriver driver = DriverFactory.getDriver();
	
	@Given("User is on login page")
	public void user_is_on_login_page() {

	}

	
	@Given("User logged in to Her balance application and is on dashboard")
	public void user_logged_in_to_her_balance_application_and_is_on_dashboard() {
	
		driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}

	@When("The user clicks the Workout button on dashboard")
	public void the_user_clicks_the_workout_button_on_dashboard() {
		//driver = DriverFactory.getDriver();


        WebElement workoutBtn = wait.until(
        	    ExpectedConditions.presenceOfElementLocated(
        	        By.xpath("//a[@href='/workouts']/button")));

        	//workoutBtn.click(); 
    /*    	
		 WebElement workoutSpan = wait.until(
		            ExpectedConditions.presenceOfElementLocated(
		                By.xpath("//span[normalize-space()='Workout']")));
	        //workoutMenu.click();
	        ///
	        */
		 ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);"
				 , workoutBtn);
		 ((JavascriptExecutor) driver).executeScript("arguments[0].dispatchEvent(new MouseEvent('click',{bubbles: true}));"
				 , workoutBtn);  
				 
	    }
	
	@Then("User should navigate to Workout page")
	public void user_should_navigate_to_workout_page() {
		/* boolean isDashboardVisible = wait.until(
	                ExpectedConditions.urlContains("/workouts"));*/
		
		//Assert.assertEquals(driver.getCurrentUrl(), "workouts");
		Assert.assertTrue(driver.getCurrentUrl().contains("workouts"), "Failed");
	 }
	

	@Then("User should see page {string} as {string}")
	public void user_should_see_page_title_as(String element, String value) {
		// System.out.println("Element :"+element);
		if(element.equals("header")) {
			//WebElement header = wait.until(ExpectedConditions.visibilityOfElementLocated(
	         //       By.xpath("//h1[text()='"+value+"']")));
			WebElement header =driver.findElement(By.xpath("//h1[text()='"+value+"']"));
            System.out.println("Element:\t"+header.getText());
            //assertTrue(header.isDisplayed());
            Assert.assertEquals(header.getText(),value,"Page Header not matching.");
		}	
		
		if(element.equals("link")) {
			WebElement link = wait.until(ExpectedConditions.visibilityOfElementLocated(
	                By.xpath("//span[@class='text-sm' and text()='"+value+"']")));
			 System.out.println("Element 1:\t"+link.getText());
			assertTrue(link.isDisplayed());
		}
		
			
	}

/*	@Then("User should see the link Back to dashboard")
	public void user_should_see_the_link_back_to_dashboard() {
	   
	}

	@Then("User should see the Daily Workout Plan section")
	public void user_should_see_the_daily_workout_plan_section() {
	    
	}

	@Then("User should see the description as {string}")
	public void user_should_see_the_description_as(String string) {
	 
	}

*/
}

