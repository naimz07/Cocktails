Feature: Add a glass
    AS AN Employee
    I WANT to be able to add a glass to the database
    SO THAT i can use it for a cocktail recipe


    Scenario: Successfully add a glass to the database
        Given I have added a name for the glass
        And I have added the volume of the glass
        When I add the glass
        Then The glass should be stored