@workMain
Feature: Workout Page UI verification

Background:
Given User is on login page
When The user clicks the Workout button on dashboard
Then User should navigate to Workout page

Scenario Outline: Verify Workout page elements
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
Then User clicks Generate Workout Plan button 

Scenario Outline: Verify Generated Workout Plan Section Details on Workout page
Then  User should see the section with "<elementTitle>" as "<values>"

Examples:
| elementTitle 		    | values 						|
| Header2               | Daily Workout Plan			|
| Workput Plan Phase    | Value                         |
| Workput Plan Energy   | Value                         |
| Workput Plan Focus    | Value                         |
| CycleTabs             | Cycle Day Tabs                |
| Button2               | Complete						|
| Button3               | View All Exercises 			|
| Button4               | Generate Next Work Out 		|
| Header4               | About Daily Workouts 			|


Scenario: Verify Complete button is clickable on Cycle Days phase Workout section
Then  The user clicks complete button on each Cycle Day Tabs 
And  Workout phase should be marked as Completed

@GenerateNextWorkout
Scenario: Verify Generate Next Workout button is clickable on Cycle Days phase Workout section
Then  The user clicks Generate Next Workout button
And  Next Workout should be Generated