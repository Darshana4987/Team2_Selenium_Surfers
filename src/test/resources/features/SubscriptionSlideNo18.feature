Feature: Subscription Slide No18 Testing

Background:
Given User completes onboarding process until step10

@header
Scenario: Verify onboarding subscription page title 
Given User is on step11 onboarding process
When User click complete after entering required medication details
Then Choose Your Transformation Journey header is visible

@header
Scenario: Verify subtext header is visible 
Given User is on step11 onboarding process
When User click complete after entering required medication details
Then All Plans subtext header is visible to the user

@header
Scenario: Verify total number of sections visible
Given User is on step11 onboarding process
When User click complete after entering required medication details
Then User should see three subscription plan tiles