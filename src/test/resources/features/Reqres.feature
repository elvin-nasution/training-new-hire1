@Regression @ReqresFeature
Feature: Testing reqres API

  Scenario Template: Get list of users based on page number <page number>
    Given I want to get users data for page <page number>
    When I retrieve list of users data
    Then I should get list of users
    Examples:
      | page number |
      | 1           |
      | 2           |
      | 3           |
