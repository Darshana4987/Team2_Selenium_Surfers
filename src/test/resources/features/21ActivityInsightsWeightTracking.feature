@Activity
Feature: Acitvity Insights Weight Tracking page 

Background:
Given The User logged in to Her balance application and is on dashboard
#Scenario: Verify that user is able to navigate to Weight Tracking page from dashboard
When The user clicks on Activity Insights button on dashboard
Then The user clicks Track Weight option from dropdown
Then The user sees the Weight Tracking page

Scenario: Verify Weight Tracking page elements
Then The User should see Weight Tracking page "<element>" element as "<value>" value

Examples:
| element 		| value 							|
| Header1   	| Weight Tracking           		|
| Paragraph1 	| Free Plan - 7 Days Tracking 		|
#| Button		| Back to Dashboard 				|
| Card1	 		| Starting Weight					|
| Card2			| Current Weight					|
| Card3			| Goal Weight						|
| Heading1		| Progress Overview 				|
| Paragraph2	| Weight Loss Progress				|
| Paragraph3	| Weight Lost						|
| Paragraph4	| Remaining					|
| Heading2		| Weight Progression Over Time		|
#| Heading3		| Log Today's Weight				|

@activity3
Scenario: Verify new tracking record appears after valid/invalid entry in logging weight
Then The user clicks Log Weight button after entering weight "<weight>", expect "<message>" message
And  Entered weight "<weight>" should be added to the Current Weight card

Examples:
| weight	 	| message 					 |
| 60		 	| Success                    |
| 10000007		| Error						 |

@activity4
Scenario: Verify Back to Dashboard button
Then User clicks Back to Dashboard button
And It should display Dashboard page






