@SacramentAttendance
  Feature: Sacrament Meeting Attendance
    As a Bishopric member
    I want to enter in and view Sacrament Attendance
    As a Ward Council member
    Sacrament Attendance should not be displayed

    @smoke
    Scenario: Sacrament Attendance simple test
      Given a "bishop" is on the Sacrament Attendance page
      When "159" is entered in the "First Date Field"
      Then I should see "159"
