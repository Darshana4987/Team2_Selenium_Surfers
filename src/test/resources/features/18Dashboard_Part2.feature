@healthconidition
Feature: Health Conditions verification on HerBalance dashboard

  Background:
    Given User is logged in to HerBalance app page
    When User is on the HerBalance website page
    Then User should be on the dashboard

  @healthCondition
  Scenario: Automatic data mapping from onboarding
    Given User has completed onboarding and selected one or more health conditions
    When User clicks login button after entering a valid credential
    Then Displayed condition(s) should match exactly what was selected during onboarding

  @healthCondition
  Scenario: Condition description message
    Given User has completed onboarding and selected one or more health conditions
    When User clicks login button after entering a valid credential
    Then Message appears below condition card explaining how the plan is adjusted

  @healthCondition
  Scenario: Styling and icon display
    Given User has completed onboarding and selected one or more health conditions
    When User clicks login button after entering a valid credential
    Then Card includes heart icon, condition name, and info icon with related text

  @healthCondition
  Scenario: No condition scenario
    Given User has completed onboarding without health conditions
    When User clicks login button after entering a valid credential
    Then Message like "No health conditions selected" or an empty state is displayed
