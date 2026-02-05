 
Feature: Workout Page UI verification

Background:
Given User is on login page
@worklogin
Scenario: Verify that user is able to navigate to Workout page from dashboard
When The user clicks the Workout button on dashboard
Then User should navigate to Workout page

@work1
Scenario Outline: Verify Workout page elements
When The user clicks the Workout button on dashboard
Then User should see page "<element>" as "<value>"

Examples:
| element 			 | value 					   									 |
| header 			 | Daily Personalized Workouts 									 | 
| link 				 | Back to Dashboard 		   									 |
| headerDailyWorkout | Daily Workout Plan   	   									 |
| paragraphFreshAI   | Fresh AI-powered workout tailored to your current cycle phase |
| noworkoutPlan		 | No workout plan found										 |

@work2
Scenario: Verify Generate Workout Plan button is clickable on Workout page
When The user clicks the Workout button on dashboard
Then User clicks Generate Workout Plan button 
And User should see the section with "<elementTitle>" as "<values>"

Examples:
| elementTitle 		 | values 							|
| headerWorkoutPlan  | Daily Workout Plan				|
| button			 | Cycle Day 						|
| heading			 | Cycle Day luteal Phase Workout   |
| completeButton	 | Complete							|
| viewButton		 | View All Exercises 				|
| nextWorkoutButton	 | Generate Next Work Out 			|
| dailyWorkout		 | About Daily Workouts 			|

#Scenario: Verify Complete button is clickable on Cycle Days phase Workout section
#When The user clicks the Complete button on dashboard






