Feature: Phone by id resource

  Scenario: should get phone by id
    Given I set the url to phone by id resource
    And I set the phone id as 1 to phone by id resource
    And I make a GET request on phone by id resource
    Then I should get http response status as 200 from phone by id resource

  Scenario: should get additional features of phone by id
    Given I set the url to phone by id resource
    And I set the phone id as 1 to phone by id resource
    And I make a GET request on phone by id resource
    Then I should see the additional features as "Contour Display, Near Field Communications (NFC), Three-axis gyroscope, Anti-fingerprint display coating, Internet Calling support (VoIP/SIP)" from phone by id resource

  Scenario: should get android details of phone by id
    Given I set the url to phone by id resource
    And I set the phone id as 1 to phone by id resource
    And I make a GET request on phone by id resource
    Then I should see android os as "Android 2.3" from phone by id resource
    Then I should see android ui as "Android" from phone by id resource

  Scenario: should get availability list of phone by id
    Given I set the url to phone by id resource
    And I set the phone id as 1 to phone by id resource
    And I make a GET request on phone by id resource
    Then I should see availability list as below from phone by id resource
      | M1       |
      | O2       |
      | Orange   |
      | Singtel  |
      | StarHub  |
      | T-Mobile |
      | Vodafone |

  Scenario: should get battery details of phone by id
    Given I set the url to phone by id resource
    And I set the phone id as 1 to phone by id resource
    And I make a GET request on phone by id resource
    Then I should see battery standby time as "428 hours" from phone by id resource
    Then I should see battery talk time as "6 hours" from phone by id resource
    Then I should see battery type as "Lithium Ion (Li-Ion) (1500 mAH)" from phone by id resource