Feature: login
  Scenario: Successful login
    Given homepage
    When input valid credentials
    And click login button
    Then user move to homepage

