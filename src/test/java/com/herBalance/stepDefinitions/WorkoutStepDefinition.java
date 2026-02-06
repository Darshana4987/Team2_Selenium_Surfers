package com.herBalance.stepDefinitions;

import org.testng.Assert;
import org.testng.SkipException;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.herBalance.driverFactory.DriverFactory;
import com.herBalance.hooks.Hooks;
import com.herBalance.pageObjects.LoginPageObject;
import com.herBalance.pageObjects.WorkoutPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class WorkoutStepDefinition {
	private static Logger logger = LogManager.getLogger();
	private WorkoutPage workoutPage;
	private LoginPageObject loginPageObject;
	WebDriverWait wait;
	
	public WorkoutStepDefinition() {
		workoutPage = new WorkoutPage(DriverFactory.getDriver());
		loginPageObject = new LoginPageObject(DriverFactory.getDriver());
	}
	
	@Given("User is on login page")
	public void user_is_on_login_page() {
		loginPageObject.getusernamePwd();
		loginPageObject.loginbtn();
		logger.info("Logging in Her balance application");

	}

	@When("The user clicks the Workout button on dashboard")
	public void the_user_clicks_the_workout_button_on_dashboard() {
		//workoutPage.clickWorkoutBtn();
		workoutPage.waitForToastsToDisappear();
		Assert.assertTrue(workoutPage.clickWorkoutBtn(), " Workout Page Opened");
		if (Hooks.scenarioTags.contains("@GeneratePlan")) 
		{
			if (!workoutPage.isElementPresent(By.xpath("//button[text()='Generate Workout Plan']")))
			{
				 throw new SkipException("Skipping scenario: Workout Plan Already Generated!!.");
			 }
		}
	}

	@Then("User should navigate to Workout page")
	public void user_should_navigate_to_workout_page() {
		Assert.assertTrue(workoutPage.getUrl().contains("workouts"), "Failed");
	}

	@Then("User should see page {string} as {string}")
	public void user_should_see_page_element_as(String element, String value) {
		Assert.assertTrue(workoutPage.seepageElement(element, value),value+" "+element+" Present ");

	}

	@Then("User clicks Generate Workout Plan button")
	public void user_clicks_generate_workout_plan_button() {
		Assert.assertTrue(workoutPage.generateWorkoutPlanBtn(),"Workout Plan Generated ! ");
	}

	@Then("User should see the section with {string} as {string}")
	public void user_should_see_the_section_with_as(String elementTitle, String values) {
		Assert.assertTrue(workoutPage.seeSection(elementTitle, values)," "+elementTitle+" "+values+" Present ");
	}
	@Then("The user clicks complete button on each Cycle Day Tabs")
	public void the_user_clicks_complete_button() {
		Assert.assertTrue(workoutPage.verifyCycleDayTabs(),"Complete Button Enabled");
	}

	@Then("Workout phase should be marked as Completed")
	public void workout_phase_should_be_marked_complete() {
		Assert.assertTrue(workoutPage.getUrl().contains("workouts"), "Failed");
	}
    @Then("The user clicks Generate Next Workout button")
    public void the_user_click_generate_next_workput_button() {
		Assert.assertTrue(workoutPage.generateNextWorkout(), "Generate Next Workout Button Clicked ! ");
	}
    
    @Then("Next Workout should be Generated")
    public void next_workout_should_be_generated() {
		Assert.assertTrue(workoutPage.verifyGenerateNextWorkout(), "Next Workout Generated ! ");
	}
    
}
