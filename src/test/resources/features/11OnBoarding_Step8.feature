Feature: Onboarding step 8 Functionality and Step 9 UI verification

Background: User completes onboarding until step 7

Scenario: 4 Radio options for Dietary Preferences visibility in step 9
  Given User is in step eight of onboarding
  When User clicks continue after selecting any dietary options
  Then 4 Radio options for Dietary Preferences should be visible  
  
Scenario: Navigating back to step 7
	Given User is in step eight of onboarding
  When User clicks back button in step7
  Then Redirected to Step7 

Scenario: Navigation to Step 9
	Given User is in step eight of onboarding
  When User clicks continue after selecting any dietary options
  Then Redirected to Step9 

Scenario: Title for Step 9
	Given User is in step eight of onboarding
  When User clicks continue after selecting any dietary options
  Then "Physical Activity Level" should be displayed for step9

Scenario: Description text for step 9
	Given User is in step eight of onboarding
  When User clicks continue after selecting any dietary options
  Then "Help us understand your current exercise routine to design an appropriate fitness plan." for step9

Scenario: Presence of info note in step 9
	Given User is in step eight of onboarding
  When User clicks continue after selecting any dietary options
  Then "Your activity level helps us design a fitness plan that's both effective and manageable." Info should be displayed for step9

 