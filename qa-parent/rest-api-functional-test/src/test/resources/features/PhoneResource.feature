Feature: Phone resource feature
  Scenario: should get all phones
    Given I set the url to get all phones on phone resource
    And I make a GET request on phone resource
    Then I should get http response status as 200 from phone resource
    And I should see number of phones as 3 from phone resource
    And I should see the following phone details from phone resource
      | name                      | age | snippet                             |
      | Nexus S                   | 1   | Fast just got faster with Nexus S.  |
      | Motorola XOOM with Wi-Fi  | 2   | The Next, Next Generation tablet.   |
      | MOTOROLA XOOM             | 3   | The Next, Next Generation tablet.   |
