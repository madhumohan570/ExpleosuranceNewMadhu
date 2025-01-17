@AllScenarios
Feature: Logout of Expleo Insurance

  @LogoutStep
  Scenario: Check logout is successful
    Given User can launch to the url
    When User provides valid email and password
    And Clicks the submit
    Then User is navigated to verify dashboard
    Then User can able to logout
    And User closes the browser