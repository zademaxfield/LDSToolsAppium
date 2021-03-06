@PaymentRequests
Feature: Payment Requests - be able to submit a payment from Member Tools

  @jft
  Scenario Outline: As a member enter in a new payment request - Choose file
    Given a <member> is on the Finance page
    When a payment request is filled out for <payee> <purpose> <account> <addReceipt> <salesTaxAmount> <category> <categoryAmount>
    Then the payment request should be processed with information of <member> <payee> <purpose> <account> <addReceipt> <salesTaxAmount> <category> <categoryAmount>
    Examples:
      | member      | payee               | purpose     | account   | addReceipt  | salesTaxAmount  | category      | categoryAmount |
      | "BISHOP"    | "myself"            | "Primary"   | "US-USD"  | "fileName"  | ".25"           | "Primary"     | "2.00"         |
#      | "MEMBER1"   | "myself"           | "Primary"   | "US-USD"  | "picture"   | ".25"           | "Primary"     | "2.00"         |
#      | "MEMBER1"   | "Other Person"     | "Primary"   | "US-USD"  | "fileName"  | ".25"           | "Primary"     | "2.00"         |
#      | "MEMBER1"   | "add other payee"  | "Primary"   | "US-USD"  | "fileName"  | ".25"           | "Primary"     | "2.00"         |

  Scenario: As a member add a payment request with multiple categories
    Given a "MEMBER1" is on the Finance page
    When a payment request is filled out with the categories and amounts of cat1 amount1, cat2 amount2, cat3 amount3
    Then the payment request will show the multiple categories


  Scenario: As a member edit a payment request
    Given a "MEMBER1" is on the Finance page and has a payment request that is not finished
    When an unfinished payment request is selected
    Then the member will finish the payment request

#  This may not be possible
  Scenario: Try to enter an Invalid amount
    Given a "MEMBER1" is on the Finance page
    When $#@%^&%$&#$^%$@ is entered in as a category amount
    Then Some error should happen

  Scenario: Too large of amount
    Given a "MEMBER1" is on the Finance page
    When 500,000,000,000 is entered in as a category amount
    Then Some error should happen

  Scenario: Enter in very large purpose
    Given a "MEMBER1" is on the Finance page
    When "Look,  strange women lying on their backs in ponds handing out swords... that's no basis for a system of government.  Supreme executive power derives from a mandate from the masses, not from  some farcical aquatic ceremony." is entered in the purpose
    Then Some error should happen

  Scenario: Start payment request then remove
    Given a "MEMBER1" is on the Finance page
    When a payment request is started then canceled
    Then the payment request should show up on the payment request page

#  Scenario: As a leader check status of payment request?