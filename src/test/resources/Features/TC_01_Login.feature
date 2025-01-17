@AllScenarios
Feature: Expleo Insurance Demo

  @LoginStep
  Scenario: Check login is successful with correct credentials
    Given User is in login page
    When User enters valid email and password
    And Clicks login
    Then User is navigated to dashboard
    And Close the browser



