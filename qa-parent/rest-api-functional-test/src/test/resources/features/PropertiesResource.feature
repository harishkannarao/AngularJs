Feature: Properties Resource

  Scenario: should load properties file from module configuration
    Given I set the url to module on properties resource
    And I make a GET request on properties resource
    Then I should get http response status as 200 from properties resource
    And I should see sampleString as "My Sample String" from properties resource
    And I should see sampleStringArray as below from properties resource
      | Value 1 |
      | Value 2 |
      | Value 3 |
    And I should see sampleLong as 10 from properties resource