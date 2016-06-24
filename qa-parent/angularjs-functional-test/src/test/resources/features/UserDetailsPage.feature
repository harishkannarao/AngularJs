Feature: User Details page feature

  Scenario Outline: should display user details for a user with role2 or role3
    Given I go to index page
    And I logout if already logged in
    And I go to user details page
    And I wait for 1 seconds
    And I print console output
    Then I should be on login page
    And I enter username as "<username>"
    And I enter password as "<password>"
    And I click on Login button
    And I wait for 1 seconds
    Then I should be on user details page
    And I should see Username as "<username>"
    And I should see some auth token
    And I should see roles as "<roles>"
    Examples:
      | username  | password  | roles             |
      | user1     | pass1     | role1,role2,role3 |
      | user4     | pass4     | role3             |
      | user5     | pass5     | role2             |

  Scenario Outline: should display error page for a user with role1 or empty roles
    Given I go to index page
    And I logout if already logged in
    And I go to user details page
    And I wait for 1 seconds
    And I print console output
    Then I should be on login page
    And I enter username as "<username>"
    And I enter password as "<password>"
    And I click on Login button
    And I print console output
    And I wait for 1 seconds
    And I print console output
    Then I should be on error page
    And I should see some error reference
    Examples:
      | username  | password  |
      | user2     | pass2     |
      | user3     | pass3     |