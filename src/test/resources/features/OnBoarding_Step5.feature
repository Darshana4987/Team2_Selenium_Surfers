@OnBoarding @Step5 @Regression
Feature: Onboarding step 5 Functionality and Step 6 UI verification

  Background:
    Given User is in step5 of onboarding

  @Bug
  Scenario: Error message for without selecting menstrual cycle
    When User clicks continue button without selecting menstrual cycle
    Then Error message "Please select your menstrual cycle track" should be displayed

  Scenario: Navigating back to step 4
    When User clicks back button in step5
    Then Redirected to Step 4

  Scenario: Navigation to Step 6
    When User clicks continue after selecting menstrual cycle info
    Then Redirected to Step 6

  Scenario: Display onboarding progress in step 6
    When User clicks continue after selecting menstrual cycle info
    Then Onboarding progress bar is displayed

  Scenario: Progress bar is visible in step 6
    When User clicks continue after selecting menstrual cycle info
    Then Progress bar shows the current step as "6 of 10"

  Scenario: Back button is visible in step 6
    When User clicks continue after selecting menstrual cycle info
    Then Back button is displayed

  Scenario: state of Back button in step 6
    When User clicks continue after selecting menstrual cycle info
    Then Back button should be enabled

  Scenario: Continue is visible in step 6
    Given User clicks continue after selecting menstrual cycle info
    Then Continue button should be visible

  Scenario: State of Continue button in step 6
    When User clicks continue after selecting menstrual cycle info
    Then Continue button should be enabled

  Scenario: Title for step 6
    When User clicks continue after selecting menstrual cycle info
    Then Should see the title "Last Period Date"

  Scenario: Description text for step 6
    When User clicks continue after selecting menstrual cycle info
    Then Description text "This helps us understand your current cycle phase and tailor recommendations."

  Scenario: Presence of question in step 6
    When User clicks continue after selecting menstrual cycle info
    Then Question "When did your last menstrual period start?" should be visible

  Scenario: Presence of calendar icon in step 6
    When User clicks continue after selecting menstrual cycle info
    Then Calendar icon should be visible inside the date input field

  Scenario: Placeholder text for date field in sep 6
    When User clicks continue after selecting menstrual cycle info
    Then Date input field with placeholder mm/dd/yyyy should be displayed

  Scenario: Label below the date field
    When User clicks continue after selecting menstrual cycle info
    Then Label "Cycle Length (days)" should be visible

  Scenario: Slider for cycle length
    When User clicks continue after selecting menstrual cycle info
    Then Slider control for cycle length should be displayed

  Scenario: Default cycle length in slider
    When User clicks continue after selecting menstrual cycle info
    Then Default cycle length value e.g., "28" should be shown beside the slider

  Scenario: Information text for cycle length
    When User clicks continue after selecting menstrual cycle info
    Then Information text "Average cycle length is 28 days, but can vary from 21 to 45 days" should be visible
