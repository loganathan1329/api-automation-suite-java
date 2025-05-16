Feature: Book Store API Operations
  As an API user
  I want to perform CRUD operations on books
  So that I can manage the bookstore inventory

  Scenario: Create and retrieve a book
    Given the book API is available
    When I create a new book with title "Clean Code", author "Robert Martin", year 2008 and price 35.99
    Then the book should be created successfully
    And I should be able to retrieve the book details

  Scenario: Update a book
    Given the book API is available
    And I have an existing book
    When I update the book title to "Clean Code: A Handbook of Agile Software Craftsmanship"
    Then the book should be updated successfully
    And the updated title should be reflected

  Scenario: Delete a book
    Given the book API is available
    And I have an existing book
    When I delete the book
    Then the book should be deleted successfully
    And the book should no longer be available
