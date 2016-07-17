Feature: Auth Super Secret Endpoint
  Scenario Outline: should get unauthorized http response for any roles
    Given I get auth token for user <username> and password <password> for super secret endpoint
    And I make a GET request with logged in user to super secret endpoint
    Then I should get http response status as 401 from super secret endpoint
    Then I should get http forbidden response header as true from super secret endpoint
    Examples:
      | username  | password  |
      | user1     | pass1     |
      | user2     | pass2     |
      | user3     | pass3     |
      | user4     | pass4     |
      | user5     | pass5     |

  Scenario: should get unauthorized http response when not logged in
    Given I make a GET request without user headers to super secret endpoint
    Then I should get http response status as 401 from super secret endpoint
    Then I should get http forbidden response header as true from super secret endpoint

