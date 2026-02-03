Feature: Onboarding step 7 Functionality and Step 8 UI verification

Background: User completes onboarding until step 6

Scenario: Error message for without entering current weight
	Given User is in step seven of onboarding
  When User clicks continue button without entering current weight
  Then Error message "Weight is required" should be displayed for empty weight

Scenario: Error message for invalid weight
	Given User is in step seven of onboarding
  When User clicks continue button after entering invalid weight
  Then Error message "Enter a valid weight" shouldbe displayed for invalid weight
  
Scenario: Error message for without entering height
	Given User is in step seven of onboarding
  When User clicks continue button without entering height
  Then Error message "Height is required" should be displayed for empty height

Scenario: Error message for invalid height
	Given User is in step seven of onboarding
  When User clicks continue button after entering invalid height
  Then Error message "Enter a valid height" should be displayed for invalid height
  
Scenario: Weight unit dropdowns visibility
	Given User is in step seven of onboarding
  When User clicks weight(kg) dropdown
  Then weight Options "kg" and "lbs" should be displayed
  
Scenario: Height unit dropdowns visibility
	Given User is in step seven of onboarding
  When User clicks height(cm) dropdown
  Then height Options "cm" and "ft/in" should be displayed

Scenario: Presence of BMI bar 
	Given User is in step seven of onboarding
  When User enters valid height and weight
  Then BMI bar should be displayed

Scenario: Navigation to Step 8
	Given User is in step seven of onboarding
  When User enters valid height and weight
 	Then Redirected to Step8

  