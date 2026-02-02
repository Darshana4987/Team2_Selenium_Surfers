package com.herBalance.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class EditProfilePage {
    private WebDriver driver;

    
    private By profileTitle = By.xpath("//h1[text()='Edit your Profile']");
    private By profileSubText = By.xpath("//p[contains(text(),'Update your personal information')]");
    private By basicInfoTab = By.xpath("//button[text()='Basic Information']");
    private By bodyMetricsTab = By.xpath("//button[text()='Body Metrics']");
    private By preferencesHealthTab = By.xpath("//button[text()='Preferences & Health']");
    private By backButton = By.xpath("//button/span[text()='Back']/parent::button");
    private By firstNameInput = By.xpath("//input[@id='first_name']");
    private By lastNameInput = By.xpath("//input[@id='last_name']");
    private By emailInput = By.xpath("//input[@id='email']");
    private By dobInput = By.xpath("//input[@id='dob']");
    private By genderDropdown = By.xpath("//select[@id='gender']");
    private By heightInput = By.xpath("//input[@id='height']");
    private By weightInput = By.xpath("//input[@id='weight']");
    private By activityLevelDropdown = By.xpath("//select[@id='activity_level']");
    private By healthNotesTextArea = By.xpath("//textarea[@id='health_notes']");
    private By saveButton = By.xpath("//button[text()='Save']");
    public EditProfilePage(WebDriver driver) {
        this.driver = driver;
    }
    public WebElement getProfileTitle() {
        return driver.findElement(profileTitle);
    }

    public WebElement getProfileSubText() {
        return driver.findElement(profileSubText);
    }

    public WebElement getBasicInfoTab() {
        return driver.findElement(basicInfoTab);
    }

    public WebElement getBodyMetricsTab() {
        return driver.findElement(bodyMetricsTab);
    }

    public WebElement getPreferencesHealthTab() {
        return driver.findElement(preferencesHealthTab);
    }

    public WebElement getBackButton() {
        return driver.findElement(backButton);
    }

    public WebElement getSaveButton() {
        return driver.findElement(saveButton);
    }
    
}
