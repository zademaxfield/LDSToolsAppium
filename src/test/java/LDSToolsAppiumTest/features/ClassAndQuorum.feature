@ClassAndQuorum
  Feature: Class and Quorum Attendance tests

    @jft
    Scenario Outline: As a leader I should have access to Class and Quorum Attendance reports
      Given a <leader> logs in and is on the Class and Quorum Attendance page
      When a <memberRecord> is searched for
      Then the class and quorum attendance <memberRecord> will be displayed
      And the attendance <can> be edited
      Examples:
      | leader                            | memberRecord                | can        |
      | "BISHOP"                          | "Bryson, David"             | "true"     |
      | "BISHOPRIC_SECOND_COUNSELOR"      | "Bryson, David"             | "true"     |
      | "BISHOPRIC_SECOND_COUNSELOR"      | "Bryson, David"             | "true"     |
      | "WARD_CLERK"                      | "Bryson, David"             | "true"     |
      | "WARD_EXECUTIVE_SECRETARY"        | "Bryson, David"             | "true"     |
      | "ELDERS_QUORUM_PRESIDENT"         | "Bryson, David"             | "true"     |
      | "ELDERS_QUORUM_FIRST_COUNSELOR"   | "Bryson, David"             | "true"     |
      | "ELDERS_QUORUM_SECOND_COUNSELOR"  | "Bryson, David"             | "true"     |
      | "ELDERS_QUORUM_SECRETARY"         | "Bryson, David"             | "true"     |
      | "RELIEF_SOCIETY_PRESIDENT"        | "Bryson, David"             | "true"     |
      | "RELIEF_SOCIETY_FIRST_COUNSELOR"  | "Bryson, David"             | "true"     |
      | "RELIEF_SOCIETY_SECOND_COUNSELOR" | "Bryson, David"             | "true"     |
      | "YOUNG_WOMEN_PRESIDENT"           | "Bryson, David"             | "true"     |
      | "YOUNG_WOMEN_SECOND_COUNSELOR"    | "Bryson, David"             | "true"     |
      | "SUNDAY_SCHOOL_PRESIDENT"         | "Bryson, David"             | "true"     |
      | "SUNDAY_SCHOOL_FIRST_COUNSELOR"   | "Bryson, David"             | "true"     |
      | "WARD_MISSION_LEADER"             | "Bryson, David"             | "true"     |



#    Scenario: Check edit rights in the API
#    Scenario: As a leader I should be able to mark a members attendance
#    Scenario: Filters?
