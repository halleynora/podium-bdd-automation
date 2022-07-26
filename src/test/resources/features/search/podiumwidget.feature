Feature: Podium Widget Functional Tests

  @regression @smoke
  Scenario: Load Widget | Close Widget
    Given Podium widget page is loaded
    And click widget on bottom right corner of page
    Then assert widget is loaded
    And click wiget X close button
    Then assert widget is closed

  @regression @smoke
  Scenario Outline: Maximized Widget | Search
    Given Podium widget page is loaded
    And click widget on bottom right corner of page
    Then assert widget is loaded
    Then clear search input field
    And search for <zipcode>
    Then assert 3 search results are displayed and clickable
    Then click wiget X close button

    Examples:
      | zipcode |
      | 85018 |
      | 90210 |
      | 94105 |
      | 85251 |

    @regression @smoke
  Scenario: Maximized Widget | Validate Contact Form Submission
    Given Podium widget page is loaded
    And click widget on bottom right corner of page
    Then assert widget is loaded
    Then clear search input field
    And search for 85018
    Then assert 3 search results are displayed and clickable
    And click on first search result
    Then assert form is displayed
    And click SEND button
    Then assert validation message "Name is required" is displayed
    Then assert validation message "Mobile phone is required" is displayed
    Then assert validation message "Message is required" is displayed
    Then click wiget X close button

    @regression
  Scenario: Maximized Widget | Contact Form Page Layout
    Given Podium widget page is loaded
    And click widget on bottom right corner of page
    Then assert widget is loaded
    Then clear search input field
    And search for 85018
    Then assert 3 search results are displayed and clickable
    And click on first search result
    Then assert form is displayed
    Then assert Header text is visible
    Then assert back arrow is visible and clickable
    Then assert Footer text is visible
    Then assert Terms of Use link is visible and clickable
    Then click wiget X close button

  @regression
  Scenario: Maximized Widget | Navigate to Terms Of Use
    Given Podium widget page is loaded
    And click widget on bottom right corner of page
    Then assert widget is loaded
    Then clear search input field
    And search for 85018
    Then assert 3 search results are displayed and clickable
    And click on first search result
    Then assert form is displayed
    And click link Use is subject to terms
    Then assert a new web page is opened and url is "https://legal.podium.com/#aup-us"

