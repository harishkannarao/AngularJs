Feature: Login page feature

  Scenario: should be able to perform basic login and logout
    Given I go to index page
    Then I should be on phone list page
    And I logout if already logged in
    Then I should see "Login" link
    And I click on Login link
    Then I should be on login page
    And I enter username as "user1"
    And I enter password as "pass1"
    And I click on Login button
    Then I should be on phone list page
    And I should see "User Details" link
    And I should see "Logout" link
    And I should not see "Login" link
    And I click on Logout link
    Then I should be on phone list page
    And I should not see "User Details" link
    And I should not see "Logout" link
    And I should see "Login" link