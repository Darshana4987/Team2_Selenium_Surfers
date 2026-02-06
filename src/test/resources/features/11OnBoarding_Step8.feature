Feature: Onboarding step 8 Functionality and Step 9 UI verification

Background: User completes onboarding until step 7

Scenario: Diet options highlighted on selection
	Given User is in step eight of onboarding
  When User clicks any of the dietary options
  Then Selected diet should be highlighted
  
Scenario Outline: 4 sections visibility in step 9
  When User clicks continue after selecting any dietary options
  Then Radio "<options>" for Dietary Preferences should be visible  

 Examples:
      | options            |
      | Pescatarian Diet   |
      | Non-Vegetarian     |
      | Vegetarian Diet    |
      | Vegan Diet         |

Scenario: Presence of radio button in all sections
	Given User is in step eight of onboarding
  When User clicks continue after selecting any dietary options
  Then Radio button should be displayed in all the sections 

Scenario: Navigating back to step 7
	Given User is in step eight of onboarding
  When User clicks back button in step8
  Then Redirected to Step7 

Scenario: Navigation to Step 9
	Given User is in step eight of onboarding
  When User clicks continue after selecting any dietary options
  Then Redirected to Step9 

 
  
 