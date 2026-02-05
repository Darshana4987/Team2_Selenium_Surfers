@work
Feature: Workout Page verification

Background:
Given User logged in to Her balance application
Scenario: Verify that user is able to navigate to Workout page from dashboard
When The user clicks the Workout button on dashboard
Then User should navigate to Workout page

Scenario Outline: Verify Workout page elements
When The user clicks the Workout button on dashboard
Then User should see page "<element>" as "<value>"

Examples:
| element            | value 					   									 |
| Header1            | Daily Personalized Workouts 							    	 | 
| Link 				 | Back to Dashboard 		   									 |
| Header2            | Daily Workout Plan   	   									 |
| Paragraph          | Fresh AI-powered workout tailored to your current cycle phase |
| Header3            | No workout plan found										 |
| Button             | Generate Workout Plan										 |

@GeneratePlan
Scenario: Verify Generate Workout Plan button is clickable on Workout page
When The user clicks the Workout button on dashboard
Then User clicks Generate Workout Plan button 

Scenario Outline: Verify Generated Workout Plan Section Details on Workout page
When The user clicks the Workout button on dashboard
And User should see the section with "<elementTitle>" as "<values>"

Examples:
| elementTitle 		 | values 							|
| Header2            | Daily Workout Plan				|
| Button1			 | Cycle Day 						|
| Header3            | Cycle Day luteal Phase Workout   |
| Button2            | Complete							|
| Button3            | View All Exercises 				|
| Button4            | Generate Next Work Out 			|
| Header4            | About Daily Workouts 			|

Scenario: Verify Complete button is clickable on Cycle Days phase Workout section
When The user clicks the Complete button on dashboard
Then User clicks on Generating Next Work Out button



