Feature: Auth Access Endpoint

  Scenario Outline: should be able to get auth access element as a user with role2 or role3
    Given I authenticate with user "<username>" and password "<password>" with auth login endpoint
    And I set the url to auth access endpoint
    And I set the authId header to auth access endpoint
    And I set the authToken header to auth access endpoint
    And I make a GET request to auth access endpoint
    Then I should get http response status as 200 from auth access endpoint
    And I should see authId as "<username>" from auth access endpoint
    And I should see non empty authToken from auth access endpoint
    And I should see authPermissions as "<roles>" from auth access endpoint
    Examples:
      | username  | password  | roles             |
      | user1     | pass1     | role1,role2,role3 |
      | user4     | pass4     | role3             |
      | user5     | pass5     | role2             |

  Scenario Outline: should not be able to get auth access element as a user not having role2 or role3
    Given I authenticate with user "<username>" and password "<password>" with auth login endpoint
    And I set the url to auth access endpoint
    And I set the authId header to auth access endpoint
    And I set the authToken header to auth access endpoint
    And I make a GET request to auth access endpoint
    Then I should get http response status as 401 from auth access endpoint
    And I should get http forbidden response header as "true" from auth access endpoint
  Examples:
  | username  | password  |
  | user2     | pass2     |
  | user3     | pass3     |

  Scenario: should not be able to get auth access element as a user with incorrect token
    And I set the url to auth access endpoint
    And I set the authId header as "user2" to auth access endpoint
    And I set the authToken header as "someJunkToken" to auth access endpoint
    And I make a GET request to auth access endpoint
    Then I should get http response status as 401 from auth access endpoint
    And I should not get http forbidden response header from auth access endpoint

  Scenario: should not be able to get auth access element with incorrect user
    And I set the url to auth access endpoint
    And I set the authId header as "someJunkUser" to auth access endpoint
    And I set the authToken header as "someJunkToken" to auth access endpoint
    And I make a GET request to auth access endpoint
    Then I should get http response status as 401 from auth access endpoint
    And I should not get http forbidden response header from auth access endpoint