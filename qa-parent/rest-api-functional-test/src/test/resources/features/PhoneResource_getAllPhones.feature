Feature: Resource: Phone Resource, Operation: getAllPhones
  Scenario: should get all phones details
    Given I set the url to getAllPhones on phone resource
    And I make a GET request on phone resource
    Then I should get http response status as 200 from phone resource
    And I should see number of phone summaries as 3 from phone resource
    And I should see the following phone summary from phone resource
      | id  | name                      | age | snippet                             |
      | 1   | Nexus S                   | 1   | Fast just got faster with Nexus S.  |
      | 2   | Motorola XOOM with Wi-Fi  | 2   | The Next, Next Generation tablet.   |
      | 3   | MOTOROLA XOOM             | 3   | The Next, Next Generation tablet.   |

  Scenario: should be able to see images of all phones
    Given I set the url to getAllPhones on phone resource
    And I make a GET request on phone resource
    Then I should be able to get image for every phone summary from phone resource