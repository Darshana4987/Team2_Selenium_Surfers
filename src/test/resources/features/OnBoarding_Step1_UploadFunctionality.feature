@OnBoarding @Step1 @Regression
Feature: Onboarding Step 1 Blood Report Upload Functionality

  Background:
    Given User is in upload blood report page

  Scenario: Supported only PDF file types
    When User clicks on Upload PDF button by selecting invalid file upload
    Then User should see Only PDF files are supported error

  Scenario: file size limit (10MB)
    When User clicks on Upload PDF button by selecting file over 10MB
    Then User should see File exceeds 10MB error

  Scenario: Valid PDF file upload
    When User clicks on Upload PDF button by selecting valid file
    Then Upload should see processing percentage bar

  Scenario: Upload pdf processes the file
    When User clicks on Upload PDF button by selecting valid file
    Then User should see Report analysis

  Scenario Outline: Fields on report analysis
    When User clicks on Upload PDF button by selecting valid file
    Then User should see Analyzing your blood work report
