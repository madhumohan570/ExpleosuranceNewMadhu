@AllScenarios
Feature: Claims Management Page

  @ClaimsManagement
  Scenario: Claim management
    Given User can able to navigate to the url
    When User enters valid email address and password
    And Clicks submit button
    Then User is verifying the dashboard page
    And User is navigating to claims management page
    Then User views the claim list
    And User close the browser
