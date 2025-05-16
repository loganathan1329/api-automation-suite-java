Feature: Customer Sign Up and Management
  As a bookstore customer
  I want to manage my profile
  So that I can place orders and track them

  Scenario: Create a new customer profile
    Given the customer API is available
    When I create a new customer with name "John Doe", email "john.doe@example.com", and address "123 Main St"
    Then the customer should be created successfully
    And I should be able to retrieve the customer details

  Scenario: Update customer profile
    Given the customer API is available
    And I have an existing customer
    When I update the customer address to "456 Oak Ave"
    Then the customer should be updated successfully
    And the updated address should be reflected

  Scenario: Deactivate customer account
    Given the customer API is available
    And I have an existing customer
    When I deactivate the customer account
    Then the customer should be marked as inactive
