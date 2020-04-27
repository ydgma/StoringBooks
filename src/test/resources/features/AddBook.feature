Feature: Adding a book to the database

  Scenario Outline: User is able to successfully add a <Book Type> to the database
  When I add a "Book Type"
  Then the book is successfully added to the database
  Examples:
    |Book Type|
    | PDF     |
    | UTF8    |