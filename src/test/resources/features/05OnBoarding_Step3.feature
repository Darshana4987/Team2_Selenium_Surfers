@OnBoarding @Step3 @Regression
Feature: Onboarding Step 3 (with or without blood report upload)

  Background:
    Given User is in upload blood report page

  Scenario: Display onBoarding progress
    When User clicks continue without report
    Then OnBoarding progress bar is displayed

  Scenario: Progress bar is visible
    When User clicks continue without report
    Then Progress bar shows the current step as "3 of 10"

  Scenario: Back button is visible
    When User clicks continue without report
    Then Back button is displayed

  Scenario: state of Back button
    When User clicks continue without report
    Then Back button should be enabled

  Scenario: Continue is visible
    When User clicks continue without report
    Then Continue button should be visible

  Scenario: State of Continue button
    When User clicks continue without report
    Then Continue button should be enabled

  Scenario: Step 3 Header is displayed
    When User clicks continue without report
    Then Header should be "Health Conditions"

  Scenario: Sub title for the header
    When User clicks continue without report
    Then "Want to manually enter any key conditions or comorbidities?" header title should be displayed

  Scenario: Total number of radio button
    When User clicks continue without report
    Then 9 radio buttons should be visible

  Scenario Outline: Options text for health conditions
    When User clicks continue without report
    Then Following radio button "<options>" should be visible

    Examples:
      | options                                      |
      | PCOS                                         |
      | Pre-diabetes / Diabetes                      |
      | Sleep apnea                                  |
      | Cardiovascular Disease                       |
      | Kidney Disease                               |
      | Hypothyroidism                               |
      | High cholesterol                             |
      | Digestive issues (IBS, leaky gut, etc.)      |
      | Liver Disease                                |
      | I am perimenopausal or menopausal (age ~45+) |

  Scenario: Informational note section
    When User clicks continue without report
    Then Note text should be displayed
