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

  Scenario: should not be able to login with invalid credentials
    Given I go to login page
    Then I should be on login page
    And I enter username as "junk_user_name"
    And I enter password as "junk_password"
    And I click on Login button
    And I wait for 1 seconds
    Then I should be on login page

  Scenario: should be able to return back to home page by clicking home link
    Given I go to login page
    Then I should be on login page
    And I click on "Home" link on login page
    Then I should be on phone list page

  Scenario: should be redirected to phone list page as default landing page after successful login
    Given I go to login page
    Then I should be on login page
    And I enter username as "user1"
    And I enter password as "pass1"
    And I click on Login button
    And I wait for 1 seconds
    Then I should be on phone list page

  Scenario: should be able to perform login from a specific page and redirected back to the specific page after login
    Given I go to index page
    And I logout if already logged in
    Given I go to phone details page with phone id as 1
    Then I should be on phone details page
    Then I should see "Login" link
    And I click on Login link
    Then I should be on login page
    And I enter username as "user1"
    And I enter password as "pass1"
    And I click on Login button
    And I wait for 1 seconds
    Then I should be on phone details page
    And I should see "Logout" link
    And I click on Logout link
    Then I should be on phone list page