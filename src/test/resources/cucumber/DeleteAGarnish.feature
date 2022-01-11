Feature: Delete a Garnish
  AS AN Employee
  I Want to be able to delete a garnish from the database
  So that it can no longer be used for a cocktail recipe

  Scenario: Successfully delete a garnish from the database
    Given There is a garnish in the database to be deleted
    And I have provided the garnish ID
    When I submit a request to delete the garnish
    Then The garnish should be deleted from the database