Feature: Login Functionality on HerBallance Auth page
# Non-Functional tests

  Scenario: Verify the logo is displayed on the login page
    Given User is on the HerBalance auth page
    Then User should see the HerBalance logo on the page

  Scenario: Verify the Login and Sign Up tabs is displayed on the login page
    Given User is on the HerBalance auth page
    Then User should be able to see "<Tabname>" in login page

    Examples:
      | Tabname |
      | Login   |
      | Sign Up |

  Scenario: Verify Login tab is active by default
    Given User is on the HerBalance auth page
    Then Login tab should be active

  Scenario: Verify Email ID input field is visible on login page
    Given User is on the HerBalance auth page
    Then Email ID input field with placeholder "you@example.com" should be visible

  Scenario: Verify Password input field with masked entry is visible
    Given User is on the HerBalance auth page
    Then Password input field with masked entry should be visible

  Scenario: Verify Show Password option is visible
    Given User is on the HerBalance auth page
    Then Show password option should be visible

  Scenario: Successful login with valid username and password
    Given User is on the HerBalance auth page
    When User clicks the login button after entering valid username and password
    Then user should be redirected to the dashboard
