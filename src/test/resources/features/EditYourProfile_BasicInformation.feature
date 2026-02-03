@Profile @EditProfile @Regression
Feature: Edit Your Profile - Basic Information UI verification

  Background:
    Given User is on the Her Balance Dashboard with the Edit Profile submenu expanded
    And User clicks on Edit Profile submenu

  Scenario: Header text inside the section
    When User clicks on Basic Information tab
    Then "Basic Information" header should be visible
@edit1
  Scenario: Sub text for header
    When User clicks on Basic Information tab
    Then "Update your name and age" sub text should be visible

  Scenario: Name input field presence
    When User clicks on Basic Information tab
    Then Name input field should display the user's name

  Scenario: Age input field presence
    When User clicks on Basic Information tab
    Then Age input field should display the user's age

  Scenario: Input field alignment and spacing
    When User clicks on Basic Information tab
    Then Name and Age fields should be properly aligned vertically with equal spacing

  Scenario: "Next: Body Metrics" button presence and state
    When User clicks on Next: Body Metrics button
    Then "Next: Body Metrics" button should be visible and enabled
