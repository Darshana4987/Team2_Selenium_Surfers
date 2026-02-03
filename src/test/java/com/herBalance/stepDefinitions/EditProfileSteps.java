package com.herBalance.stepDefinitions;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import java.time.Duration;
import java.util.List;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EditProfileSteps {

    public static WebDriver driver;
    
   

    @Given("User is on the Her Balance Dashboard with the Edit Profile submenu expanded")
    public void user_is_on_dashboard_with_edit_profile_expanded() {
        WebDriverManager.chromedriver().setup(); 
        driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://herbalance.numpyninja.com/profile/edit");

        Assert.assertTrue(driver.getTitle().contains("Her Balance"), "Dashboard page not loaded properly");
    }

    @When("User clicks on Edit Profile")
    public void user_clicks_on_edit_profile() {
    }

    @Then("Edit your Profile should be visible")
    public void edit_your_profile_should_be_visible() {
        WebElement title = driver.findElement(By.xpath("//h1[text()='Edit your Profile']"));
        Assert.assertTrue(title.isDisplayed(), "Edit Your Profile title is not visible");
    }

    @Then("Update your personal information and preferences should be visible")
    public void sub_text_for_title_is_displayed() {
        WebElement subText = driver.findElement(By.xpath("//p[contains(text(),'Update your personal information')]"));
        Assert.assertTrue(subText.isDisplayed(), "Sub text for title is not visible");
    }

    @Then("There should be exactly 3 tabs")
    public void total_number_of_tabs() {
        List<WebElement> tabs = driver.findElements(By.cssSelector(".nav-tabs li"));
        Assert.assertEquals(tabs.size(), 3, "Total number of tabs is not 3");
    }

    @Then("{string}, {string}, {string} tabs should be visible")
    public void tabs_header_are_displayed(String tab1, String tab2, String tab3) {
        List<WebElement> tabs = driver.findElements(By.cssSelector(".nav-tabs li a"));
        Assert.assertEquals(tabs.get(0).getText(), tab1, "First tab mismatch");
        Assert.assertEquals(tabs.get(1).getText(), tab2, "Second tab mismatch");
        Assert.assertEquals(tabs.get(2).getText(), tab3, "Third tab mismatch");
    }

    @Then("Basic Information should be visible by default")
    public void default_tab() {
        WebElement defaultTabContent = driver.findElement(By.id("basic-information"));
        Assert.assertTrue(defaultTabContent.isDisplayed(), "Basic Information tab is not visible by default");
    }

    @Then("Back Button should be visible")
    public void back_button_presence() {
        WebElement backButton = driver.findElement(By.xpath("//button[text()='Back']"));
        Assert.assertTrue(backButton.isDisplayed(), "Back button is not visible");
    }

    public static void closeBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }
}
