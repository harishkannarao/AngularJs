Feature: Auth Access Endpoint
  Scenario: should be able to get auth access element as a user with role2
    Given I authenticate with user "user1" and password "pass1" with auth login endpoint
    And I set the url to auth access endpoint
    And I set the authId header to auth access endpoint
    And I set the authToken header to auth access endpoint
    And I make a GET request to auth access endpoint
    Then I should get http response status as 200 from auth access endpoint
    And I should see authId as "user1" from auth access endpoint
    And I should see non empty authToken from auth access endpoint
    And I should see authPermissions as below from auth access endpoint
      | role1 |
      | role2 |
      | role3 |

  Scenario: should be able to get auth access element as a user with role3

  Scenario: should not be able to get auth access element as a user not having role2 or role3

  Scenario: should not be able to get auth access element as a user with incorrect token

  Scenario: should not be able to get auth access element with incorrect user