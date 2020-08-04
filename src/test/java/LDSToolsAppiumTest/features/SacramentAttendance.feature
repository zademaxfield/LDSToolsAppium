@SacramentAttendance
  Feature: Sacrament Meeting Attendance
    As a Bishopric member
    I want to enter in and view Sacrament Attendance
    As a Ward Council member
    Sacrament Attendance should not be displayed

    @all @smoke
    Scenario: As a Bishop enter a number and have it saved
      Given a "BISHOP" is on the Sacrament Attendance page
      When "159" is entered in the "First Date Field"
      Then I should see "159" in the "First Date Field"

    @all
    Scenario: As a Ward Clerk enter a number and have it saved
      Given a "WARD_CLERK" is on the Sacrament Attendance page
      When "77" is entered in the "Second Date Field"
      Then I should see "77" in the "Second Date Field"

    @all
    Scenario: A Ward Council member should not see Sacrament Attendance
      Given a "ELDERS_QUORUM_PRESIDENT" is on the Reports page
      Then I should not see "Sacrament Attendance"


    @all @jft
    Scenario: Enter Sacrament Attendance using the counter
      Given a "WARD_CLERK" is on the Sacrament Attendance page
      When a "25" is entered using the counter
      Then I should see "25"


