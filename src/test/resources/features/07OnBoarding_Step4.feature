@OnBoarding @Step4 @Regression
Feature: Onboarding step 4 Functionality and Step 5 UI verification

  Background:
    Given User is in step4 of onboarding

  Scenario Outline: Error message for invalid values in First name
    When User clicks continue button after entering "<invalid value>" in first name
    Then Error message "Name is required" should be displayed in Step4

    Examples:
      | invalid value |
      |               |
      | ~@            |

  Scenario Outline: Error message for invalid values in age
    When User clicks continue button after entering "<invalid value>" in age
    Then Error message "<error message>" should be displayed in Step4

    Examples:
      | invalid value     | error message                  |
      |                   | Age is required                |
      | -1                | Age must be between 18 and 100 |
      | 0                 | Age must be between 18 and 100 |
      | 17                | Age must be between 18 and 100 |
      | 101               | Age must be between 18 and 100 |
      | 17.999999999      | Age must be between 18 and 100 |
      | 100.0000000000001 | Age must be between 18 and 100 |

  Scenario: Error message for without selecting blood pressure status
    When User clicks continue button without selecting blood pressure status
    Then Error message "Please select your blood pressure status" should be displayed in Step4

  Scenario: Navigating back to step 3
    When User clicks back button in step4
    Then Redirected to Step 3

  Scenario: Navigation to Step 5
    When User clicks continue after entering all required details
    Then Redirected to Step 5

  Scenario: Step 5 UI verification
    When User clicks continue after entering all required details
    Then Onboarding progress bar is displayed

  Scenario: Progress bar is visible in step 5
    When User clicks continue after entering all required details
    Then Progress bar shows the current step as "5 of 10"

  Scenario: Back button is visible in step 5
    When User clicks continue after entering all required details
    Then Back button is displayed

  Scenario: state of Back button in step 5
    When User clicks continue after entering all required details
    Then Back button should be enabled

  Scenario: Continue is visible in step 5
    When User clicks continue after entering all required details
    Then Continue button should be visible

  Scenario: State of Continue button in step 5
    When User clicks continue after entering all required details
    Then Continue button should be enabled after selecting currently tracking option

  Scenario: Title for Step 5
    When User clicks continue after entering all required details
    Then Should see the title "Menstrual Cycle Awareness"

  Scenario: Description text for step 5
    When User clicks continue after entering all required details
    Then Description text "Understanding your cycle helps us optimize your weight loss journey."

  Scenario: Presence of question in step 5
    When User clicks continue after entering all required details
    Then Question "Do you currently track your menstrual cycle?" should be visible

  Scenario: Total number of radio button
    When User clicks continue after entering all required details
    Then 3 radio button should be visible on step5

  Scenario Outline: : Options for radio button
    When User clicks continue after entering all required details
    Then Radio "<options>" for  menstrual cycle awareness should be displayed

    Examples:
      | options               |
      | Yes                   |
      | No                    |
      | My cycle is irregular |
