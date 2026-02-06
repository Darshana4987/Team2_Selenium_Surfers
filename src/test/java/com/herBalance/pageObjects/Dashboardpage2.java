package com.herBalance.pageObjects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import org.apache.commons.io.FileUtils;

import com.herBalance.utils.ConfigReader;

public class Dashboardpage2 {

    public WebDriver driver;
    private WebDriverWait wait;
    private static Logger logger = LogManager.getLogger();

    // Locators
    private By usernameInput = By.name("username");
    private By passwordInput = By.name("password");
    private By loginButton = By.xpath("//button[@type='submit' and (normalize-space()='LogIn' or normalize-space()='Login')]");
    private By dashboardHeader = By.xpath("//h1[contains(normalize-space(), 'Dashboard')]");
    public Dashboardpage2(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(20)); // increased wait
    }

    public void openURL() {
        driver.get(ConfigReader.getUrl());
        logger.info("Navigated to: " + ConfigReader.getUrl());
    }

    public void enterUsernamePassword() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(usernameInput))
                    .sendKeys(ConfigReader.getUsername());
            wait.until(ExpectedConditions.visibilityOfElementLocated(passwordInput))
                    .sendKeys(ConfigReader.getPassword());
            logger.info("Entered username and password successfully.");
        } catch (Exception e) {
            logger.error("Failed to enter username/password: " + e.getMessage());
            takeScreenshot("EnterUsernamePasswordError");
            throw e;
        }
    }

    public void navigateToDashboard() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

            WebElement backBtn = wait.until(ExpectedConditions.elementToBeClickable(dashboardHeader));
            backBtn.click();
            logger.info("Clicked 'Back to Dashboard' button");

            WebElement header = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("/html/body/div/div[1]/div[2]/div/div[1]/h1"))); 

            if (header.isDisplayed()) {
                logger.info("Dashboard page loaded successfully");
            } else {
                logger.warn("Dashboard header not displayed correctly");
            }

        } catch (Exception e) {
            logger.error("Error navigating to Dashboard page", e);
        }
    }
    public boolean isCardStylingCorrect() {
        try {
            WebElement card = driver.findElement(By.xpath("//div[@class='condition-card']")); // adjust locator
            boolean heartIcon = card.findElement(By.xpath(".//i[contains(@class,'heart-icon')]")).isDisplayed();
            boolean infoIcon = card.findElement(By.xpath(".//i[contains(@class,'info-icon')]")).isDisplayed();
            boolean conditionName = card.findElement(By.xpath(".//span[@class='condition-name']")).isDisplayed();

            return heartIcon && infoIcon && conditionName;

        } catch (Exception e) {
            logger.error("Error checking card styling", e);
            return false;
        }
    }


    public void clickLoginButton() {
        try {
            WebElement loginBtn = wait.until(ExpectedConditions.elementToBeClickable(loginButton));
            loginBtn.click();
            logger.info("Login button clicked successfully!");
        } catch (TimeoutException e) {
            logger.error("Login button not clickable within timeout!");
            takeScreenshot("LoginButtonTimeout");
            throw e;
        } catch (NoSuchElementException e) {
            logger.error("Login button not found on page!");
            takeScreenshot("LoginButtonNotFound");
            throw e;
        } catch (Exception e) {
            logger.error("Unexpected error while clicking login button: " + e.getMessage());
            takeScreenshot("LoginButtonError");
            throw e;
        }
    }

    public boolean isDashboardLoaded() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(dashboardHeader));
            logger.info("Dashboard loaded successfully.");
            return driver.getCurrentUrl().contains("/dashboard");
        } catch (Exception e) {
            logger.error("Dashboard did not load: " + e.getMessage());
            takeScreenshot("DashboardLoadError");
            return false;
        }
    }

    private void takeScreenshot(String fileName) {
        File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String path = System.getProperty("user.dir") + "/target/screenshots/" + fileName + ".png";
        try {
            FileUtils.copyFile(srcFile, new File(path));
            logger.info("Screenshot saved: " + path);
        } catch (IOException e) {
            logger.error("Failed to save screenshot: " + e.getMessage());
        }
    }
}

	

