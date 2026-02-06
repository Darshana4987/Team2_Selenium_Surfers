Feature: Onboarding step 10 Functionality and Step 11 UI verification

Background: User completes onboarding until step 9

Given User is in step ten of onboarding

Scenario: Navigation to Step 11
  When User clicks continue after selecting any options under Food Allergies & Sensitivities
  Then Redirected to Step11
  
Scenario Outline: Sections title text in step 11
  When User clicks continue after selecting any options under Food Allergies & Sensitivities
  Then Following radio button "<options>" should be visible for step11

    Examples:
      | options                                           |
      | Yes, I take prescription medications              |
      | Yes, I take supplements                           |
      | Yes, I take both                                  |
      | No, I don’t take any medications or supplements   |

 Scenario: Navigating back to step 9
  When User clicks back button in step 10
  Then Redirected to Step9
  
 Scenario: Title for Step 11
  When User clicks continue after selecting any options under Food Allergies & Sensitivities
  Then "Medications & Supplements" title should be displayed for step11
  
 Scenario: Description text for step 11
  When User clicks continue after selecting any options under Food Allergies & Sensitivities
  Then "Do you currently take any medications or supplements?" description for step11 should be displayed.
 
  