@Slide18
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

@plans_text
Scenario: Verify section title text for all plans 
Given User is on step11 onboarding process
When User click complete after entering required medication details
Then "<plan_name>" section title is displayed inside free plan tile
Examples:
|    plan_name  |
|  Free Plan    |
| Monthly Plan  |
| 3-Month Plan  |

@plans_text
Scenario: Verify sub text for section title
Given User is on step11 onboarding process
When User click complete after entering required medication details
Then "<sub_text>" should be displayed for section title
Examples: 
|          sub_text          |
| AI-generated 7-day meal plan |
| Unlock a full month of AI-personalized diet |
| A 90-day journey using menstrual cycle      |

@plans_text
Scenario: Verify header inside the plan section is visible
Given User is on step11 onboarding process
When User click complete after entering required medication details
Then "<header>" header text should be displayed inside the plan tile
Examples:
|  header  |
|   Free   |
|  $39.99  |
|  $99.99  |

@plans_text
Scenario: Verify sub text under header inside plan section is visible 
Given User is on step11 onboarding process
When User click complete after entering required medication details
Then "<sub_header>" sub header text should be displayed inside plan tile
Examples: 
|    sub_header    |
|  7 days access   |
|  Billed monthly  |
|  One-time payment |

@checklist
Scenario: Verify checklist for free plan tile 
Given User is on step11 onboarding process
When User click complete after entering required medication details
Then "<checklist_text>" message should be visible for free plan checklist
Examples:
|    checklist_text    |
| Cycle-based diet plan  |
| Daily workouts & yoga |
| AI tips for stress relief |
| Blood report analysis |

@checklist
Scenario: Verify checklist for monthly plan tile 
Given User is on step11 onboarding process
When User click complete after entering required medication details
Then "<checklist_text>" message should be visible for monthly plan checklist
Examples:
|            checklist_text          |
|        30-day AI diet plan         |
|       Daily workout + yoga        |
|    Community access & motivation  |
| Health tracking & progress dashboard |
|      Blood report analysis        |

@checklist
Scenario: Verify checklist for Three Month plan tile 
Given User is on step11 onboarding process
When User click complete after entering required medication details
Then "<checklist_text>" message should be visible for three month plan checklist
Examples:
|            checklist_text          |
|        AI meal & workout plans     |
|       Full access to community       |
|       Blood report analysis          |
| Milestone tracking & habit building  |
| Money-back if 10% weight not reduced |


@subscribeButton
Scenario: Verify subscribe now button visible for plan tile 
Given User is on step11 onboarding process
When User click complete after entering required medication details
Then User should be able to see subscribe now button for "<plan>" tile
Examples: 
|       plan    |
|   Free Plan   |
|  Monthly Plan |
|  3-Month Plan |

@subscribeButton
Scenario: Verify subscribe now button enabled for plan tile 
Given User is on step11 onboarding process
When User click complete after entering required medication details
Then subscribe now button for "<plan>" tile should be enabled
Examples: 
|       plan    |
|   Free Plan   |
|  Monthly Plan |
|  3-Month Plan |


