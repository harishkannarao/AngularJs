Feature: Auth Login Endpoint
  Scenario: should be able to login with user and get authId
    Given I set the url to auth login endpoint
    And I set the username as "user3" to auth login endpoint
    And I set the password as "pass3" to auth login endpoint
    And I make a POST request to auth login endpoint
    Then I should get http response status as 200 from auth login endpoint
    And I should see authId as "user3" from auth login endpoint

  Scenario: should be able to login with user and get authToken
    Given I set the url to auth login endpoint
    And I set the username as "user3" to auth login endpoint
    And I set the password as "pass3" to auth login endpoint
    And I make a POST request to auth login endpoint
    Then I should get http response status as 200 from auth login endpoint
    And I should see non empty authToken from auth login endpoint

  Scenario: should be able to login with user and get empty authPermissions
    Given I set the url to auth login endpoint
    And I set the username as "user3" to auth login endpoint
    And I set the password as "pass3" to auth login endpoint
    And I make a POST request to auth login endpoint
    Then I should get http response status as 200 from auth login endpoint
    And I should see empty authPermissions from auth login endpoint

  Scenario: should be able to login with user and get authPermissions with single role
    Given I set the url to auth login endpoint
    And I set the username as "user2" to auth login endpoint
    And I set the password as "pass2" to auth login endpoint
    And I make a POST request to auth login endpoint
    Then I should get http response status as 200 from auth login endpoint
    And I should see authPermissions from auth login endpoint as below
    | role1 |

  Scenario: should be able to login with user and get authPermissions with multiple roles
    Given I set the url to auth login endpoint
    And I set the username as "user1" to auth login endpoint
    And I set the password as "pass1" to auth login endpoint
    And I make a POST request to auth login endpoint
    Then I should get http response status as 200 from auth login endpoint
    And I should see authPermissions from auth login endpoint as below
      | role1 |
      | role2 |
      | role3 |

  Scenario: should not be able to login with unknown user
    Given I set the url to auth login endpoint
    And I set the username as "unknown_user" to auth login endpoint
    And I set the password as "some_password" to auth login endpoint
    And I make a POST request to auth login endpoint
    Then I should get http response status as 400 from auth login endpoint
    And I should see application-validation-exception header as "true" from auth login endpoint

  Scenario: should not be able to login with incorrect password
    Given I set the url to auth login endpoint
    And I set the username as "user1" to auth login endpoint
    And I set the password as "incorrect_password" to auth login endpoint
    And I make a POST request to auth login endpoint
    Then I should get http response status as 400 from auth login endpoint
    And I should see application-validation-exception header as "true" from auth login endpoint

  Scenario: should get bad request from login endpoint for empty pay load
    Given I set the url to auth login endpoint
    And I set empty pay load to auth login endpoint
    And I make a POST request to auth login endpoint
    Then I should get http response status as 400 from auth login endpoint
    And I should see application-validation-exception header as "true" from auth login endpoint
    And I should see validation-exception header as "true" from auth login endpoint
    And I should see validation response as below from auth login endpoint
      | constraintType | path       | message         | value |
      | PARAMETER      | login.arg0 | may not be null |       |

  Scenario: should get bad request from login endpoint for null username and null password
    Given I set the url to auth login endpoint
    And I set the username as null to auth login endpoint
    And I set the password as null to auth login endpoint
    And I make a POST request to auth login endpoint
    Then I should get http response status as 400 from auth login endpoint
    And I should see application-validation-exception header as "true" from auth login endpoint
    And I should see validation-exception header as "true" from auth login endpoint
    And I should see validation response as below from auth login endpoint
      | constraintType | path                | message                 | value |
      | PARAMETER      | login.arg0.username | String must not be null |       |
      | PARAMETER      | login.arg0.password | String must not be null |       |

  Scenario: should get bad request from login endpoint for empty username and empty password
    Given I set the url to auth login endpoint
    And I set the username as "" to auth login endpoint
    And I set the password as "" to auth login endpoint
    And I make a POST request to auth login endpoint
    Then I should get http response status as 400 from auth login endpoint
    And I should see application-validation-exception header as "true" from auth login endpoint
    And I should see validation-exception header as "true" from auth login endpoint
    And I should see validation response as below from auth login endpoint
      | constraintType | path                | message                        | value |
      | PARAMETER      | login.arg0.username | String must match regex "^.+$" |       |
      | PARAMETER      | login.arg0.password | String must match regex "^.+$" |       |
