Feature: Acitvity Insights Weight Tracking page 

Background:
Given The User logged in to Her balance application and is on dashboard
When The user clicks on Activity Insights button on dashboard
Then The user clicks Track Weight option from dropdown

Scenario: Verify that user is able to navigate to Subscription page from dashboard profile button dropdown
Then The user navigates to Weight Tracking page

Scenario: Verify Weight Tracking page elements
Then The User should see Weight Tracking page "<element>" element as "<value>" value

Examples:
| element 		| value 							|
| Header1   	| Weight Tracking           		|
| Paragraph1 	| Free Plan - 7 Days Tracking 		|
#| Button		| Back to Dashboard 				|
#| Card1			| Starting Weight					|
#| Card2			| Current Weight					|
#| Card3			| Goal Weight						|
#| Heading1		| Progress Overview 				|
#| Paragraph2	| Weight Lost						|
#| Paragraph3	| Remaining							|
#| Heading2		| Weight Progression Over Time		|
#| Heading3		| Log Today's Weight				|

Scenario: Verify new tracking record appears after valid/invalid entry in logging weight
Then The user clicks Log Weight button after entering weight "<weight>", Display "<message>" message
Then Entered weight "<value>" should be added to the Current Weight card"

Example:
| weight	 	| message 					 |
| 60		 	| Weight Logged Successfully |
| 10000007		| Error						 |

#Scenario: Verify Graph updates after weight entry
#Given The user is on Weight Tracking page
#When The user clicks Log Weight button after entering valid value "value" in Weight
#Then The user should see Weight Progression Over Time graph should plot the new value for that day






