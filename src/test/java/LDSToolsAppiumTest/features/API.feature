@API
  Feature: API tests

    @jft
    Scenario Outline: Check the status code for the API
      Given a <member> goes to the <url>
      Then the status should be <status>
      Examples:
        | member    | url                   | status    |
        | "BISHOP"  | "user"                | "Success" |
        | "BISHOP"  | "units"               | "Success" |
        | "BISHOP"  | "reports?units=21628" | "Success" |
        | "BISHOP"  | "subscriptions"       | "Success" |
        | "BISHOP"  | "reports/access"      | "Success" |
        | "BISHOP"  | "referrals"           | "Success" |
        | "BISHOP"  | "temples"             | "Success" |
        | "BISHOP"  | "finances/accounts"   | "Success" |
        | "MEMBER1" | "user"                | "Success" |
        | "MEMBER1" | "units"               | "Success" |
        | "MEMBER1" | "reports?units=21628" | "Error"   |
        | "MEMBER1" | "subscriptions"       | "Success" |
        | "MEMBER1" | "reports/access"      | "Success" |
        | "MEMBER1" | "referrals"           | "Success" |
        | "MEMBER1" | "temples"             | "Success" |
        | "MEMBER1" | "finances/accounts"   | "Success" |


    #    @MQA-3518 @all @smoke @all1 @daily @daily2
    @jft
    Scenario Outline: Check edit rights in the API for Class and Quorum Attendance
      Given a <member> account checks the Class and Quorum Attendance right
      Then the Class and Quorum editable field is <status>
      Examples:
        | member                            | status  |
        | "BISHOP"                          | "true"  |
        | "BISHOPRIC_SECOND_COUNSELOR"      | "true"  |
        | "BISHOPRIC_SECOND_COUNSELOR"      | "true"  |
        | "WARD_CLERK"                      | "true"  |
        | "WARD_EXECUTIVE_SECRETARY"        | "true"  |
        | "ELDERS_QUORUM_PRESIDENT"         | "true"  |
#        | "ELDERS_QUORUM_FIRST_COUNSELOR"   | "true"     |
        | "ELDERS_QUORUM_SECOND_COUNSELOR"  | "true"  |
        | "ELDERS_QUORUM_SECRETARY"         | "true"  |
        | "RELIEF_SOCIETY_PRESIDENT"        | "true"  |
#        | "RELIEF_SOCIETY_FIRST_COUNSELOR"  | "true"     |
        | "RELIEF_SOCIETY_SECOND_COUNSELOR" | "true"  |
        | "YOUNG_WOMEN_PRESIDENT"           | "true"  |
        | "YOUNG_WOMEN_SECOND_COUNSELOR"    | "true"  |
        | "SUNDAY_SCHOOL_PRESIDENT"         | "true"  |
        | "MEMBER1"                         | "false" |
        | "MEMBER2"                         | "false" |
#        | "SUNDAY_SCHOOL_FIRST_COUNSELOR"   | "true"     |
#        | "WARD_MISSION_LEADER"             | "true"     |

    @jft
    Scenario: Check the creation and deleting of lists
      Given a member creates a list
      Then the new list will be displayed
      And the list is deleted
      Then the list will not be displayed

