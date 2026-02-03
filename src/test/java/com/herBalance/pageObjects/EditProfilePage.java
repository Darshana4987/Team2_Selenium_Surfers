package com.herBalance.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;

public class EditProfilePage {

    WebDriver driver;

    public EditProfilePage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement editProfileSubmenu() {
        return driver.findElement(By.id("editProfileMenu")); 
    }

    public WebElement basicInfoTab() {
        return driver.findElement(By.id("basicInfoTab")); 
    }

    public WebElement profileTitle() {
        return driver.findElement(By.xpath("//h1[text()='Edit your Profile']"));
    }

    public WebElement profileSubText() {
        return driver.findElement(By.xpath("//p[contains(text(),'Update your personal information')]"));
    }

    public List<WebElement> tabs() {
        return driver.findElements(By.cssSelector(".tabs li"));
    }

    public WebElement getTabByName(String tabName) {
        return driver.findElement(By.xpath("//li[text()='" + tabName + "']"));
    }

    public WebElement backButton() {
        return driver.findElement(By.id("backButton")); 
    }

    public WebElement basicInfoHeader() {
        return driver.findElement(By.xpath("//h2[text()='Basic Information']"));
    }

    public WebElement basicInfoSubText() {
        return driver.findElement(By.xpath("//p[contains(text(),'Update your name and age')]"));
    }

    public WebElement nameInput() {
        return driver.findElement(By.id("nameInput")); 
    }

    public WebElement ageInput() {
        return driver.findElement(By.id("ageInput"));
    }

    public WebElement nextBodyMetricsButton() {
        return driver.findElement(By.xpath("//button[text()='Next: Body Metrics']"));
    }
}
