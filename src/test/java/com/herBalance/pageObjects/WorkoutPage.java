package com.herBalance.pageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class WorkoutPage {
	
	public WebDriver driver;
	WebDriverWait wait;
	
//	@FindBy(xpath=("//button[text()='Generate Workout Plan']"))
//	WebElement generateWorkoutBtn;
	
	public WorkoutPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void clickWorkoutBtn() {
		
		//driver.findElement(WorkoutBtn).click();
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		 WebElement workoutBtn = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@href='/workouts']/button")));
		
		 ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);" , workoutBtn);
		 ((JavascriptExecutor) driver).executeScript("arguments[0].dispatchEvent(new MouseEvent('click',{bubbles:true}));", workoutBtn);
		
	}
	
	public String getUrl() {

		return driver.getCurrentUrl();
	}
	
	public void seepageElement(String element, String value) {
		
		//driver.findElement(element, value);
		if (element.equals("header")) {
			// WebElement header = wait.until(ExpectedConditions.visibilityOfElementLocated(
			// By.xpath("//h1[text()='"+value+"']")));
			WebElement header = driver.findElement(By.xpath("//h1[text()='" + value + "']"));
			System.out.println("Element1:\t" + header.getText());
			// assertTrue(header.isDisplayed());
			Assert.assertEquals(header.getText(), value, "Page Header not matching.");
		}

		if (element.equals("link")) {
			WebElement link = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='text-sm' and text()='" + value + "']")));
			System.out.println("Element2:\t" + link.getText());
			Assert.assertEquals(link.getText(), value, "Text not matching.");
		}
		
		if (element.equals("headerDailyWorkout")) {
			WebElement headerDailyWorkout = driver.findElement(By.xpath("//h2[text()='" + value + "']"));
			
			System.out.println("Element3:\t" + headerDailyWorkout.getText());
			Assert.assertEquals(headerDailyWorkout.getText(), value, "Text not matching.");
		}
		
		if (element.equals("paragraphFreshAI")) {
			WebElement paragraphFreshAI = driver.findElement(By.xpath("//h2[text()='Daily Workout Plan']/parent::div/p"));
			System.out.println("Element4:\t" + paragraphFreshAI.getText());
			Assert.assertEquals(paragraphFreshAI.getText(), value, "Text not matching.");
		}
		
		if (element.equals("noworkoutPlan")) {
			WebElement noworkoutPlan = driver.findElement(By.xpath("//h3[text()='No workout plan found']"));
			System.out.println("Element5:\t" + noworkoutPlan.getText());
			Assert.assertEquals(noworkoutPlan.getText(), value, "Text not matching.");
		}
	}

	public void generateWorkoutPlanBtn() {
		//generateWorkoutBtn.click();
		
		WebElement generateWorkoutBtn = driver.findElement(By.xpath("//button[text()='Generate Workout Plan']"));
		generateWorkoutBtn.click();
			
	}

	public void seeSection(String elementTitle, String values) {
		System.out.println("ElementTitle :\t" + elementTitle);
		if (elementTitle.equals("headerWorkoutPlan")) {
			WebElement headerWorkoutPlan = driver.findElement(By.xpath("//h2[text()='Daily Workout Plan']"));
			System.out.println("ElementTitle1 :\t" + headerWorkoutPlan.getText());
			Assert.assertEquals(headerWorkoutPlan.getText(), values, "Page Header not matching.");
			
		}
		
		if (elementTitle.equals("button")) {
			WebElement button = driver.findElement(By.xpath("//button[@role='tab' and @aria-selected='true']"));
			System.out.println("ElementTitle2 :\t" + button.getText());
			Assert.assertEquals(button.getText(), values, "Button title not matching.");
		}
		
		if (elementTitle.equals("heading")) {
			WebElement heading = driver.findElement(By.xpath("//h3[@class='text-lg font-semibold']"));
			System.out.println("ElementTitle3 :\t" + heading.getText());
			Assert.assertEquals(heading.getText(), values, "Heading title not matching.");
		}
		
		if (elementTitle.equals("completeButton")) {
			WebElement completeButton = driver.findElement(By.xpath("//button[contains(text(),'Complete')]"));
			System.out.println("ElementTitle4 :\t" + completeButton.getText());
			Assert.assertEquals(completeButton.getText(), values, "Button title not matching.");
		}
	
		if (elementTitle.equals("viewallExercises")) {
			WebElement viewallExercises = driver.findElement(By.xpath("//button[contains(text(),'View All Exercises')]"));
			System.out.println("ElementTitle5 :\t" + viewallExercises.getText());
			Assert.assertEquals(viewallExercises.getText(), values, "Button title not matching.");
		}
	
		if (elementTitle.equals("nextWorkoutButton")) {
			WebElement nextWorkoutButton = driver.findElement(By.xpath("//button[contains(text(),'Generate Next Work Out')]"));
			System.out.println("ElementTitle6 :\t" + nextWorkoutButton.getText());
			Assert.assertEquals(nextWorkoutButton.getText(), values, "Button title not matching.");
		}
		
		if (elementTitle.equals("dailyWorkout")) {
			WebElement dailyWorkout = driver.findElement(By.xpath("//h3[text()='About Daily Workouts']"));
			System.out.println("ElementTitle6 :\t" + dailyWorkout.getText());
			Assert.assertEquals(dailyWorkout.getText(), values, "Text not matching.");
		}
			
		
	}
	
}

/*	public void loginPage() {

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
	}*/