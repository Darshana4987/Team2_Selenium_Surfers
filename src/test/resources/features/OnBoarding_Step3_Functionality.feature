@OnBoarding @Step3 @Regression
Feature: Onboarding step 3 Functionality and Step 4 UI verification

  Background:
    Given User is in step3 of onboarding

  Scenario: Navigation to Step 4
    When User clicks continue by selecting one or more health conditions
    Then Redirected to Step4

  Scenario: Display onboarding progress
    When User clicks continue by selecting one or more health conditions
    Then Onboarding progress bar is displayed

  Scenario: Progress bar is visible
    When User clicks continue by selecting one or more health conditions
    Then Progress bar shows the current step as "4 of 10"

  Scenario: Back button is visible
    When User clicks continue by selecting one or more health conditions
    Then Back button is displayed

  Scenario: state of Back button
    When User clicks continue by selecting one or more health conditions
    Then Back button should be enabled

  Scenario: Continue is visible
    When User clicks continue by selecting one or more health conditions
    Then Continue button should be visible

  Scenario: State of Continue button
    When User clicks continue by selecting one or more health conditions
    Then Continue button should be enabled

  Scenario: Title for Step4
    When User clicks continue by selecting one or more health conditions
    Then Should see the title "Personal Details"

  Scenario: Description text for step4
    When User clicks continue by selecting one or more health conditions
    Then Description text "Let's get to know you better to personalize your experience." should be displayed

  Scenario: Input box count
    When User clicks continue by selecting one or more health conditions
    Then 2 input boxes are visible

  Scenario Outline: Field labels
    When User clicks continue by selecting one or more health conditions
    Then Input "<fields>" labels should be visible

    Examples:
      | fields                                          |
      | What's your first name?                         |
      | What's your age?                                |
      | What best describes your blood pressure status? |

  Scenario Outline: Helper text for the fields
    When User clicks continue by selecting one or more health conditions
    Then Under each field following "<helper_text>" should be displayed

    Examples:
      | helper_text                                                                                                                                       |
      | Personalizing your experience starts with knowing your name.                                                                                      |
      | Your age helps us tailor recommendations suitable for your life stage.                                                                            |
      | Understanding your blood pressure status helps us tailor workouts and nutrition plans that are safe and effective for your cardiovascular health. |

  Scenario: Total number of radio button
    When User clicks continue by selecting one or more health conditions
    Then 4 radio button should be visible on step4

  Scenario Outline: Options for radio button
    When User clicks continue by selecting one or more health conditions
    Then Radio button "<options>" for blood pressure should be displayed

    Examples:
      | options                                                                   |
      | I have been diagnosed with high blood pressure and take medication for it |
      | I have been diagnosed but don't take medication                           |
      | I have never been diagnosed                                               |
      | I'm not sure                                                              |
