@RecordOrdination
  Feature: Test Record Ordinations

    #deacon teacher priest
    #Officator - Member of Household, Member of Ward or Branch, Member Outside of Ward or Branch
    #Other Date
    #Do a random leader instead of BISHOP?
    @MQA-5387 @MQA-2225 @jft
    Scenario Outline: As a leader Record Priesthood Ordination - Aaronic
      Given a <leader> logs in and is on the Record Ordination page
      When a Aaronic Priesthood Ordination is submitted for <memberRecord> with <priesthoodOffice> and the <date> by <officiator>
      Then the Ordination should be updated with <memberRecord> , <priesthoodOffice> , <date> and <officiator>
      Examples:
        | leader   | memberRecord            | priesthoodOffice | date           | officiator       |
        | "BISHOP" | "Barba, Cristian Jesus" | "Priest"         | "Current date" | "Young, Gregory" |

#      TODO: Need to automate the following
    @MQA-5388 @MQA-2225
    Scenario: Submit Priesthood Ordination - Melchizedek - Elders
      Given a "BISHOP" logs in and is on the Record Ordination page
      When a Elders priesthood ordination is submitted
      Then the Ordination should be updated

    @MQA-5389 @MQA-2225
    Scenario: Submit Priesthood Ordination - Melchizedek - High Priest
      Given a "BISHOP" logs in and is on the Record Ordination page
      When a High Priest priesthood ordination is submitted
      Then the Ordination should be updated

    @MQA-5390 @MQA-2225
    Scenario: Filter Ordinations show proposed ordinations
      Given a "BISHOP" logs in and is on the Record Ordination page
      When the filter Show proposed ordinations is selected
      Then the proposed ordinations should be displayed

    @MQA-5391 @MQA-2225
    Scenario: Filter Ordinations show pending ordinations
      Given a "BISHOP" logs in and is on the Record Ordination page
      When the filter Show pending ordinations is selected
      Then the pending ordinations should be displayed

    @MQA-5392 @MQA-2225
    Scenario: Record ordination from member details
      Given a "BISHOP" logs in and is on the Membership Information page
      When a Record Ordinance is submitted
      Then the Ordination should be updated

    @MQA-5393 @MQA-2225
    Scenario: Record ordination from member details sister
      Given a "BISHOP" logs in and is on the Directory page
      When a sister Membership information page is selected
      Then Record Ordinance should not be displayed

    @MQA-5394 @MQA-2225
    Scenario: Record Ordination in airplane mode
      Given a "BISHOP" logs in and is on the Record Ordination page
      When the device is put into airplane mode
      And a Ordination is submitted
      Then the Ordination will be submitted when airplane mode is off

#    Scenario: Priesthood ordination from Priest to Deacon - error? Not possible?
#    Scenario: Ordination by someone that doesn't hold office - error or not possible?
#    Scenario: Edit ordinations?
#    Scenario: Who can record ordinations? API test? Rights?
#    Scenario: Bad MRN?
#    Scenario: Test Search
#    Scenario: Test Cancel
#    Scenario: Test Analytics
#    Scenario: Record same ordination at the same time?
#    Scenario: Set date to year of 1900
#    Scenario: Check candidates all are showing up?




