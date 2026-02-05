

Feature: Onboarding step 6 Functionality and Step 7 UI verification


Background: User completes onboarding until step 5

Scenario: Error message for without selecting last menstrual date
	Given User is in step six of onboarding
  When User clicks continue button without selecting last menstrual date
  Then Error message "Please select your last period start date" should be displayed for Step6
  
Scenario: Progress bar is visible in step 6
	Given User is in step six of onboarding
  When User clicks continue after selecting last menstrual date
  Then Progress bar shows the current step "6 of 11"
  
Scenario: Error message for invalid value in date
	Given User is in step six of onboarding
  When User clicks continue button after entering invalid value in date
  Then Error message "Please select your last period start date" should be displayed invalid value in date
   
Scenario: Navigating back to step 5
	Given User is in step six of onboarding
  When User clicks back button in step 6
  Then User redirected to back Step 5
  
Scenario: Navigation to Step 7
	Given User is in step six of onboarding
  When User clicks continue after selecting last menstrual date
  Then User redirected to next Step7

 
 
 
 
 
 
 
 
 
 
