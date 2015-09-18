Feature: Phones Resource
  Scenario: should get all phones details
    Given I set the url to phones resource
    And I make a GET request on phones resource
    Then I should get http response status as 200 from phones resource
    And I should see number of phones as 3 from phones resource
    And I should see the following phone summary from phones resource
      | id  | name                      | age | snippet                             |
      | 1   | Nexus S                   | 1   | Fast just got faster with Nexus S.  |
      | 2   | Motorola XOOM with Wi-Fi  | 2   | The Next, Next Generation tablet.   |
      | 3   | MOTOROLA XOOM             | 3   | The Next, Next Generation tablet.   |

  Scenario: should be able to see images of all phones
    Given I set the url to phones resource
    And I make a GET request on phones resource
    Then I should be able to get image for every phone summary from phones resource