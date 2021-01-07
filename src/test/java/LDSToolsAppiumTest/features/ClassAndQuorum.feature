@ClassAndQuorum
  Feature: Class and Quorum Attendance tests

    @MQA-3517 @MQA-2225 @all
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
      | "RELIEF_SOCIETY_PRESIDENT"        | "Borden, Shirley"           | "true"     |
      | "RELIEF_SOCIETY_FIRST_COUNSELOR"  | "Borden, Shirley"           | "true"     |
      | "RELIEF_SOCIETY_SECOND_COUNSELOR" | "Borden, Shirley"           | "true"     |
      | "YOUNG_WOMEN_PRESIDENT"           | "Bryson, David"             | "true"     |
      | "YOUNG_WOMEN_SECOND_COUNSELOR"    | "Bryson, David"             | "true"     |
      | "SUNDAY_SCHOOL_PRESIDENT"         | "Bryson, David"             | "true"     |
      | "SUNDAY_SCHOOL_FIRST_COUNSELOR"   | "Bryson, David"             | "true"     |
      | "WARD_MISSION_LEADER"             | "Bryson, David"             | "true"     |


    @MQA-3518 @all @smoke
    Scenario Outline: Check edit rights in the API
      Given a <leader> account checks the Class and Quorum Attendance for the API
      Then the editable field is <status>
      Examples:
        | leader                            | status     |
        | "BISHOP"                          | "true"     |
        | "BISHOPRIC_SECOND_COUNSELOR"      | "true"     |
        | "BISHOPRIC_SECOND_COUNSELOR"      | "true"     |
        | "WARD_CLERK"                      | "true"     |
        | "WARD_EXECUTIVE_SECRETARY"        | "true"     |
        | "ELDERS_QUORUM_PRESIDENT"         | "true"     |
        | "ELDERS_QUORUM_FIRST_COUNSELOR"   | "true"     |
        | "ELDERS_QUORUM_SECOND_COUNSELOR"  | "true"     |
        | "ELDERS_QUORUM_SECRETARY"         | "true"     |
        | "RELIEF_SOCIETY_PRESIDENT"        | "true"     |
        | "RELIEF_SOCIETY_FIRST_COUNSELOR"  | "true"     |
        | "RELIEF_SOCIETY_SECOND_COUNSELOR" | "true"     |
        | "YOUNG_WOMEN_PRESIDENT"           | "true"     |
        | "YOUNG_WOMEN_SECOND_COUNSELOR"    | "true"     |
        | "SUNDAY_SCHOOL_PRESIDENT"         | "true"     |
        | "SUNDAY_SCHOOL_FIRST_COUNSELOR"   | "true"     |
        | "WARD_MISSION_LEADER"             | "true"     |

    @MQA-3519 @all @smoke
    Scenario: As a Bishopric member I should be able to mark a members attendance
      Given a member of the bishopric logs in and is on the Class and Quorum Attendance page
      When week one is marked attended
      Then week one will have a check mark

    @MQA-3520 @all @jft
    Scenario: As a Bishopric member I should have access to the filters in Class and Quorum Attendance
      Given a member of the bishopric logs in and is on the Class and Quorum Attendance page
      When filters is selected
      Then a list of classes will be displayed
      When I select a class
      Then The class list will be displayed

    @MQA-3520 @all
    Scenario: Check attendance from individual users page
      Given a member of the bishopric logs in and is on the Class and Quorum Attendance page
      When a member record is selected
      Then the individual attendance should be displayed



#    Scenario: Search tests - men, women, young adult and children.
#    Scenario: Check graph - ?
#    Scenario: Stake member?