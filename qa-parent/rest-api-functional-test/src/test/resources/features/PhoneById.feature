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