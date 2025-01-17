@AllScenarios
Feature: Quote Generation

  @QuoteGeneration
  Scenario: Check quote generation is successful
    Given User is navigated to url
    When User enters valid emailid and valid password
    And Clicks submit button to login 
    Then User is navigated to the dashboard page
    And User can able to generate the quote
    Then User verifies the generated quote price
    And Close browsers
