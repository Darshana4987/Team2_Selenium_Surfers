Feature: Subscription Slide No18 Testing

Background:
Given User completes onboarding process until step10

Scenario: Verify onboarding subscription page title 
Given User is on step11 onboarding process
When User click complete after entering required medication details
Then Choose Your Transformation Journey header is visible