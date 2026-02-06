@Subscription @Regression
Feature: Subcription Management page verification

Background:
Given User logged in to Her balance application and is on dashboard
When The user clicks on profile button on dashboard
Then The user clicks Subscription option from the profile dropdown
And The user navigates to Subscription page

@Sub1
Scenario Outline: Verify Subscription page elements
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
| Paragraph2		| Your subscription payment history		 |
| Heading6			| Free Plan								 |

@Sub2
Scenario: Verify Go To Dashboard Button in Current Subscription section
Then User Click on Go To Dashboard Button in Current Subscription section
And The User should see Dashboard page

@Sub3
Scenario: Verify Go To Dashboard Button in Subscription History section
Then User Click on Go To Dashboard Button in Subscription History section
And The User should see Dashboard page

@Sub4
Scenario: Verify Available Plans Button
Then User Click on View Available Plans Button
And The User should see All Plans page