Feature: Ping Page feature

  Scenario: should see ping page
    Given I go to ping page
    Then I should be on ping page
    And And I should url as "http://localhost:8080/angularjs/ping.html" on ping page