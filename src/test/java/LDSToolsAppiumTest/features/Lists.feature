@Lists
  Feature: Test the Lists functionality of Member Tools

    @jft
    Scenario: As a user I want to create a list and add members to the list
      Given a user is logged in and on the Lists page
      When I add a New List
      And I add members to the list
      Then the New List with the members should be displayed.


