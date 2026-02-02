package com.herBalance.stepDefinitions;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.herBalance.driverFactory.DriverFactory;
import com.herBalance.pageObjects.LoginPageObject;
import com.herBalance.pageObjects.WorkoutPage;

import io.cucumber.java.en.*;

public class LoginPageStepDef {
	
private LoginPageObject loginPageObject;
	
	public LoginPageStepDef() {
		loginPageObject = new LoginPageObject(DriverFactory.getDriver());
	}
	WebDriverWait wait;
	
	@Given("User is on the HerBalance auth page")
	public void user_is_on_the_her_balance_auth_page() {
		loginPageObject.geturll();
	}

	@When("User clicks the login button after entering valid username and password")
	public void user_clicks_the_login_button_after_entering_valid_username_and_password() {
	   loginPageObject.getusernamePwd();
	  loginPageObject.loginbtn();
	}

	@Then("user should be redirected to the dashboard")
	public void user_should_be_redirected_to_the_dashboard() throws InterruptedException {
	   
		Assert.assertTrue(loginPageObject.isDashboardLoaded());
		  
	    Thread.sleep(5000);
	}


}