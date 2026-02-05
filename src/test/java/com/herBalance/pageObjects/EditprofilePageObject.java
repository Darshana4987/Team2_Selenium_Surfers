package com.herBalance.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

public class EditprofilePageObject {

    private WebDriver driver;
    private WebDriverWait wait;


    private By userProfileButton =
            By.xpath("//button[.//span[contains(@class,'font-medium')]]");

    private By editProfileOption =
            By.xpath("//div[text()='Edit Profile']");

    private By editProfileHeader =
            By.xpath("//h1[text()='Edit Your Profile']");

    private By editProfileSubHeader =
            By.xpath("//p[text()='Update your personal information and preferences']");

    private By editProfileTabs =
            By.xpath("//div[@role='tablist']//button[@role='tab']");

    private By basicInformationTab =
            By.xpath("//div[@role='tablist']//button[@role='tab' and text()='Basic Information']");

    private By backButton =
            By.xpath("//button[normalize-space()='Back']");

    private By basicInformationSectionHeader =
            By.xpath("//h3[text()='Basic Information']");

    private By updateNameAndAgeSubText =
            By.xpath("//p[text()='Update your name and age']");


    public EditprofilePageObject(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }


    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    public boolean isUserProfileVisible() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(userProfileButton));
        return driver.findElement(userProfileButton).isDisplayed();
    }

    public void clickUserProfile() {
        wait.until(ExpectedConditions.elementToBeClickable(userProfileButton)).click();
    }

    public boolean isEditProfileVisible() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(editProfileOption));
        return driver.findElement(editProfileOption).isDisplayed();
    }

    public void clickEditProfile() {
        wait.until(ExpectedConditions.elementToBeClickable(editProfileOption)).click();
    }

    public boolean isEditProfileHeaderVisible() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(editProfileHeader));
        return driver.findElement(editProfileHeader).isDisplayed();
    }

    public String getEditProfileHeaderText() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(editProfileHeader));
        return driver.findElement(editProfileHeader).getText();
    }

    public boolean isEditProfileSubHeaderVisible() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(editProfileSubHeader));
        return driver.findElement(editProfileSubHeader).isDisplayed();
    }

    public String getEditProfileSubHeaderText() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(editProfileSubHeader));
        return driver.findElement(editProfileSubHeader).getText();
    }

    public int getEditProfileTabCount() {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(editProfileTabs));
        return driver.findElements(editProfileTabs).size();
    }

    public List<String> getEditProfileTabTexts() {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(editProfileTabs));
        return driver.findElements(editProfileTabs)
                     .stream()
                     .map(WebElement::getText)
                     .collect(Collectors.toList());
    }

    public boolean isBasicInformationTabVisible() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(basicInformationTab));
        return driver.findElement(basicInformationTab).isDisplayed();
    }

    public boolean isBasicInformationTabActive() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(basicInformationTab));
        return "true".equals(
                driver.findElement(basicInformationTab).getAttribute("aria-selected")
        );
    }

    public boolean isBackButtonVisible() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(backButton));
        return driver.findElement(backButton).isDisplayed();
    }

    public boolean isBasicInformationSectionHeaderVisible() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(basicInformationSectionHeader));
        return driver.findElement(basicInformationSectionHeader).isDisplayed();
    }

    public String getBasicInformationSectionHeaderText() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(basicInformationSectionHeader));
        return driver.findElement(basicInformationSectionHeader).getText();
    }

    public boolean isUpdateNameAndAgeSubTextVisible() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(updateNameAndAgeSubText));
        return driver.findElement(updateNameAndAgeSubText).isDisplayed();
    }

    public String getUpdateNameAndAgeSubText() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(updateNameAndAgeSubText));
        return driver.findElement(updateNameAndAgeSubText).getText();
    }
}