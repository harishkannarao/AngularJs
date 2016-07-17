Feature: Auth Logout Endpoint
  Scenario: should be able to logout with valid auth id and auth token
    Given I get auth token for user "user1" and password "pass1"
    Then I should get http status 200 from auth access endpoint
    And I logout with the logged in user and auth token
    Then I should get http status 401 from auth access endpoint

  Scenario: should not be able to logout with incorrect auth id
    Given I get auth token for user "user1" and password "pass1"
    Then I should get http status 200 from auth access endpoint
    And I logout with the user "user2" and logged in auth token
    Then I should get http status 200 from auth access endpoint

  Scenario: should not be able to logout with incorrect auth token
    Given I get auth token for user "user1" and password "pass1"
    Then I should get http status 200 from auth access endpoint
    And I logout with the logged in user and auth token as "something_junk"
    Then I should get http status 200 from auth access endpoint
