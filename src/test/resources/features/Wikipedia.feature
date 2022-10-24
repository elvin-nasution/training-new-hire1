@Regression @WikipediaFeature
Feature: Testing Wikipedia Website

  Scenario Template: Search some fruits
    Given user open Wikipedia
    When user search fruit '<fruit>'
    Then user should be able to see '<fruit>' page
    @Positive
    Examples:
      | fruit  |
      | kiwi   |
      | apple  |
      | banana |
    @Negative
    Examples:
      | fruit    |
      | sadsadsa |