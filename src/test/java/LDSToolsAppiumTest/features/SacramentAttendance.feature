@SacramentAttendance
  Feature: Sacrament Meeting Attendance
    As a Bishopric member
    I want to enter in and view Sacrament Attendance
    As a Ward Council member
    Sacrament Attendance should not be displayed

    @smoke
    Scenario: As a Bishop enter a number and have it saved
      Given a "BISHOP" is on the Sacrament Attendance page
      When "159" is entered in the "First Date Field"
      Then I should see "159"

    @jft
    Scenario: As a Ward Clerk enter a number and have it saved
      Given a "WARD_CLERK" is on the Sacrament Attendance page
      When "77" is entered in the "First Date Field"
      Then I should see "77"
