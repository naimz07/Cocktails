Feature: Add a equipment
  AS AN Employee
  I WANT to be able to add a equipment to the database
  SO THAT i can use it for a cocktail recipe


  Scenario: Successfully add a equipment to the database
    Given I have added a name for the equipment
    And I have stated if the equipment needs power or not
    When I submit a request to add the equipment
    Then The equipment is saved to the database