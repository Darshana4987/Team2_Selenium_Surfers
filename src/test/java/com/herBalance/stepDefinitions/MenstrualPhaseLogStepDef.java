package com.herBalance.stepDefinitions;


import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.herBalance.driverFactory.DriverFactory;
import com.herBalance.pageObjects.LoginPageObject;
import com.herBalance.pageObjects.MenstrualPhaseLogPage;
import com.herBalance.utils.ExcelReader;
import com.herBalance.utils.Helper;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MenstrualPhaseLogStepDef {
	private static Logger logger = LogManager.getLogger();
	private MenstrualPhaseLogPage menstrualPhaseLogPage;
	private LoginPageObject loginPageObject;
	private static String expectedPhase;
	
	public MenstrualPhaseLogStepDef() {
		menstrualPhaseLogPage = new MenstrualPhaseLogPage(DriverFactory.getDriver());
		loginPageObject = new LoginPageObject(DriverFactory.getDriver());
	}
	
	@Given("User is logged in to Herbalance app")
	public void user_is_logged_in_to_herbalance_app() {
		loginPageObject.getusernamePwd();
		loginPageObject.loginbtn();
		logger.info("Logging in Her balance application");
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
	    Assert.assertTrue(menstrualPhaseLogPage.getNextPeriodSection().isDisplayed(), "Next Period section not visible");
	}

	@Then("User should be able to see {string} button in the Menstrual Phase Log page")
	public void user_should_be_able_to_see_button_in_the_menstrual_phase_log_page(String text) {
	    Assert.assertTrue(menstrualPhaseLogPage.getMenstrualCycleTrackerButton(text).isDisplayed(), "Menstrual Cycle Tracker buttons not displayed");
	}
	
	@Then("User should be able to see Back To DashBoard link")
	public void user_should_be_able_to_see_back_to_dash_board_link() {
		Assert.assertTrue(menstrualPhaseLogPage.getBackToDashboard().isDisplayed(), "Back to Dashbaord link not available");
	}

	@Then("User should be able to see {string} tab in the Menstrual Phase Log Page")
	public void user_should_be_able_to_see_tab_in_the_menstrual_phase_log_page(String text) {
	    Assert.assertTrue(menstrualPhaseLogPage.getMenstrualCycleTrackerTab(text).isDisplayed(), "Menstrual Cycle Tracker tabs not visible");
	}

	@Then("User should be able to see {string} section heading")
	public void user_should_be_able_to_see_section_heading(String section) {
	    Assert.assertTrue(menstrualPhaseLogPage.getSectionHeading(section).isDisplayed(), "Section heading not displayed");
	}

	@Then("Current cycle progress should be displayed in the correct format")
	public void current_cycle_progress_should_be_displayed_in_the_correct_format() throws IOException {
	    String cycleProgress = menstrualPhaseLogPage.getCurrentCycleProgress();
	    logger.info("Cycle Progress : " + cycleProgress);
	    String[] words = cycleProgress.split(" ");
	    
	    int cycleDay = Helper.calculateCycleDay();
	    Assert.assertEquals(words[1], Integer.toString(cycleDay), "cycle progress not matching with onboarding data");
	    
	    String cycleLength = words[4].replaceAll("\\D+", "");
	    logger.info("Cycle length : " + cycleLength);
	    Assert.assertEquals(cycleLength, Helper.cycleLengthFromTestData(), "Cycle length not matched with onboarding data");
	}

	@Then("User should be able to see all labels {string} below progress bar")
	public void user_should_be_able_to_see_all_labels_below_progress_bar(String labelName) {
	    Assert.assertTrue(menstrualPhaseLogPage.getPhaseLabels(labelName).isDisplayed(), "Phase label " + labelName + " not displayed");
	}

	@Then("progress bar should be filled according to the current cycle progress")
	public void progress_bar_should_be_filled_according_to_the_current_cycle_progress() throws IOException {
		WebElement progressBar = menstrualPhaseLogPage.getMenstrualProgressBar();
		String style = progressBar.getAttribute("style");
		Double percentage = Double.parseDouble(style.replaceAll("[^0-9.]", ""));
		String barProgress = String.format("%.4f", 100 - percentage);
		Assert.assertEquals(barProgress, Helper.calculateCycleProgress(), "cycle Progress not matched with onboarding data");
	}

	@Then("User should be able to see all labels {string} in Current Cycle Status section")
	public void user_should_be_able_to_see_all_labels_in_current_cycle_status_section(String labelName)  {
		WebElement labelElem = menstrualPhaseLogPage.getCycleStatusLabels(labelName);
		Assert.assertTrue(labelElem.isDisplayed(), "Current cycle status label " + labelName + " not displayed");
	}

	@Then("The phase based on the value entered during onboarding process should be displayed")
	public void the_phase_based_on_the_value_entered_during_onboarding_process_should_be_displayed() throws IOException {
	    String currentPhase = menstrualPhaseLogPage.getCurrentPhase();
	    String expectedPhase = Helper.calculateMenstrualPhase();
	    Assert.assertEquals(currentPhase, expectedPhase, "Current phase not matched with onboarding data");
	}

	@Then("Last period started date should be based on the date entered during onboarding process")
	public void last_period_started_date_should_be_based_on_the_date_entered_during_onboarding_process() throws IOException {
		String lastPeriod = menstrualPhaseLogPage.getLastPeriodStarted();
		logger.info("Last period date from UI: " + lastPeriod);
		DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("MMMM dd, yyyy", Locale.ENGLISH);
		LocalDate date = LocalDate.parse(lastPeriod, inputFormatter);
		DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("MM/dd/yyyy", Locale.ENGLISH);
		
	    Assert.assertEquals(date.format(outputFormatter), Helper.lastPeriodDateFromTestData(), "Last period date not matched");
	}

	@Then("Next period expected date should be based on the date entered during onboarding process")
	public void next_period_expected_date_should_be_based_on_the_date_entered_during_onboarding_process() throws IOException {
		String expectedNextPeriod = Helper.calculateNextPeriodExpected();
		String nextPeriod = menstrualPhaseLogPage.getNextPeriodExpected();
		logger.info("Next expected period date from UI: " + nextPeriod);
		DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("MMMM dd, yyyy", Locale.ENGLISH);
		LocalDate date = LocalDate.parse(nextPeriod, inputFormatter);
		DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("MM/dd/yyyy", Locale.ENGLISH);
		
		Assert.assertEquals(date.format(outputFormatter), expectedNextPeriod, "Expected next Period date not matched");
	}

	@Then("Subsection heading reflects the Current Phase in the correct format")
	public void subsection_heading_reflects_the_current_phase_in_the_correct_format() throws IOException {
		expectedPhase = Helper.calculateMenstrualPhase();
		Assert.assertEquals(menstrualPhaseLogPage.getCurrentPhaseDetailsHeading(), expectedPhase + " Details");
	}

	@Then("Display content should match current phase")
	public void display_content_should_match_current_phase() throws IOException {
	    String details = menstrualPhaseLogPage.getCurrentPhaseDetailsContent();
	    String expectedPhase = Helper.calculateMenstrualPhase();
	    Map<String, String> expected = ExcelReader.readExcelData("Menstrual Phase Logs", expectedPhase);
	    logger.info(expectedPhase + "Details: " + expected.get("Details"));
	    Assert.assertEquals(details, expected.get("Details"), "Phase details not matching with onboarding data");
	}

	@Then("User should see upcoming phases heading text")
	public void user_should_see_upcoming_phases_heading_text() {
	    Assert.assertTrue(menstrualPhaseLogPage.getUpcomingPhasesHeader().isDisplayed(), "Upcoming phase heading text not visible");
	}

	@Then("User should see upcoming phases heading subtext")
	public void user_should_see_upcoming_phases_heading_subtext() {
		Assert.assertTrue(menstrualPhaseLogPage.getUpcomingPhasesSubText().isDisplayed(), "Upcoming phase heading subtext not visible");
	}

	@Then("User should see four subsections for upcoming phases section")
	public void user_should_see_four_subsections_for_upcoming_phases_section() {
	    List<WebElement> sections = menstrualPhaseLogPage.getUpcomingPhasesSections();
	    logger.info("no of sections: "+ sections.size());
	    Assert.assertTrue(sections.size() == 4);
	}

	@Then("User should see {string} heading text for upcoming phases")
	public void user_should_see_heading_text_for_upcoming_phases(String phase) {
		Assert.assertTrue(menstrualPhaseLogPage.upcomingPhasesSectionHeadingDisplayed(phase));
	}

	@Then("User should be able to see correct start date format for {string}")
	public void user_should_be_able_to_see_correct_start_date_format_for(String phase) throws IOException {
		boolean validation = true;
		String startDate = menstrualPhaseLogPage.GetUpcomingPhasesStartDate(phase);
		String startFormat = menstrualPhaseLogPage.getStartFormat(phase);
		System.out.println("Start Date: " + startDate);
		Assert.assertTrue(startDate.startsWith(startFormat), "Does not have starts text for start date");
		String date = startDate.replace(startFormat, "").trim();
		System.out.println(date);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMM d yyyy", Locale.ENGLISH);
		String year = String.valueOf(LocalDate.now().getYear());
		try {
			LocalDate.parse(date + " " + year , formatter);
		} catch (DateTimeParseException e) {
			validation = false;
		}
		Assert.assertTrue(validation, "Start date is not in MMM DD format");
	}




}
