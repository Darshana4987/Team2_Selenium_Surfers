@Subscription
Feature: Subcription Management page verification

Background:
Given User logged in to Her balance application and is on dashboard
@Subs1
Scenario: Verify that user is able to navigate to Subscription page from dashboard profile button dropdown
When The user clicks on profile button on dashboard
Then The user clicks Subscription option from the profile dropdown
And The user navigates to Subscription page

@Subs
Scenario Outline: Verify Subscription page elements
When The user clicks on profile button on dashboard
Then The user clicks Subscription option from the profile dropdown
Then The User should see Subscription page "<Subselement>" element as "<Subsvalue>" value

Examples:
| Subselement       | Subsvalue 					   		 |
| Heading1          | Subscription Management				 |
| Heading2 			| Subscription History		  			 |
| Paragraph1        | Your active subscription plan details	 |
| Heading3			| Subscription Information 				 |
| Headerfield1		| Status:								 |
| Headerfield2		| Plan:									 |
| Headerfield3		| Start Date:							 |
| Headerfield4		| End Date:								 |
| Heading4			| Subscription Benefits 				 |
| Button1Subs 		| Go To Dashboard						 |
| Button2Hist		| Go To Dashboard					  	 |
| ButtonPlans       | View Available Plans				  	 |
#| Paragraph2		| Your subscription payment history		 |
#| Heading6			| Free Plan								 |


