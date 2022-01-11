Feature: Update a glass
  As AN Employee
  I WANt to be able to update a glass in the database
  SO THAT cocktails recipes can be edited

  Scenario: Successfully update a glass
    Given There is a glass to be updated
    And I have provided an updates name and volume
    When I submit a request to update the glass
    Then The glass should be updated

