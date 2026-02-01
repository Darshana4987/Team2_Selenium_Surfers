Feature: Workout Page UI verification

Background:
Given User is on login page
Scenario: Verify that user is able to navigate to Workout page from dashboard
When The user clicks the Workout button on dashboard
Then User should navigate to Workout page

Scenario Outline: Verify Workout page elements
When The user clicks the Workout button on dashboard
Then User should see page "<element>" as "<value>"

Examples:
| element | value |
| header | Daily Personalized Workouts | 
| link | Back to Dashboard |
#| Daily Workout Plan |
#| Fresh AI-powered workout tailored to your current cycle phase |

#Scenario: Verify presence of "Back to Dashboard" text on the Workout page
#Then User should see the link Back to dashboard

#Scenario: Verify the presence of Daily Workout Plan section 
#Then User should see the Daily Workout Plan section

#Scenario: Verify the description under daily workout plan section
#Then User should see the description as "Fresh AI-powered workout tailored to your current cycle phase" 



