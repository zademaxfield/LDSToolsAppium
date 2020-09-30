@Lists
  Feature: Test the Lists functionality of Member Tools

    @jft
    Scenario: As a user I want to create a list and add members to the list
      Given a user is logged in and on the Lists page
      When I add a List "New Automated List"
      And I add members to the list
      Then the "New Automated List" with the members should be displayed.


    Scenario: As a user I want to create a list and add multiple members
      Given  a user is logged in and on the Lists page
      When I add a List "Test List 1"
      And I add six members to the list
      Then the "Test List 1" six members should be displayed on the list


