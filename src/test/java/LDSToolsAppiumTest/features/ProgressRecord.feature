@ProgressRecord
  Feature: Progress Record tests - Used to be Missionary Progress Record


    Scenario Outline: As a leader I should have access to the New Members under Progress Record
      Given a <leader> logs in and is on the Progress Record Page
      When a <memberRecord> is selected under the New Members tab
      Then the <memberRecord> will be displayed
      And the members record <can> be edited
      Examples:
      | leader                            | memberRecord              | can        |
#      | "BISHOP"                          | "Ivey, Delores"           | "true"     |
#      | "BISHOPRIC_SECOND_COUNSELOR"      | "Ivey, Delores"           | "true"     |
#      | "BISHOPRIC_SECOND_COUNSELOR"      | "White, Koty Lucas"       | "true"     |
      | "WARD_CLERK"                      | "Johnson, Jasean Marvin"  | "true"     |
#      | "WARD_EXECUTIVE_SECRETARY"        | "Johnson, Sophia Joeann"  | "true"     |
      | "ELDERS_QUORUM_PRESIDENT"         | "Perry, Keegan Krue"      | "true"     |
#      | "ELDERS_QUORUM_FIRST_COUNSELOR"   | "White, Koty Lucas"       | "false"    |
#      | "ELDERS_QUORUM_SECOND_COUNSELOR"  | "Ramon Anaya"             | "false"    |
#      | "ELDERS_QUORUM_SECRETARY"         | "Ivey, Delores"           | "false"    |
      | "RELIEF_SOCIETY_PRESIDENT"        | "White, Koty Lucas"       | "true"     |
#      | "RELIEF_SOCIETY_FIRST_COUNSELOR"  | "Johnson, Jasean Marvin"  | "false"    |
#      | "RELIEF_SOCIETY_SECOND_COUNSELOR" | "Johnson, Sophia Joeann"  | "false"    |
#      | "YOUNG_WOMEN_PRESIDENT"           | "Perry, Keegan Krue"      | "false"    |
#      | "YOUNG_WOMEN_SECOND_COUNSELOR:    | "White, Koty Lucas"       | "false"    |
#      | "SUNDAY_SCHOOL_PRESIDENT"         | "Ivey, Delores"           | "false"    |
#      | "SUNDAY_SCHOOL_FIRST_COUNSELOR"   | "White, Koty Lucas"       | "false"    |
#      | "WARD_MISSION_LEADER"             | "Ivey, Delores"           | "true"     |

#    Bug in iOS
#    Need to changes member record and Unit
    Scenario Outline: As a leader I should have access to the New Members under Progress Record
      Given a <leader> logs in selects a <unit> and is on the Progress Record Page
      When a <memberRecord> is selected under the New Members tab
      Then the <memberRecord> will be displayed
      And the members record <can> be edited
      Examples:
        | leader                              | memberRecord              | can        | unit            |
        | "STAKE_PRESIDENT"                   | "Ivey, Delores"           | "false"    | "Auburn Hills"  |
        | "STAKE_PRESIDENT_FIRST_COUNSELOR"   | "Ivey, Delores"           | "false"    | "Auburn Hills"  |
        | "STAKE_PRESIDENT_SECOND_COUNSELOR"  | "Ivey, Delores"           | "false"    | "Auburn Hills"  |
        | "STAKE_CLERK"                       | "Ivey, Delores"           | "false"    | "Auburn Hills"  |
        | "STAKE_EXECUTIVE_SECRETARY"         | "Ivey, Delores"           | "false"    | "Auburn Hills"  |


    @jft
    Scenario Outline: As a leader I should have access to the People Being Taught under Progress Record
      Given a <leader> logs in and is on the Progress Record Page
      When a <memberRecord> is selected under the People Being Taught tab
      Then the <memberRecord> for People Being Taught will be displayed
      And the members record for People Being Taught <can> be edited

      Examples:
        | leader                            | memberRecord              | can        |
        | "BISHOP"                          | "Doramus, Barbara"        | "true"     |
#        | BISHOPRIC_SECOND_COUNSELOR      | Joe User        | true     |
#        | BISHOPRIC_SECOND_COUNSELOR      | Joe User        | true     |
#        | WARD_CLERK                      | Joe User        | true     |
#        | WARD_ASSISTANT_CLERK            | Joe User        | true     |
#        | WARD_EXECUTIVE_SECRETARY        | Joe User        | true     |
#        | ELDERS_QUORUM_PRESIDENT         | Joe User        | true     |
#        | ELDERS_QUORUM_FIRST_COUNSELOR   | Joe User        | false    |
#        | ELDERS_QUORUM_SECOND_COUNSELOR  | Joe User        | false    |
#        | ELDERS_QUORUM_SECRETARY         | Joe User        | false    |
#        | RELIEF_SOCIETY_PRESIDENT        | Joe User        | true     |
#        | RELIEF_SOCIETY_FIRST_COUNSELOR  | Joe User        | false    |
#        | RELIEF_SOCIETY_SECOND_COUNSELOR | Joe User        | false    |
#        | YOUNG_WOMEN_PRESIDENT           | Joe User        | false    |
#        | YOUNG_WOMEN_SECOND_COUNSELOR    | Joe User        | false    |
#        | SUNDAY_SCHOOL_FIRST_COUNSELOR   | Joe User        | false    |
#        | WARD_MISSION_LEADER             | Joe User        | true     |
#        | WARD_MISSION_LEADER             | Joe User        | true     |
#        | STAKE_PRESIDENT                 | Joe User        | false    |
#        | STAKE_PRESIDENT_FIRST_COUNSELOR | Joe User        | false    |
#        | STAKE_PRESIDENT_SECOND_COUNSELOR| Joe User        | false    |
#        | STAKE_CLERK                     | Joe User        | false    |
#        | STAKE_ASSISTANT_CLERK           | Joe User        | true     |
#        | STAKE_EXECUTIVE_SECRETARY       | Joe User        | true     |
#
#  #  Check from Member Record page and check from details?
#    Scenario: As a leader edit the Sacrament Meeting Attendance for a member record
#      Given a leader has a member record open
#      When a blank Sacrament Meeting Attendance date is selected
#      Then the date should be checked
#      And a checked Sacrament Meeting Attendance date is selected
#      Then the date should be cleared
#
#    Scenario: As a leadership calling check the quick card for New Members
#      Given a leader is on the Progress Record page
#      When the New Members tab is selected
#      Then the members quick card information should be displayed
#
#    Scenario: As a leadership calling check the quick card for People Being Taught
#      Given a leader is on the Progress Record page
#      When the People Being Taught tab is selected
#      Then the members quick card information should be displayed
#
#    Scenario: As a leader edit the Lesson Progression - Principles Taught same thing?
#      Given a leader is on the Progress Record page
#      When a member is selected
#      Then then the edit button for Lesson Progression should be diplayed
#      And when a lesson is selected
#      Then the lesson box should turn green
#
#  #    Should this check all the edit buttons?
#      #****** not in JIRA yet **********
#    Scenario: As a ward council view only Lesson Progression
#      Given a ward council member is on the Progress Record page
#      When a member is selected
#      Then the edit button should not be displayed
#
#    Scenario: Friends in the Church in Stake
#      Given a ward council member is on the Progress Record page
#      When a member is selected
#      And a friend from the stake is added to the member
#      Then the friend should be displayed
#
#    Scenario: Friends in the Church outside of Stake
#      Given a ward council member is on the Progress Record page
#      When a member is selected
#      And a friend from outside of the stake is added to the member
#      Then the friend should be displayed

#    Scenario: Priesthood Ordinations
#    Scenario: Calling
#    Scenario: Ministering Assignments
#    Scenario: Ministering Brothers Sisters?
#    Scenario: Prepare a Family name for the Temple
#    Scenario: Baptisms for Deceased Ancestor
#    Scenario: Temple Ordinances
#    Scenario: Self-Reliance Class
#    Scenario: Filter?
#    Scenario: Alerts? # This might need to be a feature file on its own.
#    Scenario: API tests
#    Scenario: Get to the members Progress Record from the Directory
#    Scenario: Login as progress record member check My Covenant Path

#    Scenario: Check callings that should not have access to Progress record






