Feature: Check the Google page
  Background:
    Given Selenium Driver is initialized


  Scenario: Navigate to Google
    Given The "https://google.com" page opened in browser
    Then Page Title should contain "Google"