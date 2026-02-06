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
     @bloodReport
  Scenario: Display upload blood report option when report is not uploaded
    Given User has completed onboarding and not uploaded blood report
    When User clicks login button after entering a valid credential
    Then "Upload Blood Report" button should be displayed

  @bloodReport
  Scenario: Message prompting user to upload blood report
    Given User has completed onboarding and not uploaded blood report
    When User clicks login button after entering a valid credential
    Then Message prompting user to upload blood report should be displayed

  @bloodReport
  Scenario: Upload blood report button enabled
    Given User has completed onboarding and not uploaded blood report
    When User clicks login button after entering a valid credential
    Then "Upload Blood Report" button should be enabled
    
    @subscription
  Scenario: Display today’s date
    When User clicks login button after entering a valid credential
    Then Today’s date should be displayed

  @subscription
  Scenario: Display subscription plan details
    When User clicks login button after entering a valid credential
    Then Subscription plan should be displayed
    And Subscription plan name should be "Free Plan"

  @subscription
  Scenario: Display subscription plan status
    When User clicks login button after entering a valid credential
    Then Subscription plan status should be displayed
    And Remaining days message should be shown
    

  @subscription
  Scenario: Display Upgrade to Premium button
    When User clicks login button after entering a valid credential
    Then "Upgrade to Premium" button should be displayed
    
    
    
    @currentDayCount
  Scenario: Display current day count of the cycle
    Then Current day count should be displayed
    And Displayed day count should match days since last period start date

  @progressBar
  Scenario: Progress bar represents cycle progress visually
    Then Cycle progress bar should be visible
    And Filled portion should represent the proportion of days completed in the current cycle

  @nextPeriod
  Scenario: Display next period prediction countdown
    Then Next period countdown should be displayed
    And Countdown should show "x days" until the next predicted period

  @viewFullCycle
  Scenario: Navigate to full menstrual cycle details page
    When User clicks on View Full Cycle Details button
    Then User should be redirected to the Menstrual Cycle Log page
