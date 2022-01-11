Feature: Get all Glasses
  AS AN employee
  I WANT to be able to request all the glasses in the database
  SO THAT i can see what glasses are available

  Scenario: Successfully request all glasses
    Given I have access to the database
    When I submit a request for all the glasses
    Then I should receive all the glasses in the database