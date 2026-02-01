Feature: Menstrual Phase Log page

Background:
Given User is logged in to Herbalance app

@Buttons_visible
Scenario: Verify user can see all sections of Menstrual Log Page 
Given User is on the Her Balance Dashboard with the Activity Insights submenu expanded
When User clicks on Menstrual Phase Logs
Then User should be able to see all five sections

@Buttons_visible
Scenario: Verify all buttons are visible in the Menstrual Phase Log page 
Given User is on the Her Balance Dashboard with the Activity Insights submenu expanded
When User clicks on Menstrual Phase Logs
Then User should be able to see "<button_name>" button in the Menstrual Phase Log page
Examples:
|        button_name       |
| Update Cycle Information |
|    Back to Dashboard     | 
|      Add Period Log      |

@Buttons_visible
Scenario: Verify all tabs are visible in the Menstrual Phase Log Page
Given User is on the Her Balance Dashboard with the Activity Insights submenu expanded
When User clicks on Menstrual Phase Logs
Then User should be able to see "<Tab_name>" tab in the Menstrual Phase Log Page
Examples:
|      Tab_name       |
|  Cycle Overview     |
|  Menstrual Calendar |
|  Period History     |

@current_cycle
Scenario: Verify Current Cycyle Status section heading is displayed 
Given User is on the Her Balance Dashboard with the Activity Insights submenu expanded
When User clicks on Menstrual Phase Logs
Then User should be able to see "Current Cycyle Status" section heading

@current_cycle
Scenario: Verify current cycle progress is displayed based on onboarding data
Given User is on the Her Balance Dashboard with the Activity Insights submenu expanded
When User clicks on Menstrual Phase Logs
Then Current cycle progress should be displayed in the correct format

@current_cycle
Scenario: Verify progress bar is displayed with phase labels
Given User is on the Her Balance Dashboard with the Activity Insights submenu expanded
When User clicks on Menstrual Phase Logs
Then User should be able to see all labels below progress bar

@current_cycle
Scenario: Verify progress bar accuracy for current cycle
Given User is on the Her Balance Dashboard with the Activity Insights submenu expanded
When User clicks on Menstrual Phase Logs
Then progress bar should be filled according to the current cycle progress

@current_cycle
Scenario: Verify all labels are displayed in Current Cycle Status section
Given User is on the Her Balance Dashboard with the Activity Insights submenu expanded
When User clicks on Menstrual Phase Logs
Then User should be able to see all labels in Current Cycle Status section

@current_cycle
Scenario: Verify correct current phase is displayed based on onboarding data
Given User is on the Her Balance Dashboard with the Activity Insights submenu expanded
When User clicks on Menstrual Phase Logs
Then The phase based on the value entered during onboarding process should be displayed

@current_cycle
Scenario: Verify correct last period started is displayed based on onboarding data 
Given User is on the Her Balance Dashboard with the Activity Insights submenu expanded
When User clicks on Menstrual Phase Logs
Then Last period started date should be based on the date entered during onboarding process

@current_cycle
Scenario: Verify correct Next period expected is displayed based on onboarding data
Given User is on the Her Balance Dashboard with the Activity Insights submenu expanded
When User clicks on Menstrual Phase Logs
Then Next period expected date should be based on the date entered during onboarding process

@current_cycle
Scenario: Verify subsection heading text reflects the correct phase 
Given User is on the Her Balance Dashboard with the Activity Insights submenu expanded
When User clicks on Menstrual Phase Logs
Then Subsection heading reflects the Current Phase in the correct format  

@current_cycle
Scenario: Verify the content below subsection heading 
Given User is on the Her Balance Dashboard with the Activity Insights submenu expanded
When User clicks on Menstrual Phase Logs
Then Display content should match current phase 
