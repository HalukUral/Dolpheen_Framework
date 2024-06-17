Feature: Amazon search functionality
  Agile Story: As a user, When I am on the Amazon home page,
  I should be able to search whatever I want to buy
@title
  Scenario: Search page title verification
    When user is on Amazon homepage
    Then user should see title is Amazon