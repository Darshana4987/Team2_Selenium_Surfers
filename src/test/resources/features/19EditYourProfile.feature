@editprofile
Feature:  Edit profile page

Background:
Given User is logged in to Herbalance app Page
# Background:
# Given User is on the HerBalance auth page
# When User clicks the login button after entering valid username and password
# Then user should be redirected to the dashboard

  #Ui Verification Non functional Profile - Edit Your Profile UI verification
  @editPPage
 Scenario: Verify Edit your Profile should be visible "Edit Your Profile"
  Given User is on the Her Balance Dashboard with the Edit Profile submenu expanded
  When User clicks on Edit Profile
  Then Edit your Profile should be visible "Edit Your Profile"
  @editPageUI
  Scenario: Verify Edit Profile sub-header should be visible on Edit your profile page
  Given User is on the Her Balance Dashboard with the Edit Profile submenu expanded
  When User clicks on Edit Profile
  Then Edit Profile sub-header should have text "Update your personal information and preferences"
  @editPageUI
  Scenario: Verify Edit Profile page has exactly 3 tabs
    Given User is on the Her Balance Dashboard with the Edit Profile submenu expanded
    When User clicks on Edit Profile
    Then There should be exactly 3 tabs on the Edit Profile page
 @editPageUI
 Scenario: Verify Edit Profile page tabs and their labels
  Given User is on the Her Balance Dashboard with the Edit Profile submenu expanded
  When User clicks on Edit Profile
  Then The following tabs should be visible on the Edit Profile page
    | Basic Information    |
    | Body Metrics         |
    | Preferences & Health |
  @editPageUI
  Scenario: Verify Basic Information tab should be visible and active by default on Edit Profile page
  Given User is on the Her Balance Dashboard with the Edit Profile submenu expanded
  When User clicks on Edit Profile
  Then The "Basic Information" tab should be visible and active by default
  @editPageUI
  Scenario: Verify Back Button should be visible on the Edit Profile page
  Given User is on the Her Balance Dashboard with the Edit Profile submenu expanded
  When User clicks on Edit Profile
  Then The Back Button should be visible

  #Ui Verification Non functional Profile -  Edit Your Profile-Basic Information -UI verifications
@editpageUI_basicinfo
Scenario: Verify Header text inside Basic Information section
  Given User is on the Her Balance Dashboard with the Edit Profile submenu expanded
  When User clicks on Edit Profile
  Then "Basic Information" should be visible inside section
@editpageUI_basicinfo
 Scenario: Verify sub text inside Basic Information section
  Given User is on the Her Balance Dashboard with the Edit Profile submenu expanded
  When User clicks on Edit Profile
  Then "Update your name and age" sub text should be visible