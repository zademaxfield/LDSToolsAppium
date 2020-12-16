@ClassAndQuorum
  Feature: Class and Quorum Attendance tests

    @jft
    Scenario Outline: As a leader I should have access to Class and Quorum Attendance reports
      Given a <leader> logs in and is on the Reports page
      When Class and Quorum Attendance is selected
      Then the record will be displayed
      And the attendance <can> be edited
      Examples:
      | leader                            | memberRecord              | can        |
      | "BISHOP"                          | "White, Koty Lucas"       | "true"     |
      | "BISHOPRIC_SECOND_COUNSELOR"      | "White, Koty Lucas"       | "true"     |
      | "BISHOPRIC_SECOND_COUNSELOR"      | "White, Koty Lucas"       | "true"     |
      | "WARD_CLERK"                      | "Johnson, Jasean Marvin"  | "true"     |
      | "WARD_EXECUTIVE_SECRETARY"        | "Johnson, Sophia Joeann"  | "true"     |
      | "ELDERS_QUORUM_PRESIDENT"         | "Perry, Keegan Krue"      | "true"     |
      | "ELDERS_QUORUM_FIRST_COUNSELOR"   | "White, Koty Lucas"       | "false"    |
      | "ELDERS_QUORUM_SECOND_COUNSELOR"  | "Ramon Anaya"             | "false"    |
      | "ELDERS_QUORUM_SECRETARY"         | "White, Koty Lucas"       | "false"    |
      | "RELIEF_SOCIETY_PRESIDENT"        | "White, Koty Lucas"       | "true"     |
      | "RELIEF_SOCIETY_FIRST_COUNSELOR"  | "Johnson, Jasean Marvin"  | "false"    |
      | "RELIEF_SOCIETY_SECOND_COUNSELOR" | "Johnson, Sophia Joeann"  | "false"    |
      | "YOUNG_WOMEN_PRESIDENT"           | "Perry, Keegan Krue"      | "false"    |
      | "YOUNG_WOMEN_SECOND_COUNSELOR"    | "White, Koty Lucas"       | "false"    |
      | "SUNDAY_SCHOOL_PRESIDENT"         | "White, Koty Lucas"       | "false"    |
      | "SUNDAY_SCHOOL_FIRST_COUNSELOR"   | "White, Koty Lucas"       | "false"    |
      | "WARD_MISSION_LEADER"             | "White, Koty Lucas"       | "true"     |






