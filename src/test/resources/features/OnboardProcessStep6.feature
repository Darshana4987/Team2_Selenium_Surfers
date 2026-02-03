Feature: Onboarding step 6 Functionality and Step 7 UI verification

Background: User completes onboarding until step 5

Scenario: Error message for without selecting last menstrual date
	Given User is in step 6 of onboarding
  When User clicks continue button without selecting last menstrual date
  Then Error message "Please select your last period start date" should be displayed
  
#Scenario: Progress bar is visible in step 7
#	Given User is in step 6 of onboarding
  #When User selects last menstrual date
  #Then Progress bar shows the current step "7 of 11"
#
#Scenario: Navigating back to step 5
#	Given User is in step 6 of onboarding
  #When User clicks back button in step 6
  #Then User redirected to back Step 5
  
Scenario: Navigation to Step 7
	Given User is in step 6 of onboarding
  When User clicks continue after selecting last menstrual date
  Then User redirected to next Step 7

#Scenario: Error message for invalid value in date
#	Given User is in step 6 of onboarding
  #When User clicks continue button after entering invalid value in date
  #Then Error message "Please select your last period start date" should be displayed
 #
 
 
 
 
 
 
 
 
 
 
#Scenario: Calender display	
#	Given User is in step 6 of onboarding
  #When User selects last menstrual date
  #Then Two months (current month and next month e.g. "November 2025" and "December 2025" should be visible in the upcoming cycle section
 
#Scenario: Message for related to last perios date
#	Given User selects last menstrual date
  #When User clicks continue button after entering invalid value in date
  #Then Message "Based on your last period starting on <date>, you're currently in the [CurrentPhase]." should be visible
  #
#Scenario: Description for current phase
#	Given User is in step 6 of onboarding
  #When User selects last menstrual date
  #Then Description text about the current phase should be displayed
  #
#Scenario: 3 Section header
#	Given User is in step 6 of onboarding
  #When User selects last menstrual date
  #Then Section header "Your Cycle Timeline" , "Your Upcoming Cycle Calendar" and  "Your Next Expected Periods" should be visible
#
#Scenario: Phase details with day count
#	Given User is in step 6 of onboarding
  #When User selects last menstrual date
  #Then Current phase name with day count e.g. "Menstrual Phase (Day 3)" should be shown
  #
#Scenario: Current phase guidance
#	Given User is in step 6 of onboarding
  #When User selects last menstrual date
 #	Then Detailed phase guidance text should be visible
 #	
#Scenario: Change the last period date through calender
#	Given User has selected the last period date in the date field during Step 6 of onboarding
  #When User changes the date using the upcoming cycle calendar
 #	Then Phase displayed in the timeline should update accordingly
#
#Scenario: Presence of right and left arrow cycle calendar
#	Given User is in step 6 of onboarding
  #When User selects last menstrual date
 #	Then Calendar should have right and left arrow
 #	
#Scenario: Navigation of months using right arrow in the cycle calendar
#	Given User has selected the last period date in the date field during Step 6 of onboarding
  #When User clicks right arrow in the cycle clender
 #	Then Calendar should display the next month
 #	
#Scenario: Navigation of months using right arrow in the cycle calendar
#	Given User has selected the last period date in the date field during Step 6 of onboarding
  #When User clicks left arrow in the cycle clender
 #	Then Calendar should display the previous month
 #	
#Scenario: Legend for cycle phases is displayed correctly
#	Given User is in step 6 of onboarding
  #When  User selects last menstrual date
 #	Then "Legend should display the following phases with respective colors:
 #| Phase                   | Color Indicator |
 #| Menstrual Phase  | Red / Pink      |
 #| Ovulation Phase  | Blue            |
 #| Follicular Phase  | Light Purple    |
 #| Luteal Phase       | Lavender        |"
 
 #Scenario: Display of next expected periods
#	Given User is in step 6 of onboarding
  #When  User selects last menstrual date
 #	Then Least three future expected period dates should be listed
 
  #Scenario: Chronological order for expected periods
#	Given User is in step 6 of onboarding
  #When   User selects last menstrual date
 #	Then Dates should be displayed in chronological order

 	
 
 
 
  