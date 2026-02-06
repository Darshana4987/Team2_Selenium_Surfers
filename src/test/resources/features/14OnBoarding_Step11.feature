Feature: Onboarding step 11 Functionality 

Background: User completes onboarding until step 10

Given User is in step eleven of onboarding

Scenario: Navigating back to step 10
  When User clicks back button in step 11
  Then Redirected to Step10
  
Scenario: Complete button functionality
  When User clicks complete button after entering any options under Medications & Supplements
  Then Should be navigated to subscription page "Choose Your Transformation Journey"

Scenario: Error Message for without selecting any options under Medications & Supplements
  When User clicks continue button without selecting any option
  Then "Please select an option" error message should be displayed for step11
  
Scenario: Radio button selection functionality
  When User clicks any options under Medications & Supplements
  Then Radio button in the selected section forn step11 for should be marked as selected