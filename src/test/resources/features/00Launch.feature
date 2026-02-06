
@tag @Regression
Feature: Launchpage test

  @LaunchPageTC01
  Scenario: Verify button is clickable
    Given The user is on herbalance home page
    When User clicks Sign Up button
    Then User should be navigated to auth page Signup tab

  @LaunchPageTC02
  Scenario: Verify button is clickable
    Given The user is on herbalance home page
    When User clicks Get Started button
    Then User should be navigated to auth page Signup tab

  @LaunchPageTC03
  Scenario: Verify button is clickable
    Given The user is on herbalance home page
    When User clicks Start your personalized journey button
    Then User should be navigated to auth page Signup tab

  @LaunchPageTC04
  Scenario: Verify Sign up button is clickable
    Given The user is on herbalance home page
    When the user clicks Login button
    Then User should be navigated to auth page Login tab

  @LaunchPageTC05
  Scenario: Verify buttons are displayed in herbalance page
    Given User is on the browser
    When User enters app url
    Then the page with login button should be displayed

  @LaunchPageTC06
  Scenario: Verify buttons are displayed in herbalance page
    Given User is on the browser
    When User enters app url
    Then the page with Sign Up button should be displayed

  @LaunchPageTC07
  Scenario: Verify buttons are displayed in herbalance page
    Given User is on the browser
    When User enters app url
    Then the page with Get Started button should be displayed

  @LaunchPageTC08
  Scenario: Verify buttons are displayed in herbalance page
    Given User is on the browser
    When User enters app url
    Then the page with Start your personalized journey button should be displayed

  @LaunchPageTC09
  Scenario: Verify if Cycle phases information is displayed
    Given User is on the browser
    When User enters app url
    Then Display cards for different phases are displayed

  @LaunchPageTC010
  Scenario: Verify if Cycle tracking app information is visible
    Given User is on the browser
    When User enters app url
    Then Details about the Cycle Tracking App and its features are displayed

  @LaunchPageTC11
  Scenario: Verify if Images in Sync your weight loss journey section are displayed
    Given User is on the browser
    When User enters app url
    Then Images in Sync should be displayed

  @LaunchPageTC12
  Scenario: Verify if Informational text under Empower weight loss section is displayed
    Given User is on the browser
    When User enters app url
    Then Display information about hormonal shifts and metabolism during the menstrual cycle

  @LaunchPageTC13
  Scenario: Verify if Layout and colors are loaded correctly
    Given User is on the browser
    When User enters app url
    Then User should see a light purple background and readable text content
