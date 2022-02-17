@MoveRecordsInAndOut
Feature: Test moving records in and out of a unit

  @jft
  Scenario: Move in elements check
    Given a "BISHOP" logs in and is on Move Records In and Out page for "Elements Checker"
    When move in is selected
    Then the move in elements should be correct

  #MOVE IN
#  #todo: Map test
#  Scenario Outline: Move members in
#    Given a <leader> logs in and is on Move Records In and Out page for <notes>
#    When a <member> is moved in using <lookup>
#    And Select Members is <selectMembers>
#    And the <addressType> if filled out with <addressInfo>
#    Then the member should be moved
#    Examples:
#      | leader   | member                                      | lookup        | selectMembers | addressType          | addressInfo                                                        | notes                                      |
#      | "BISHOP" | "MRN NUMBER"                                | "MRN"         | "Member Name" | "Address Known"      | "United States - Address1 - Address2 - City - State - Postal Code" | "Single member - MRN"                      |
#      | "BISHOP" | "MRN NUMBER"                                | "MRN"         | "All Members" | "Address Known"      | "United States - Address1 - Address2 - City - State - Postal Code" | "Family - MRN"                             |
#      | "BISHOP" | "Last Name - First Name - Gender - Country" | "More Search" | "Member Name" | "Address Known"      | "United States - Address1 - Address2 - City - State - Postal Code" | "Single member - lookup"                   |
#      | "BISHOP" | "Last Name - First Name - Gender - Country" | "More Search" | "All Members" | "Address Known"      | "United States - Address1 - Address2 - City - State - Postal Code" | "Family - lookup"                          |
#      | "BISHOP" | "MRN NUMBER"                                | "MRN"         | "One Member"  | "Address Known"      | "United States - Address1 - Address2 - City - State - Postal Code" | "One Member from family - MRN"             |
#      | "BISHOP" | "MRN NUMBER"                                | "MRN"         | "Member Name" | "Address Unchanging" | "Address Unchanging"                                               | "Single member - MRN - address unchanging" |
#      | "BISHOP" | "MRN NUMBER"                                | "MRN"         | "Member Name" | "Joining Household"  | "Household to join"                                                | "Single member - MRN - Join Household"     |
#
#  #MOVE OUT
#  Scenario Outline: Move members out
#    Given a <leader> logs in and is on Move Records In and Out page for <notes>
#    When a <member> is moved out
#    And Select Members is <selectMembers>
#    And the <addressType> if filled out with <addressInfo>
#    And the <selectUnit> is selected
#    Then the member should be moved
#    Examples:
#      | leader   | member        | selectUnit        | selectMembers | addressType          | addressInfo                                                        | notes                             |
#      | "BISHOP" | "Member Name" | "Some Unit"       | "Member Name" | "Address Known"      | "United States - Address1 - Address2 - City - State - Postal Code" | "Single member - Address Known"   |
#      | "BISHOP" | "Member Name" | "Some Unit"       | "All Members" | "Address Unchanging" | "None"                                                             | "Family - Address Unchanging"     |
#      | "BISHOP" | "Member Name" | "Some Unit"       | "Member Name" | "Joining Household"  | "Household Name"                                                   | "Single member - Join Household"  |
#      | "BISHOP" | "Member Name" | "Unit Not Listed" | "Member Name" | "Address Unchanging" | "None"                                                             | "Single member - Unit Not Listed" |







#    Scenario: Move one member of a family into the same ward as head of household #child moving out to same ward
#    Scenario: Move half of a family out
#    Scenario: Move out - death #at least when a member dies they show up in the moved out report

#    Scenario: Invalid MRN
#    Scenario: Invalid lookup info
#    Scenario: Invalid contact info