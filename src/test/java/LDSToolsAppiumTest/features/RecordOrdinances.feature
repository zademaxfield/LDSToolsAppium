@RecordOrdination
  Feature: Test Record Ordinations

    #deacon teacher priest
    #Officator - Member of Household, Member of Ward or Branch, Member Outside of Ward or Branch
    #Other Date
    #Do a random leader instead of BISHOP?
    @jft
    Scenario Outline: As a leader Record Priesthood Ordination - Aaronic
      Given a <leader> logs in and is on the Record Ordination page
      When a Aaronic Priesthood Ordination is submitted for <memberRecord> with <priesthoodOffice> and the <date> by <officiator>
      Then the Ordination should be updated with <memberRecord> , <priesthoodOffice> , <date> and <officiator>
      Examples:
        | leader   | memberRecord            | priesthoodOffice | date            | officiator       |
        | "BISHOP" | "Barba, Cristian Jesus" | "Priest"         | "Current date?" | "Young, Gregory" |
#        | "BISHOP" | "Some, Member " | "priest"         | "Current date?" | "Member of Ward"      |
#        | "BISHOP" | "Some, Member " | "priest"         | "Current date?" | "Outside of Ward"     |
#        | "BISHOP" | "Some, Member " | "teacher"        | "Current date?" | "Member of household" |
#        | "BISHOP" | "Some, Member " | "teacher"        | "Current date?" | "Member of Ward"      |
#        | "BISHOP" | "Some, Member " | "teacher"        | "Current date?" | "Outside of Ward"     |
#        | "BISHOP" | "Some, Member " | "deacon"         | "Current date?" | "Member of household" |
#        | "BISHOP" | "Some, Member " | "deacon"         | "Current date?" | "Member of Ward"      |
#        | "BISHOP" | "Some, Member " | "deacon"         | "Current date?" | "Outside of Ward"     |


    Scenario: Submit Priesthood Ordination - Melchizedek - Elders
      Given a "BISHOP" logs in and is on the Record Ordination page
      When a Elders priesthood ordination is submitted
      Then the Ordination should be updated

    Scenario: Submit Priesthood Ordination - Melchizedek - High Priest
      Given a "BISHOP" logs in and is on the Record Ordination page
      When a High Priest priesthood ordination is submitted
      Then the Ordination should be updated

    Scenario: Filter Ordinations show proposed ordinations
      Given a "BISHOP" logs in and is on the Record Ordination page
      When the filter Show proposed ordinations is selected
      Then the proposed ordinations should be displayed


    Scenario: Filter Ordinations show pending ordinations
      Given a "BISHOP" logs in and is on the Record Ordination page
      When the filter Show pending ordinations is selected
      Then the pending ordinations should be displayed

#  Scenario: Record ordination from member details
#    Scenario: Priesthood ordination from Priest to Deacon - error? Not possible?
#    Scenario: Ordination by someone that doesn't hold office - error or not possible?
#    Scenario: Edit ordinations?
#    Scenario: Who can record ordinations? API test? Rights?
#    Scenario: Bad MRN?
#    Scenario: Test Search
#    Scenario: Test Cancel
#  Scenario: Test Analytics
#  Scenario: No internet
#  Scenario: Record same ordination at the same time?
#  Scenario: Set date to year of 1900
#  Scenario: Check candidates all are showing up?




