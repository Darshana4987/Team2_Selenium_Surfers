@OnBoarding @Step2 @Regression
Feature: Onboarding Step 2 only after blood report upload

  Background:
    Given User is in upload blood report page

  Scenario: Display onboarding progress
    When User clicks on Upload PDF button by selecting valid file
    Then Onboarding progress bar is displayed

  @Bug
  Scenario: Progress bar is visible
    When User clicks on Upload PDF button by selecting valid file
    Then Progress bar shows the current step as "2 of 10"

  @Bug
  Scenario: Continue button
    When User clicks on Upload PDF button by selecting valid file
    Then Continue button should be enabled

  @Bug
  Scenario: Navigation to step 3
    When User clicks on Upload PDF button by selecting valid file
    When User clicks continue button
    Then Redirected to Step 3
