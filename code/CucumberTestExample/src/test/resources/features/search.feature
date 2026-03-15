Feature: Search
  Scenario: Search UAH degrees
    Given the user is located in the index page
    When the user enters studies section
    And the user clicks in the degree section
    Then the page with the degrees is shown

    @Sikuli
  Scenario: Search information protocols UAH EPS for Covid-19
    Given the user is located in the index page
    When the user enters the Covid-19 information
    And the user clicks at the Protocols from EPS
    Then the page from general information from UAH regarding Covid-19 is shown
