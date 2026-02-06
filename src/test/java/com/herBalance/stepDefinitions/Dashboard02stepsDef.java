package com.herBalance.stepDefinitions;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.herBalance.driverFactory.DriverFactory;
import com.herBalance.pageObjects.Dashboardpage2;
import com.herBalance.pageObjects.LoginPageObject;

import io.cucumber.java.en.*;

public class Dashboard02stepsDef {
    private static Logger logger = LogManager.getLogger();
    private Dashboardpage2 healthPageObject;
    private LoginPageObject loginPageObject;

    public Dashboard02stepsDef() {
        healthPageObject = new Dashboardpage2(DriverFactory.getDriver());
        loginPageObject = new LoginPageObject(DriverFactory.getDriver());
    }

    WebDriverWait wait;

    @Given("User is logged in to HerBalance app page")
    public void user_is_logged_in_to_herbalance_app_page() {
        loginPageObject.getusernamePwd();
        loginPageObject.loginbtn();
        loginPageObject.isDashboardLoaded();
        logger.info("Logging in to HerBalance application");
    }

    @When("User is on the HerBalance website page")
    public void user_is_on_herbalance_website_page() {
        String currentUrl = DriverFactory.getDriver().getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("dashboard") || currentUrl.contains("auth"),
                "User is not on auth/dashboard page. Current URL: " + currentUrl);
        logger.info("User is on HerBalance auth page");
    }

    @Then("User should be on the dashboard")
    public void user_should_be_on_dashboard() {
        String currentUrl = DriverFactory.getDriver().getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("dashboard"),
                "User is not redirected to dashboard. Current URL: " + currentUrl);
        logger.info("User is on dashboard page");
    }

    @Given("User has completed onboarding and selected one or more health conditions")
    public void user_has_selected_health_conditions() {
        healthPageObject.navigateToDashboard();
        logger.info("User has selected health conditions during onboarding");
    }

    @Given("User has completed onboarding without health conditions")
    public void user_has_no_health_conditions() {
        healthPageObject.navigateToDashboard();
        logger.info("User did not select any health conditions during onboarding");
    }

    @When("User clicks login button after entering a valid credential")
    public void user_clicks_login_button() {
        healthPageObject.clickLoginButton();
        logger.info("Clicked login button on HerBalance auth page");
    }
   

    @Then("Card includes heart icon, condition name, and info icon with related text")
    public void card_styling_and_icons_displayed() {
        Assert.assertTrue(
                healthPageObject.isCardStylingCorrect(),
                "Health condition card styling or icons are incorrect"
        );
        logger.info("Health condition card styling and icons are correct");
    }


}
  
