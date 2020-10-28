@MultipleUnits
  Feature: Test the multiple units for tools - large number of units and change the max units

    @jft
    Scenario: As a user with a large number of units have the units displayed
      Given a member logs in and is on the Directory page
      When the unit selector is pressed
      Then the units should be displayed


