Feature: Onboarding step 6 Functionality and Step 7 UI verification

Background: User completes onboarding until step 5

Scenario: Error message for without entering current weight
	Given User is in step 7 of onboarding
  When User clicks continue button without entering current weight
  Then Error message "Weight is required" should be displayed

Scenario: Error message for invalid weight
	Given User is in step 7 of onboarding
  When User clicks continue button after entering invalid weight
  Then Error message "Enter a valid weight" shouldbe displayed
  
Scenario: Error message for without entering height
	Given User is in step 7 of onboarding
  When User clicks continue button without entering height
  Then Error message "Height is required" should be displayed

Scenario: Error message for invalid height
	Given User clicks continue button after entering invalid height
  When User clicks continue button without entering height
  Then Error message "Enter a valid height" shouldbe displayed
  
Scenario: Weight unit dropdowns visibility
	Given User is in step 7 of onboarding
  When User clicks weight(kg) dropdown
  Then Options "kg" and "lbs" should be displayed
  
Scenario: Height unit dropdowns visibility
	Given User is in step 7 of onboarding
  When User clicks height(cm) dropdown
  Then Options "cm" and "ft/in" should be displayed

Scenario: Presence of BMI bar 
	Given User is in step 7 of onboarding
  When User enters valid height and weight
  Then BMI bar should be displayed

Scenario: Navigation to Step 8
	Given User clicks continue after entering valid weight and height
  When User enters valid height and weight
  Then Redirected to Step 8






 
 
 
  