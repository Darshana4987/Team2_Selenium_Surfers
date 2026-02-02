@OnBoarding @Step1 @Regression
Feature: Onboarding Step 1 Blood Report Upload navigation

  Background:
    Given User is on sign up page

  Scenario: Title of the onboarding step 1
    When User clicks register button after entering valid details
    Then Title of the page should be "Upload Your Recent Blood Work"

  Scenario: Supporting text for the title
    When User clicks register button after entering valid details
    Then Step1 should have supporting text

  Scenario: Display onboarding progress
    When User clicks register button after entering valid details
    Then Onboarding progress bar is displayed

  Scenario: Progress bar is visible
    When User clicks register button after entering valid details
    Then Progress bar shows the current step as "1 of 10"

  Scenario: Upload PDF button is displayed
    When User clicks register button after entering valid details
    Then Upload PDF button is displayed

  Scenario: Upload PDF button is enabled
    When User clicks register button after entering valid details
    Then Upload PDF button should be enabled

  Scenario: Notes for upload pdf is displayed
    When User clicks register button after entering valid details
    Then PDF files only Max 10MB message is visible

  Scenario: Display skip option
    When User clicks register button after entering valid details
    Then Skip for Now card is visible

  Scenario: Text explanation for skip report
    When User clicks register button after entering valid details
    Then Explanation text about continuing without lab results is displayed

  Scenario: Continue Without Report button is displayed
    When User clicks register button after entering valid details
    Then Continue Without Report button is displayed

  Scenario: Continue without button is enabled
    When User clicks register button after entering valid details
    Then Continue without button is enabled

  Scenario: Display data security information
    When User clicks register button after entering valid details
    Then Note about secure processing and no sharing with third parties is displayed

  Scenario: Navigation to step3
    When User clicks register button after entering valid details
    When User clicks continue without report button
    Then Should be redirected to step3
