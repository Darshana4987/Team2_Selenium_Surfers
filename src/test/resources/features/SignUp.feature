Feature: Sign Up functionality on auth page

@tag1
Scenario: EmailId input field presence
Given User is on the herbalance launch page
When User clicks the Sign up button
Then The email ID input field with place value "you@example.com" is displayed

@tag2
Scenario: Password field presence
Given User is on the herbalance launch page 
When User clicks the Sign up button 
Then The password input field with masked value should be visible  

@tag3
Scenario: Confirm Password field presence
Given User is on the herbalance launch page 
When User clicks the Sign up button 
Then The confirm password input field with masked value should be visible  

@tag4
Scenario: successful registration with valid username and password
Given User is on the her balance auth page
When User enters valid username,password, confirm password and clicks register button
Then user should be landed on the onboarding step page