

Background:
Given User is on login pages
Scenario: Verify that user is able to navigate to Workout page from dashboard
When The user clicks the Workout button on dashboard
Then User should navigate to Workout page


  
  

  @TitleDisplayed
  Scenario: Title is displayed
    Given User is on the Her Balance Dashboard with the Edit Profile submenu expanded
    When User clicks on Edit Profile
    Then Edit your Profile should be visible

  @SubText
  Scenario: Sub text for title is displayed
    Given User is on the Her Balance Dashboard with the Edit Profile submenu expanded
    When User clicks on Edit Profile
    Then Update your personal information and preferences should be visible

  @TabCount
  Scenario: Total number of tabs
    Given User is on the Her Balance Dashboard with the Edit Profile submenu expanded
    When User clicks on Edit Profile
    Then There should be exactly 3 tabs

  @TabHeaders
  Scenario: Tabs header are displayed
    Given User is on the Her Balance Dashboard with the Edit Profile submenu expanded
    When User clicks on Edit Profile
    Then "Basic Information", "Body Metrics", "Preferences & Health" tabs should be visible

  @DefaultTab
  Scenario: Default tab
    Given User is on the Her Balance Dashboard with the Edit Profile submenu expanded
    When User clicks on Edit Profile
    Then Basic Information should be visible by default

  @BackButton
  Scenario: Back Button Presence
    Given User is on the Her Balance Dashboard with the Edit Profile submenu expanded
    When User clicks on Edit Profile
    Then Back Button should be visible
