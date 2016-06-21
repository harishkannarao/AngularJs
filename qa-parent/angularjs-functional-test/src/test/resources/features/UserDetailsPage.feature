Feature: User Details page feature

  Scenario Outline: should display user details for a user with role2 and role3
    Given I go to index page
    And I logout if already logged in
    And I go to user details page
    And I wait for 1 seconds
    Then I should be on login page
    And I enter username as "<username>"
    And I enter password as "<password>"
    And I click on Login button
    And I wait for 1 seconds
    Then I should be on user details page
    And I should see Username as "<username>"
    And I should see some auth token
    Examples:
      | username  | password  |
      | user1     | pass1     |