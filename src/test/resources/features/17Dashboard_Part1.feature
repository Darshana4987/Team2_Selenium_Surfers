@Regression
Feature: Check the appearance of the dashboad page

  @dashboard1
  Scenario: check the page title on the dashboard page
    Given User is on the HerBalance auth page
    When User clicks the login button after entering valid username and password
    Then The user should see the "Free Plan Dashboard" title

  @dashboard2
  Scenario: check the username is visible
    Given User is on the HerBalance auth page
    When User clicks the login button after entering valid username and password
    Then The user should see the username on the top right corner of the dashboard page
