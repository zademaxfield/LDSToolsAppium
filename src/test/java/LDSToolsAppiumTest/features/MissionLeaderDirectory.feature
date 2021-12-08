@MissionLeaderDirectory
  Feature: Test Mission Leader directory

#    Mission Pres: olausondj
#    Member: hansenji

#    Returned Missionary: zsgallafent
#    His Mission President: kumfy
#
#    A Current Mission President: perezdomingo
#    His Companion: magdelis1
#
  @MQA-5396 @MQA-2223
  Scenario: Mission President login and can view returned missionaries
    Given a Mission President logs in
    When they check their Mission under Directory
    Then they should see a list of their missionaries

  @MQA-5400 @MQA-2223  @jft
  Scenario: Mission President companion see all mission
    Given a Mission President companion logs in
    When they check their Mission under Directory
    Then they should see a list of their missionaries

  @MQA-5397 @MQA-2223
  Scenario: Mission President contacts missionary
    Given a Mission President logs in
    When they select a missionary under their mission
    Then they should have contact information

  @MQA-5398 @MQA-2223
  Scenario: Missionary sign up in Whats New
    Given a returned missionary logs in
    When the Whats New Page is displayed
    Then the missionary opt in will be displayed

      #Need setup?
  @MQA-5400 @MQA-2223
  Scenario: Mission President viewing a Return Missionary info marked private
    Given a Mission President logs in
    When they check their Mission under Directory
    Then the Returned Missionary info should be marked private


  @MQA-5400 @MQA-2223
  Scenario: Returned Missionary remove Mission President access
    Given a returned missionary logs in
    When the Mission President is turned off
    Then the Mission President will not see the Returned Missionary






    #There is a bug in iOS MMIP-6309
  @MQA-5399 @MQA-2223
  Scenario: Missionary sign up in Settings
    Given a returned missionary logs in
    When the Settings page is selected
    Then the missionary opt in will be displayed


#  Scenario: Mission President divorce or widow can companion see Returned Missionaries ## Not sure what happens here
#  Scenario: Notification test - part of other tests?
#  Scenario: Full size photos
#  Scenario: New Missionary notification Jeremymunoz2013
#  Scenario: Email form





