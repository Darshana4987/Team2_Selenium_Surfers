package com.herBalance.stepDefinitions;


import org.testng.Assert;

import com.herBalance.driverFactory.DriverFactory;
import com.herBalance.pageObjects.MenstrualPhaseLogPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MenstrualPhaseLogStepDef {
	private MenstrualPhaseLogPage menstrualPhaseLogPage;
	
	private MenstrualPhaseLogStepDef() {
		menstrualPhaseLogPage = new MenstrualPhaseLogPage(DriverFactory.getDriver());
	}
	
	@Given("User is logged in to Herbalance app")
	public void user_is_logged_in_to_herbalance_app() {
	    
	}

	@Given("User is on the Her Balance Dashboard with the Activity Insights submenu expanded")
	public void user_is_on_the_her_balance_dashboard_with_the_activity_insights_submenu_expanded() {
		menstrualPhaseLogPage.clickActivityInsights();
	}

	@When("User clicks on Menstrual Phase Logs")
	public void user_clicks_on_menstrual_phase_logs() {
		menstrualPhaseLogPage.clickMenstrualPhaseLogs();
	}

	@Then("User should be able to see all five sections")
	public void user_should_be_able_to_see_all_five_sections() {
	    Assert.assertTrue(menstrualPhaseLogPage.getCurrentCycleStatus().isDisplayed(), "Current Cycle status section not visible");
	    Assert.assertTrue(menstrualPhaseLogPage.getUpcomingPhasesSection().isDisplayed(), "Upcoming Phases section not visible");
	    Assert.assertTrue(menstrualPhaseLogPage.getRecommendedActivitiesSection().isDisplayed(), "Recommended Activities section not visible");
	    Assert.assertTrue(menstrualPhaseLogPage.getNutritionTipsSection().isDisplayed(), "Nutrition tips section not visible");
	}

	@Then("User should be able to see {string} button in the Menstrual Phase Log page")
	public void user_should_be_able_to_see_button_in_the_menstrual_phase_log_page(String string) {
	    
	}
	
	@Then("User should be able to see {string} tab in the Menstrual Phase Log Page")
	public void user_should_be_able_to_see_tab_in_the_menstrual_phase_log_page(String string) {
	    
	}

	@Then("User should be able to see {string} section heading")
	public void user_should_be_able_to_see_section_heading(String string) {
	    
	}

	@Then("Current cycle progress should be displayed in the correct format")
	public void current_cycle_progress_should_be_displayed_in_the_correct_format() {
	    
	}

	@Then("User should be able to see all labels below progress bar")
	public void user_should_be_able_to_see_all_labels_below_progress_bar() {
	    
	}

	@Then("progress bar should be filled according to the current cycle progress")
	public void progress_bar_should_be_filled_according_to_the_current_cycle_progress() {
	    
	}

	@Then("User should be able to see all labels in Current Cycle Status section")
	public void user_should_be_able_to_see_all_labels_in_current_cycle_status_section() {
	    
	}

	@Then("The phase based on the value entered during onboarding process should be displayed")
	public void the_phase_based_on_the_value_entered_during_onboarding_process_should_be_displayed() {
	    
	}

	@Then("Last period started date should be based on the date entered during onboarding process")
	public void last_period_started_date_should_be_based_on_the_date_entered_during_onboarding_process() {
	    
	}

	@Then("Next period expected date should be based on the date entered during onboarding process")
	public void next_period_expected_date_should_be_based_on_the_date_entered_during_onboarding_process() {
	    
	}

	@Then("Subsection heading reflects the Current Phase in the correct format")
	public void subsection_heading_reflects_the_current_phase_in_the_correct_format() {
	    
	}

	@Then("Display content should match current phase")
	public void display_content_should_match_current_phase() {
	    
	}




}
