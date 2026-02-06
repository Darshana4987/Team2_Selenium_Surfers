package com.herBalance.pageObjects;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.herBalance.driverFactory.DriverFactory;


public class OnBoardingPagePart2 {

	private WebDriver driver;
	WebDriverWait wait;

	public OnBoardingPagePart2(WebDriver driver) {
		this.driver = driver;
	}

	// delete
	private By healthCondition = By.xpath("//label[normalize-space(.)='Hypothyroidism']");
	private By name = By.xpath("//input[@id='name']");
	private By age = By.xpath("//input[@id='age']");
	private By bloodPressureStatus = By.xpath("//div[normalize-space(.)=\"I'm not sure\"]");
	private By menstrualCycleAwarenessOptions = By.xpath("//input[@id='yes']");
	private By btnContinueWithoutReport = By.xpath("//button[text()='Continue Without Report']");

	// Step 6
	private By continueBtn = By.xpath("//button[contains(text(),'Continue')]");
	private By backBtn = By.xpath("//button[contains(text(),'Back')]");
	private By progressBarCurrentStep = By.xpath("//span[normalize-space()='6 of 10']");
	private By errormsgInvalidDate = By.xpath("//p[contains(normalize-space(),'last period start date')]");
	private By inputCalenderControl = By.xpath("//input[@type='date']");
	private By slider = By.xpath("//input[@id='cycle-length']");
	private By descriptionForStep6 = By.xpath("//p[contains(text(),'This phase influences energy')]");
	private By titleForStep7 = By.xpath("//h2[text()='Current Weight and Height']");

	
	

	// Step 7
	private By inputWeight = By.xpath("//input[@id='weight']");
	private By inputHeight = By.xpath("//input[@id='height']");
	private By dropdownKG = By.xpath("//option[@value='kg']");
	private By dropdownLBS = By.xpath("//option[@value='lbs']");
	private By weightUnitDropdown = By.xpath("//select[option[@value='kg'] and option[@value='lbs']]");
	private By dropdownCM = By.xpath("//input[@id='height']/following-sibling::span");
	private By BMIcalculatorBar = By.xpath("//div[contains(@class,'bg-gradient-to-r')]");
	private By errorMessageWeight = By.xpath("//p[contains(text(),'Weight')]");
	private By errorMessageHeight = By.xpath("//p[contains(text(),'Height')]");
	private By errorMessage_InvalidWeight = By.xpath("//p[contains(text(),'valid weight')]");
	private By errorMessage_InvalidHeight = By.xpath("//p[contains(text(),'valid height')]");

	// Step 8
	private By pescatarianRedioBtn = By.xpath("//label[@for='pescatarian']");
	private By titleStep9 = By.xpath("//h2[contains(@class,'font-poppins') and normalize-space()='Physical Activity Level']");
	private By descriptionForStep9 = By.xpath("//p[contains(normalize-space(),'current exercise routine')]");
	private By infoForStep9 = By.xpath("//p[contains(@class,'text-sm') and contains(normalize-space(),'fitness plan')]");
	private By redioBtnCountStep8 = By.xpath("//input[@type='radio']");


	// Step9
	private By sedentaryRedioBtn = By.xpath("//label[@for='sedentary']");
	private By redioBtnCountStep9 = By.xpath("//input[@type='radio']");
	private By titleStep10 = By.xpath("//h2[contains(normalize-space(),'Food Allergies')]");
	private By descriptionStep10 = By.xpath("//p[contains(normalize-space(),'food allergies or intolerances')]");
	private By infoForStep10 = By.xpath("//p[contains(normalize-space(),'Food sensitivities can impact digestion')]");

	// Step10
	
	private By radioBtnYES_FoodAllergies = By.xpath("//label[@for='allergies']");
	private By lblFoodAllergy = By.xpath("//label[@for='allergen-Dairy']");
	private By titleStep11 = By.xpath("//h2[text()='Medications & Supplements']");
	private By descriptionStep11 = By.xpath("//p[text()='Do you currently take any medications or supplements?']");


	// Step11
	
	private By radioOptionForMedication = By.xpath("//button[@id='prescription']");
	private By radioOptionSuppliments = By.xpath("//label[@for='medication-Thyroid medication']");
	
	private By titleForSubcriptionPage = By.xpath("//h1[text()='Choose Your Transformation Journey']");
	private By btnComplete = By.xpath("//button[text()='Complete']");

	private By errorPopUpMessage = By.xpath("//*[text()='Please select an option']");
	
	
	
	

	
	

	
	
	
	
	

	

	/* Methods Definitions */

	
	// Step 5
	
	public void clickMenstrualCycleAwarenessOptions() { // delete this method

//		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
//		wait.until(ExpectedConditions.visibilityOf(driver.findElement(menstrualCycleAwarenessOptions))).click();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		WebElement yesRadio = wait.until(
		    ExpectedConditions.elementToBeClickable(By.id("yes"))
		);

		if (!yesRadio.isSelected()) {
		    yesRadio.click();
		}
	}
	
	// Step 6

	public void gotoSignPage() {
		By btnSignUp = By.xpath("//button[text()='Sign Up']");
		driver.findElement(btnSignUp).click();
	}

	public void clickRgister() {
		By txtUserName = By.xpath("//input[@name='username']");
		By txtPwd = By.xpath("//input[@name='password']");
		By txtConfirmPwd = By.xpath("//input[@name='confirmPassword']");
		By rdoAgree = By.xpath("//button[@id=':r8:-form-item']");
		By btnRegister = By.xpath("//button[text()='Register']");
		String userName = "abcdfg" + System.currentTimeMillis() + "@gmail.com";
		String password = "123456";
		driver.findElement(txtUserName).sendKeys(userName);
		driver.findElement(txtPwd).sendKeys(password);
		driver.findElement(txtConfirmPwd).sendKeys(password);
		driver.findElement(rdoAgree).click();
		driver.findElement(btnRegister).click();

	}

	public void clickContunueWithOutReportButton() {

		WebElement button = driver.findElement(btnContinueWithoutReport);

		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", button);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(button));

		button.click();
	}

	public void clickHealthCondition() { // delete this method

		WebElement button = driver.findElement(healthCondition);

		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", button);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(button));

		button.click();

	}

	public void clickBloodPressureStatus() { // delete this method

		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(bloodPressureStatus))).click();

	}

	public void enterPersonalDetails() { // delete this method

		Actions actions = new Actions(driver);
		actions.moveToElement(driver.findElement(name)).click().sendKeys("abcd").build().perform();
		Actions actions1 = new Actions(driver);
		actions1.moveToElement(driver.findElement(age)).click().sendKeys("35").build().perform();
	}

	public void clickContinueBtn() {

		WebElement button = driver.findElement(continueBtn);

		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", continueBtn);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(continueBtn));

		wait.until(ExpectedConditions.visibilityOf(driver.findElement(continueBtn))).click();

	}

	public void clickBackBtn() {

		WebElement button = driver.findElement(backBtn);

		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", backBtn);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(backBtn));

		wait.until(ExpectedConditions.visibilityOf(driver.findElement(backBtn))).click();

	}

	public void enterlastMenstrualDate() {
		
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		    WebElement dateInput = wait.until(
		        ExpectedConditions.visibilityOfElementLocated(inputCalenderControl)
		    );
		    
		    dateInput.clear();
		    dateInput.sendKeys("25/01/2026");

//		Actions actions = new Actions(driver);
//		actions.moveToElement(driver.findElement(inputCalenderControl)).click().sendKeys("25/01/2026").build()
//				.perform();
	}

	public void enterInvalid_lastMenstrualDate() {

		Actions actions = new Actions(driver);
		actions.moveToElement(driver.findElement(inputCalenderControl)).click().sendKeys("35/13/2026").build()
				.perform();
	}

	public void moveCycleLengthBar() {

		String valueBefore = driver.findElement(slider).getAttribute("value");
		String valueAfter = driver.findElement(slider).getAttribute("value");
		boolean movable = isSliderMovable(driver.findElement(slider));

		if (movable) {
			System.out.println("Slider can be moved!");
		} else {
			System.out.println("Slider cannot be moved.");
		}

	}

	public boolean isSliderMovable(WebElement slider) {
		if (!slider.isEnabled()) {
			return false; // Slider is disabled
		}

		try {
			Actions action = new Actions(driver);
			// Move slider by offset (e.g., 10 pixels to the right)
			action.clickAndHold(slider).moveByOffset(10, 0).release().perform();
			return true; // Moved successfully
		} catch (Exception e) {
			return false; // Could not move
		}
	}

	public String getErrorText_InvalidDate() {

			try {
				return driver.findElement(errormsgInvalidDate).getText();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;	
	}

	public String getprogressBarCurrentStep() {

		return driver.findElement(progressBarCurrentStep).getText();
	}
	
	public String getDescriptionForStep6() {

		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		return wait.until(ExpectedConditions.visibilityOfElementLocated(descriptionForStep6)).getText();
	}
	
	
	public String getTitleForStep6() {

		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		return wait.until(ExpectedConditions.visibilityOfElementLocated(titleForStep7)).getText();
	}
	
	
	

	// Step 7

	public void enterEmptyWeight() {

		Actions actions = new Actions(driver);
		actions.moveToElement(driver.findElement(inputWeight)).click().sendKeys("").build().perform();
	}

	public void enterEmptyHeight() {

		Actions actions = new Actions(driver);
		actions.moveToElement(driver.findElement(inputHeight)).click().sendKeys("").build().perform();
	}

	public void enterWeight() {

		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		Actions actions = new Actions(driver);
		actions.moveToElement(driver.findElement(inputWeight)).click().sendKeys("60").build().perform();
	}

	public void enterHeight() {

		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		Actions actions = new Actions(driver);
		actions.moveToElement(driver.findElement(inputHeight)).click().sendKeys("154").build().perform();
	}

	public void enterInvalidWeight() {

		Actions actions = new Actions(driver);
		actions.moveToElement(driver.findElement(inputWeight)).click().sendKeys("6088888888").build().perform();
	}

	public void enterInvalidHeight() {

		Actions actions = new Actions(driver);
		actions.moveToElement(driver.findElement(inputHeight)).click().sendKeys("154888888888").build().perform();
	}

	public String getErrorText_EmptyWeight() {

		return driver.findElement(errorMessageWeight).getText();
	}

	public String getErrorText_EmptyHeight() {

		return driver.findElement(errorMessageHeight).getText();
	}

	public String getErrorText_InvalidWeight() {

		return driver.findElement(errorMessage_InvalidWeight).getText();
	}

	public String getErrorText_InvalidHeight() {

		return driver.findElement(errorMessage_InvalidHeight).getText();
	}

	public boolean isKGUnit_Visible() {

		return driver.findElement(dropdownKG).isDisplayed();

	}

	public boolean isLBSUnit_Visible() {

		return driver.findElement(dropdownLBS).isDisplayed();

	}

	public String getText_KGUnit() {

		return driver.findElement(dropdownKG).getText();
	}

	public String getText_LBSUnit() {

		return driver.findElement(dropdownLBS).getText();
	}

	public boolean isCMunit_Visible() {

		return driver.findElement(dropdownCM).isDisplayed();

	}

	public String getText_CMunit() {

		return driver.findElement(dropdownCM).getText();
	}

	public boolean isBMI_BarVisible() {

		return driver.findElement(BMIcalculatorBar).isDisplayed();

	}

	public int RedirectToNextStep() {

		String text = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'of 10')]")))
				.getText();

		int currentStep = Integer.parseInt(text.split(" ")[0]);

		return currentStep;

	}

	// Step 8

	public void selectPescatarianRedioBtn() {

		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(pescatarianRedioBtn))).click();

	}
	public boolean isRadioButtonEnabled() {
		
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		driver.findElement(redioBtnCountStep8).click();
		return driver.findElement(redioBtnCountStep8).isEnabled();
	}
	
	public String geTitleStep9() {

		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		return wait.until(ExpectedConditions.visibilityOfElementLocated(titleStep9)).getText();
	}
	
	public String getDescriptionForStep9() {

		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		return wait.until(ExpectedConditions.visibilityOfElementLocated(descriptionForStep9)).getText();
	}
	
	public String geInfoForStep9() {

		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		return wait.until(ExpectedConditions.visibilityOfElementLocated(infoForStep9)).getText();
	}
	
	public int getRadioBtnCountForStep8() {

		return driver.findElements(redioBtnCountStep8).size();
	}
	
	
	
	// Step 9

	public void selectSedentaryRedioBtn() {

		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(sedentaryRedioBtn))).click();
	}
	
	public int getRadioBtnCountForStep9() {

		return driver.findElements(redioBtnCountStep9).size();
	}
	
	public String geTitleStep10() {

		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		return wait.until(ExpectedConditions.visibilityOfElementLocated(titleStep10)).getText();
	}
	
	public String getDescriptionForStep10() {

		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		return wait.until(ExpectedConditions.visibilityOfElementLocated(descriptionStep10)).getText();
	}
	
	public String geInfoForStep10() {

		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		return wait.until(ExpectedConditions.visibilityOfElementLocated(infoForStep10)).getText();
	}
	
	public boolean getPhysicalActivityLevelOptions(String options) {

		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		List<WebElement> physicalActivityOptions = wait
				.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(sedentaryRedioBtn));

		for (WebElement op : physicalActivityOptions) {
			if (op.getText().equals(options))
				return true;
		}
		return false;
	}
	
	// Step10
	
	public void selectYES_RedioBtn() {

		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(radioBtnYES_FoodAllergies))).click();
	}
	public void selectFoodAllergy() {

		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(lblFoodAllergy))).click();
	}
	
	public boolean isFoodAllergyOptionsLabelVisible(String foodAllergyOptionLabel) {
		
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		List<WebElement> bloodPressureLabel = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(lblFoodAllergy));
	
		for (WebElement b : bloodPressureLabel) {
			if (b.getText().equals(foodAllergyOptionLabel))
				return true;
		}
		return false;
	}
	
	
	public String geTitleStep11() {

		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		return wait.until(ExpectedConditions.visibilityOfElementLocated(titleStep11)).getText();
	}
	
	public String getDescriptionForStep11() {

		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		return wait.until(ExpectedConditions.visibilityOfElementLocated(descriptionStep11)).getText();
	}
	
	
	// Step 11
	
	
	
	public void selectRedioBtnForMedication() {

		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(radioOptionForMedication))).click();
	}
	
	public void btnCompleteClicked() {

		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(btnComplete))).click();
	}
	
	public void selectRedioBtnForSuppliments() {

		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(radioOptionSuppliments))).click();
	}
	
	public String geTitleSubcriptionPage() {

		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		return wait.until(ExpectedConditions.visibilityOfElementLocated(titleForSubcriptionPage)).getText();
	}
	
	public String getErrorMessgaeForStep11() {

		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		return wait.until(ExpectedConditions.visibilityOfElementLocated(errorPopUpMessage)).getText();
	}
	
	public boolean isRadioBtnForMedicationSelected() {
		
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		driver.findElement(radioOptionForMedication).click();
		return driver.findElement(radioOptionForMedication).isSelected();
	}
	
	
	
	

}
