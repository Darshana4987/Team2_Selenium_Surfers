package com.herBalance.stepDefinitions;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import com.herBalance.driverFactory.DriverFactory;
import com.herBalance.pageObjects.EditprofilePageObject;
import com.herBalance.pageObjects.LoginPageObject;
import com.herBalance.pageObjects.MenstrualPhaseLogPage;

import io.cucumber.java.en.*;

public class EditProfileStepDef {
	private static Logger logger = LogManager.getLogger();
	private EditprofilePageObject editProfilePageObject;
	private LoginPageObject loginPageObject;

	//List<LoginData> loginList = TestDataUtil.getLoginData();

	public EditProfileStepDef() {
		editProfilePageObject = new EditprofilePageObject(DriverFactory.getDriver());
		loginPageObject = new LoginPageObject(DriverFactory.getDriver());
	}
	WebDriverWait wait;
	
	
	@Given("User is logged in to Herbalance app Page")
	public void user_is_logged_in_to_herbalance_app_page() {
		loginPageObject.getusernamePwd();
		loginPageObject.loginbtn();
		loginPageObject.isDashboardLoaded();
		logger.info("Logging in Her balance application");
	}

	
	@Given("User is on the Her Balance Dashboard with the Edit Profile submenu expanded")
	public void user_is_on_the_her_balance_dashboard_with_the_edit_profile_submenu_expanded() throws InterruptedException {
//		editProfilePageObject. getCurrentUrl();
//		editProfilePageObject.isUserProfileVisible();
//		Thread.sleep(5000);
//		editProfilePageObject.clickUserProfile();
//		Thread.sleep(5000);
		
		 String currentUrl = editProfilePageObject.getCurrentUrl();
		    Assert.assertTrue(
		        currentUrl.contains("dashboard"),
		        "User is NOT on Dashboard. Current URL: " + currentUrl
		    );

		    editProfilePageObject.isUserProfileVisible();
		    //Thread.sleep(5000);
		    editProfilePageObject.clickUserProfile();
		    //Thread.sleep(5000);
	}

	@When("User clicks on Edit Profile")
	public void user_clicks_on_edit_profile() throws InterruptedException {
		editProfilePageObject.isEditProfileVisible();
	//	Thread.sleep(5000);
		editProfilePageObject.clickEditProfile();
	//	Thread.sleep(5000);
	}

	@Then("Edit your Profile should be visible {string}")
	public void edit_your_profile_should_be_visible(String expectedText) {
		
		Assert.assertTrue(editProfilePageObject.isEditProfileHeaderVisible(),"Edit Your Profile header is not visible");
		Assert.assertEquals(editProfilePageObject.getEditProfileHeaderText(),
                expectedText, "Edit Profile page header text mismatch");
		
	}
	
	@Then("Edit Profile sub-header should have text {string}")
	public void edit_profile_sub_header_should_have_text(String expectedText) {
		Assert.assertTrue(editProfilePageObject.isEditProfileSubHeaderVisible(),
		        "Edit Profile sub-header is not visible");
		Assert.assertEquals(editProfilePageObject.getEditProfileSubHeaderText(),
		        expectedText, "Edit Profile sub-header text mismatch");
	}

	 @Then("There should be exactly {int} tabs on the Edit Profile page")
	    public void there_should_be_exactly_tabs_on_the_edit_profile_page(int expectedCount) {
	        int actualCount = editProfilePageObject.getEditProfileTabCount();
	        Assert.assertEquals(actualCount, expectedCount, "Tab count mismatch!");
	    }
	 
	 @Then("The following tabs should be visible on the Edit Profile page")
	    public void the_following_tabs_should_be_visible_on_the_edit_profile_page(List<String> expectedTabs) {
	        List<String> actualTabs = editProfilePageObject.getEditProfileTabTexts();

	        // Assert both lists are equal (order matters)
	        Assert.assertEquals(actualTabs, expectedTabs, "Tabs text do not match!");
	    }

	 @Then("The {string} tab should be visible and active by default")
	    public void the_tab_should_be_visible_and_active_by_default(String tabName) {
	        if (!tabName.equals("Basic Information")) {
	            throw new IllegalArgumentException("This step currently supports only 'Basic Information' tab");
	        }

	        Assert.assertTrue(editProfilePageObject.isBasicInformationTabVisible(),
	                tabName + " tab is not visible");
	        Assert.assertTrue(editProfilePageObject.isBasicInformationTabActive(),
	                tabName + " tab is not active by default");
	    }

	 
	 @Then("The Back Button should be visible")
	    public void the_back_button_should_be_visible() {
	        Assert.assertTrue(editProfilePageObject.isBackButtonVisible(), "Back Button is not visible!");
	    }

	 @Then("{string} should be visible inside section")
	    public void should_be_visible_inside_section(String expectedHeaderText) {

	        Assert.assertTrue(
	        		editProfilePageObject.isBasicInformationSectionHeaderVisible(),
	            expectedHeaderText + " section header is not visible"
	        );

	        Assert.assertEquals(
	        		editProfilePageObject.getBasicInformationSectionHeaderText(),
	            expectedHeaderText,
	            "Section header text mismatch"
	        );
	    }
	 
	 @Then("{string} sub text should be visible")
	    public void sub_text_should_be_visible(String expectedText) {

	        Assert.assertTrue(
	        		editProfilePageObject.isUpdateNameAndAgeSubTextVisible(),
	            "Sub text is not visible"
	        );

	        Assert.assertEquals(
	        		editProfilePageObject.getUpdateNameAndAgeSubText(),
	            expectedText,
	            "Sub text content mismatch"
	        );
	    }



}