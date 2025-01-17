@AllScenarios
Feature: Creating New Insurance

  @NewInsurance
  Scenario: User can able to apply new insurance
    Given User can be able to navigate to login page
    When User enters valid email and valid password
    And Clicks the login
    Then User is navigated to the dashboard
    And User is applying for a new insurance
    Then User successfully created a new insurance policy
    And User close browser
