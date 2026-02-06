Feature: Onboarding step 9 Functionality and Step 10 UI verification

Background: User completes onboarding until step 8

Scenario: Continue button behavior upon activity level selection
	Given User is in step nine of onboarding
  When User clicks any of the activity level
  Then Continue button should be enabled
    
Scenario Outline: 4 sections visibility in step 10
  When User clicks continue after selecting any activity level
  Then Radio "<options>" activity level should be visible  

Examples:
      | options             |
      | Sedentary   				|
      | Lightly Active      |
      | Moderately Active   |
      | Very Active         |

Scenario: Presence of radio button in all sections
	Given User is in step nine of onboarding
  When User clicks continue after selecting any activity level
  Then Radio button should be displayed in all the sections for activity level
 
Scenario: Navigating back to step 8
	Given User is in step nine of onboarding
  When User clicks back button in step 9
  Then Redirected to Step8
  
Scenario: Navigation to Step 10
	Given User is in step nine of onboarding
  When User clicks continue after selecting any activity level
  Then Redirected to Step10



  