Feature: Login Functionality on HerBallance Auth page
 		 As a user
         I want to login with valid credentials
          
#Background: User clicked the login button on the auth page

Scenario:
Successful login with valid username and password

Given User is on the HerBalance auth page
When User clicks the login button after entering valid username and password
Then user should be redirected to the dashboard
