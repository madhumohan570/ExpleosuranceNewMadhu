@AllScenarios
Feature: Expleo Insurance Support

  @SupportPage
  Scenario: Support Page
    Given User can navigate to url for login 
    When User provides valid email and valid password
    And Clicks submit for login
    Then User is navigated to verify the dashboard page is displayed
    And User can able to get support
    And Quit the browser
    



