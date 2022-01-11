Feature: Add a garnish
  AS AN Employee
  I WANT to be able to add a garnish to the database
  SO THAT i can use it for a cocktail recipe


  Scenario: Successfully add a garnish to the database
    Given I have added a name for the garnish
    And I have stated if the garnish is food or not
    When I submit a request to add the garnish
    Then The garnish is saved to the database