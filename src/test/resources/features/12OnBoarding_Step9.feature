Feature: Onboarding step 9 Functionality and Step 10 UI verification

Background: User completes onboarding until step 8

Scenario: Continue button behavior upon activity level selection
	Given User is in step nine of onboarding
  When User clicks any of the activity level
  Then Continue button should be enabled
    
Scenario: 4 sections visibility in step 9
	Given User is in step nine of onboarding
  When User clicks any of the activity level
  Then 4 Radio options activity level should be visible  

Scenario: Navigating back to step 8
	Given User is in step nine of onboarding
  When User clicks back button in step 9
  Then Redirected to Step8
  
Scenario: Navigation to Step 10
	Given User is in step nine of onboarding
  When User clicks continue after selecting any activity level
  Then Redirected to Step10

Scenario: Progress bar is visible in step 10
	Given User is in step nine of onboarding
  When User clicks continue after selecting any activity level
  Then Progress bar shows the current step as  "10 of 11"

Scenario: Title for Step 10
	Given User is in step nine of onboarding
  When User clicks continue after selecting any activity level
  Then "Food Allergies & Sensitivities" should be displayed
 
Scenario: Description text for step 10
	Given User is in step nine of onboarding
  When User clicks continue after selecting any activity level
  Then "Do you have any food allergies or intolerances?" description for step10


  