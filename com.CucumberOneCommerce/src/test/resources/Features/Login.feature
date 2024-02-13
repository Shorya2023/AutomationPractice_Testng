
Feature: Login to application with valid credentials

  @production
  Scenario: Login to no commerce
    When User launch URL 
    And  User enter valid username and password
    When User click on Login 
    Then  User able to login successfully and verify home page title
    Then Close the browser
    
    
   