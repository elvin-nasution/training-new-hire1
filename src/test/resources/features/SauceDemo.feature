@SauceDemoFeature
  Feature: As a user i want to log in to the webpage

    @Positive @Regression
    Scenario Outline: User should be able to see homepage
      Given user open sauce demo home page
      Then user should be able to see "Username and Password Input Field"
      When user type "standard_user" in username field
      When user type "secret_sauce" in password field
      When user click on button login
      Then user should be able to see product page
      Examples: