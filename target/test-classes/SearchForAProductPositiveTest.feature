Feature: Basic logic for Login with valid email (Positive)
  In order to be able to use the full list of functionalities of the site
  as an already registered user
  I want to be able to log in to the site with a valid email and password

  Scenario: Searching for a product

    Given Customer is on Home page
    And enters a Product name in the Search field
    When clicks Search button
    Then searched Product is successfully displayed