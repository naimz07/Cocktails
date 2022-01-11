Feature: Delete a Glass
  AS AN Employee
  I Want to be able to delete a glass from the database
  So that it can no longer be used for a cocktail recipe

  Scenario: Successfully delete a glass from the database
    Given There is a glass in the database to be deleted
    And I have provided the glass ID
    When I submit a request to delete the glass
    Then The glass should be deleted from the database